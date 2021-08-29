package com.ngin.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ngin.utils.DateUtils;

@Entity
@Table(name="student")
// a class defined as entity - this class was created as an entity MANUALLY
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name", columnDefinition = "Varchar(35)")
	private String lastName;
	
    @Column(name="date_of_birth")
    @Temporal(TemporalType.DATE)    
    private Date dateOfBirth;
	
	@Column(name="email")
	private String email;
	
	// empty constructor (java bean)
	public Student() {
	}

	// no id constructor - id auto increment
	public Student(String firstName, String lastName, Date dateOfBirth, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id 
				+ ", firstName=" + firstName 
				+ ", lastName=" + lastName 
				+ ", dateOfBirth="
				+ DateUtils.formatDate(dateOfBirth) 
				+ ", email=" + email + "]";
	}


}
