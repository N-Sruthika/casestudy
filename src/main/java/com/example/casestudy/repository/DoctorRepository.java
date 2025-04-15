package com.example.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.casestudy.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	
	
}

