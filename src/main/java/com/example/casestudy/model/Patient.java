package com.example.casestudy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private int age;
	 @OneToOne
	 private MedicalHistory medicalHistory;
	 @OneToOne
	 private User user;
	
	public Patient(String name, int age, MedicalHistory medicalHistory, User user) {
		super();
		this.name = name;
		this.age = age;
		this.medicalHistory = medicalHistory;
		this.user = user;
	}
	public Patient(int id, String name, int age, MedicalHistory medicalHistory, User user) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.medicalHistory = medicalHistory;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
