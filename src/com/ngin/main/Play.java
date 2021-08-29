package com.ngin.main;

import com.ngin.implementations.StudentSaveDao;
import com.ngin.implementations.StudentsQueryDao;

public class Play {

	public static void main(String[] args) {
		
		System.out.println("This is the Students HIBERNATE app");
		
		// we call service
		StudentSaveDao studentService = new StudentSaveDao();
		StudentsQueryDao searchStudents = new StudentsQueryDao();
		
		// we call for the process
		studentService.recordJohnStudent();
		/* notice that since we have enabled hibernate
		 * to display SQL back-end queries the console
		 * will demonstrate the JDBC code that hibernate
		 * auto generates */
		
		studentService.primaryKeyDemo();
		//this saves three students with auto increment
		
		studentService.readStudent();
		searchStudents.displayStudents();

	}

}
