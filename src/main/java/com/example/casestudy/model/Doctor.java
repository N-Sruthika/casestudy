package com.example.casestudy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {
	public Doctor(String name, Speciality speciality, User user) {
		super();
		this.name = name;
		this.speciality = speciality;
		this.user = user;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	@Column(nullable=false)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
    private Speciality speciality;
	@OneToOne
    private User user;
	
	public Doctor(int i, String string, User user2) {
		// TODO Auto-generated constructor stub
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
	public Speciality getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Doctor(int id, String name, Speciality speciality, User user) {
		super();
		this.id = id;
		this.name = name;
		this.speciality = speciality;
		this.user = user;
	}		

}

