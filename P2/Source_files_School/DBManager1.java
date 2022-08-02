
package com.ExE2Lab3;

import java.util.ArrayList;

//This class is simulating a database for our
//program
public class DBManager1 {

    ArrayList <Course> courseList;

    public DBManager1 () {
        courseList = new ArrayList<Course>();
    }

    public ArrayList readFromDataBase() {
        // TODO Auto-generated method stub
        courseList.add(new Course ("ENGG", 233));
        courseList.add(new Course ("ENSF", 409));
        courseList.add(new Course ("PHYS", 259));
        courseList.add(new Course ("CPSC", 319));
        return courseList;
    }

}
