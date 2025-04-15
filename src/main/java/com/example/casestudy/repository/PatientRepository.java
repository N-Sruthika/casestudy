package com.example.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.casestudy.model.Patient;
import com.example.casestudy.model.User;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	Patient findByUser(User user);
}
