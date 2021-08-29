package com.ngin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

// the goal is to just check that the JDBC connection works
// we right click and choose run as java app
public class ConCheck {

	public static void main(String[] args) {

		// the SSL = false gets rid of mySQL ssl warnings
		String URL = "jdbc:mysql://localhost:3306/fw_student_hb?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "ngin123";
		
		try {
			System.out.println("Connecting to database: " + URL);
			Connection myConn = 
					DriverManager.getConnection(URL, user, pass);
			System.out.println("Connection Successful!!!");
			
		// this connect successfully
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
