package com.eduardor.Student.entity;

import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String name;
    private double gpa;
    private String email;
    private String gender;
    
    
    public Student(String name, double gpa, String email, String gender) {
    	super();
    	
    this.name = name;
    this.gpa = gpa;
    this.email = email;
    this.gender = gender;
    }
   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	  
}
