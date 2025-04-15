package com.example.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.casestudy.model.Doctor;
import com.example.casestudy.model.Speciality;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	Object findBySpeciality(Speciality ortho);

	
	
}

