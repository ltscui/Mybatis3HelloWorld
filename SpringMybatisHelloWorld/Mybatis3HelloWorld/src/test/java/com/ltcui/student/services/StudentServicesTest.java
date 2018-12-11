package com.ltcui.student.services;

import com.ltcui.student.Student;
import com.ltcui.student.services.StudentServices;

public class StudentServicesTest {

	public static void testGetStudentById(String stuId){
		StudentServices services = new StudentServices();
		Student studnet = services.getStudentById(stuId);
		System.out.println(studnet.toString());
	}
	
	public static void main(String[] args) {
		testGetStudentById("1");
	}
}
