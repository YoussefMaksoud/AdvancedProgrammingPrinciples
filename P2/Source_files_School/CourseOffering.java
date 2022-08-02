package com.ExE2Lab3;
import java.util.ArrayList;

public class CourseOffering {
	
	private int secNum;
	private int secCap;
	private Course theCourse;
	private ArrayList<Student> studentList;
	private ArrayList <Registration> offeringRegList;
	
	public CourseOffering (int secNum, int secCap) {
		this.setSecNum(secNum);
		this.setSecCap(secCap);
		offeringRegList = new ArrayList <Registration>();
		studentList = new ArrayList<Student>();
	}

	public ArrayList<Registration> getOfferingRegList() {
		return offeringRegList;
	}

	public int getSecNum() {
		return secNum;
	}
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	public int getSecCap() {
		return secCap;
	}
	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}
	public Course getTheCourse() {
		return theCourse;
	}
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void addStudent(Student s){
		studentList.add(s);
	}
	public void removeStudent(Student s){
		int i;
		for(i = 0; i < studentList.size(); i++){
			if(studentList.get(i).getStudentId() == s.getStudentId()) break;
		}
		studentList.remove(i);
	}

	@Override
	public String toString () {
		String st = "\n";
		st += getTheCourse().getCourseName() + " " + getTheCourse().getCourseNum() + "\n";
		st += "Section Num: " + getSecNum() + ", section cap: "+ getSecCap() +"\n";
		if(studentList.size() >= 8) st += "(Course is Running)" + "\n";
		else st += "(Course is not yet running)" + "\n";
		for(int i = 0; i < studentList.size(); i++){
			st += studentList.get(i).getStudentName() + "\n";
		}
		return st;
	}
	public void addRegistration(Registration registration) {
		// TODO Auto-generated method stub
		offeringRegList.add(registration);
		
	}
	
	

}
