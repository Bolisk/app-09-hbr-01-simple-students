package com.ngin.implementations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ngin.entities.Student;

public class StudentUpdateDeleteDao {
	
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	
	
	// method to update one student
	public void updateStudent(int studentId) {
	
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Student myStudent = session.get(Student.class, studentId);
			myStudent.setFirstName("Kostas");
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
	}
	
	// method to update all the students email whose name is the parameter
	public void updateAllEmails(String name) {
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='" + name + "@nginstudio.com' WHERE first_name = " + name)
					.executeUpdate();
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
	
	// bulk update method
	public void bulkUpdateEmail() {
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();
		} finally {
			System.out.println("all emails updated to 'foo@gmail.com'");
			factory.close();
		}
	}
	
	// delete object method
	public void deleteStudent(int studentId) {
		
		try {
			Session session = factory.getCurrentSession();
			//get the object
			Student tempStudent = session.get(Student.class, studentId);
			//set up in memory the delete
			session.delete(tempStudent);
			//commit the delete
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

	//delete method via query without retrieval
	public void deleteStudentQuick(int studentId) {
		try {
			Session session = factory.getCurrentSession();
			//everything is done via the session
			session
			.createQuery("delete from Student where id = " 
			+ studentId)
			.executeUpdate();
		} finally {
			factory.close();
		}// note that delete and update are both conciderred updates
	}
	
	
}
