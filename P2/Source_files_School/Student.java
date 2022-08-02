package com.ExE2Lab3;

import java.util.ArrayList;


public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList<CourseOffering> offeringList;
	private ArrayList<Registration> studentRegList; // enrolled courses
	
	public Student (String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		studentRegList = new ArrayList<Registration>();
		offeringList = new ArrayList<CourseOffering>();
	}
	public void addOffering(CourseOffering section){
		offeringList.add(section);
	}

	public ArrayList<CourseOffering> getOfferingList() {
		return offeringList;
	}

	public boolean hasPrereq(Course course){
		boolean b = false;
		if(course.getPreReq().isEmpty()) b = true;
		else {
			for (int i = 0; i < course.getPreReq().size(); i++) {
				for (int j = 0; j < offeringList.size(); j++) {
					if (offeringList.get(j).getTheCourse() == course.getPreReq().get(i)) {
						b = true;
						break;
					}
				}
			}
		}
		return b;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void printCourseLoad(){
		for(int i = 0; i < studentRegList.size(); i++){
			System.out.println(studentRegList.get(i).toString());
		}
	}
	public void removeCourse(int num){
		int i;
		for(i = 0; i < studentRegList.size(); i++){
			if(studentRegList.get(i).getTheOffering().getTheCourse().getCourseNum()
					== num){
				break;
			}
		}
		offeringList.get(i).removeStudent(this);
		offeringList.remove(i);
		studentRegList.remove(i);

	}
	@Override
	public String toString () {
		String st = "Student Name: " + getStudentName() + "\n" +
				"Student Id: " + getStudentId() + "\n\n";
		return st;
	}

	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		studentRegList.add(registration);
	}

}
