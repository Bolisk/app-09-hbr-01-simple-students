package com.ngin.implementations;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ngin.entities.Student;

public class StudentsQueryDao {
	
	
	//create session factory
		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
	

		
		@SuppressWarnings("unchecked")
		public void displayStudents() {
			
			Session session = factory.getCurrentSession();

			try {
				session.beginTransaction();


				// query the students
				List<Student> theStudents = session
											.createQuery("from Student")
											.getResultList();
				
				// display the students
				displayStudents(theStudents);
				
				
				// query students that lastName = "Smith"
				theStudents = session
							/* notice here how we also use the java property name (lastName) 
							 * and not the column name */
							.createQuery("from Student s where s.lastName = 'Smith'")
							.getResultList();
				
				
				// and here we display the students who have last name "smith"
				System.out.println("\n\nStudents who have last name of Smith!");
				displayStudents(theStudents);
				
				
				theStudents = session
							  .createQuery("from Student s" 
									     + " where s.lastName = 'Smith'"
									     + " OR s.firstName ='John'")
							  .getResultList();

				
				System.out.println("\n\nStudents who have last name of Smith! OR fist name of John");
				displayStudents(theStudents);
							
				
				// we use the LIKE clause
				theStudents = session
							  .createQuery("from Student s where s.email LIKE '%gmai.com'")
							  .getResultList();
				
				System.out.println("\n\nStudents who have email ends with 'gmail'");
				displayStudents(theStudents);
				
				
				System.out.println("Process Done!");
				session.getTransaction().commit();
				
			} finally {
				factory.close();
			}

		}


		//extracted method
		private void displayStudents(List<Student> theStudents) {
			theStudents.forEach(tempStudent -> System.out.println(tempStudent));
		}
		
		
		
}
