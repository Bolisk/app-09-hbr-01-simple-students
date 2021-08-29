package com.ngin.implementations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ngin.entities.Student;

// this is a class to show various implementations of find methods
public class StudentFindDao {
	
	
	//create session factory
	SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
	
	// create the Entity manager factory class
	// toDO we do not have a persistence unit yet!!
	private EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("STUDENT");
	
	
	public Student getStudentById(int id) {
		
	    EntityManager em = emf.createEntityManager();

	    return (Student) em.createQuery("SELECT s FROM Student s WHERE s.id = :id")
	    				   .setParameter("id", id)
	    				   .getSingleResult();
	}
	
	
	// does this work? - via the find method alone
	public Student findStudentById(int id) {
	    EntityManager em = emf.createEntityManager();
	    return em.find(Student.class, id);
	}

}
