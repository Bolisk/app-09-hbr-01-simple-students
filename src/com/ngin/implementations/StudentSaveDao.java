package com.ngin.implementations;

import java.text.ParseException;
import java.util.Date;

//we choose the hibernate imports
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ngin.entities.Student;
import com.ngin.utils.DateUtils;

public class StudentSaveDao {


	
	public StudentSaveDao() {
		super();
	}


	//create session factory
	SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
	
	// here we create a method to save a specific student at DB
	public void recordJohnStudent() {
		// create a session - to make transactions
		Session session = factory.getCurrentSession();

		try {
			String theDateOfBirthStr = "31/12/1998";
			//because parse date might throw an exception we should have a catch case
		    Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			// create the student object - we also create a log notice
			System.out.println("Creating new Student Obj");
			Student tempStudent = new Student("John", "Smith", theDateOfBirth, "SmithJ@gmail.com");

			// start transaction - no object
			session.beginTransaction();

			// save the student - log notice
			System.out.println("Saving the Student John");
			System.out.println(tempStudent);
			session.save(tempStudent);
			// at this point save is a memory object!!
			
			// commit transaction - this is when the DB is involved
			session.getTransaction().commit();
			
		}catch (ParseException p) {
			p.printStackTrace();
		} finally {
			factory.close();
		}

	}
	
	
	//to test the primary key auto increment
	public void primaryKeyDemo() {
		// create a session - to make transactions - we already have the factory
		Session session = factory.getCurrentSession();

		try {
			String theDateOfBirthStr = "31/12/1998";
			//because parse date might throw an exception we should have a catch case
		    Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			// create 3 student objects - we also create a log notice
			System.out.println("Creating new Student Obj");
			Student tempStudent1 = new Student("John", "Doe", theDateOfBirth, "DoeJ@gmail.com");
			Student tempStudent2 = new Student("Mary", "Smith", theDateOfBirth, "SmithM@gmail.com");
			Student tempStudent3 = new Student("Bonita", "Public", theDateOfBirth, "Bonita@gmail.com");
			
			// start transaction - no object
			session.beginTransaction();

			// save the student - log notice
			// students here will get the auto increment
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			System.out.println("Saving Students...");
			
			// commit transaction
			session.getTransaction().commit();
		}catch (ParseException p) {
			p.printStackTrace();
		} finally {
			factory.close();
		}
	}
	
	
	// we create a method to read from the DB
	public void readStudent() {
		// create a session - to make transactions
		Session session = factory.getCurrentSession();

		try {
			String theDateOfBirthStr = "31/12/1998";
			//because parse date might throw an exception we should have a catch case
		    Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			// create the student object - we also create a log notice
			System.out.println("Creating new Student Obj");
			Student tempStudent = new Student("Micky", "Moosy", theDateOfBirth, "Micky@gmail.com");

			// start transaction - no object
			session.beginTransaction();

			// save the student - log notice
			System.out.println("Saving the Student John");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			//NEW CODE
			
			//find out the students id: primary key - via .getId() we find out 
			//what primary key hibernate assigned
			System.out.println("Saved student. Generated Id: "+ tempStudent.getId());
			
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key - log
			System.out.println("\nGetting student with the id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: "  + myStudent);
			
			// commit the transaction - log
			session.getTransaction().commit();
			
			System.out.println("Process Complete!");
		}catch (ParseException p) {
			p.printStackTrace();
		} finally {
			factory.close();
		}

	}
	
	
	
}
