package com.ExE2Lab3;

import java.util.Scanner;
import java.util.ArrayList;

public class RegistrationApp {
	private Scanner scan;
	private ArrayList<Student> allStudents;
	private CourseCatalogue cat;

	RegistrationApp() {
		scan = new Scanner(System.in);
		allStudents = new ArrayList<Student>();
		cat = new CourseCatalogue();
	}

	public void setAllStudents(ArrayList<Student> allStudents) {
		this.allStudents = allStudents;
	}

	public void setCat(CourseCatalogue cat) {
		this.cat = cat;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public CourseCatalogue getCat() {
		return cat;
	}

	public ArrayList<Student> getAllStudents() {
		return allStudents;
	}

	public void displaySchool(){
		for(int i = 0; i < allStudents.size(); i++){
			System.out.println(allStudents.get(i).toString());
		}
	}

	public void createSchool() {
		allStudents.add(new Student("Sara", 1));
		allStudents.add(new Student("Sam", 2));
		allStudents.add(new Student("Bob", 3));
		allStudents.add(new Student("Jeff", 4));
		allStudents.add(new Student("Amir", 5));
		allStudents.add(new Student("Roger", 6));
		allStudents.add(new Student("Clay", 7));
		allStudents.add(new Student("Arnold", 8));
		allStudents.add(new Student("Max", 9));
		allStudents.add(new Student("Rebecca", 10));
		allStudents.add(new Student("Lexi", 11));
		allStudents.add(new Student("Jonas", 12));
		allStudents.add(new Student("Jennifer", 13));
		allStudents.add(new Student("Ava", 14));
	}

	public void createOfferings(CourseCatalogue cat){
		Course myCourse = cat.searchCat("ENGG", 233);
		if (myCourse != null) {
			cat.createCourseOffering(myCourse, 1, 100);
			cat.createCourseOffering(myCourse, 2, 200);
		}
		Course myCourse1 = cat.searchCat("ENSF", 409);
		if (myCourse1 != null) {
			cat.createCourseOffering(myCourse1, 1, 100);
			cat.createCourseOffering(myCourse1, 2, 200);
		}
		Course myCourse2 = cat.searchCat("PHYS", 259);
		if (myCourse2 != null) {
			cat.createCourseOffering(myCourse2, 1, 100);
			cat.createCourseOffering(myCourse2, 2, 200);
		}
		Course myCourse3 = cat.searchCat("CPSC", 319);
		if (myCourse3 != null) {
			cat.createCourseOffering(myCourse3, 1, 100);
			cat.createCourseOffering(myCourse3, 2, 200);
		}

		myCourse1.getPreReq().add(myCourse);
		myCourse3.getPreReq().add(myCourse);
	}
	public void enrollCourse(){
		System.out.println("The course catalogue is displayed above:");
		System.out.println("Please enter student id: ");
		int id = scan.nextInt();
		Student s = searchForStudent(id);
		System.out.println("Please enter course to enroll: ");
		String courseName = scan.next();
		System.out.println("Please enter course number: ");
		int num = scan.nextInt();
		Course course = getCat().searchCat(courseName, num);
		System.out.println("Please enter section 1 or 2");
		int section = scan.nextInt();
		Registration r = new Registration();
		if(s.hasPrereq(course) == true) {
			r.completeRegistration(s, course.getOfferingList().get(section - 1));
			s.addRegistration(r);
			s.addOffering(course.getOfferingList().get(section - 1));
			course.getOfferingList().get(section - 1).addStudent(s);
			return;
		}else
			System.out.println("Student doesn't have prerequisite\n");
	}

	public void viewEnrolledCourses(){
		System.out.println("Please enter the students id: ");
		int id = scan.nextInt();
		searchForStudent(id).printCourseLoad();
	}

	public void dropCourse(){
		System.out.println("Please enter id of student: ");
		int id = scan.nextInt();
		System.out.println("Please enter name of course you would like to drop: ");
		String cName = scan.next();
		System.out.println("PLease enter the course number: ");
		int num = scan.nextInt();
		searchForStudent(id).removeCourse(num);
		System.out.println("Course dropped!");

	}
	public void viewCatalogue(){
		System.out.println(getCat().toString());
	}

	public void searchCatalogue(){
		System.out.println("Please enter course name: \n");
		String name = scan.nextLine();
		System.out.println("Please enter course number: \n");
		int num = scan.nextInt();
		Course searched = getCat().searchCat(name, num);
		System.out.println(searched.toString());
	}

	public Student searchForStudent(int id){
		int i;
		for(i = 0; i < allStudents.size(); i++){
			if(allStudents.get(i).getStudentId() == id){
				break;
			}
		}
		return allStudents.get(i);
	}

	public void printMenu() {
		System.out.println("Please Select one of the following options:");
		System.out.println("1. Search catalogue courses");
		System.out.println("2. Add course to student courses");
		System.out.println("3. Remove course from student courses");
		System.out.println("4. View all courses in catalogue");
		System.out.println("5. View all courses taken by student");
		System.out.println("6. Quit");
		System.out.println("What would you like to do?\n");

	}

	public void menu(CourseCatalogue cat) {
		while (true) {
			printMenu();
			int choice = scan.nextInt();
			scan.nextLine();

			switch (choice) {
				case 1:
					searchCatalogue();
					break;
				case 2:
					viewCatalogue();
					enrollCourse();
					break;
				case 3:
					dropCourse();
					break;
				case 4:
					viewCatalogue();
					break;
				case 5:
					viewEnrolledCourses();
					break;
				case 6:
					displaySchool();
					break;
				case 7:
					System.out.println("See you later!");
					return;
				default:
			}
		}
	}
}


