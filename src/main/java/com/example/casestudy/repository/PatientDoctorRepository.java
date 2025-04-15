package com.example.casestudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.casestudy.model.Doctor;
import com.example.casestudy.model.PatientDoctor;

public interface PatientDoctorRepository extends JpaRepository<PatientDoctor, Integer> {

	List<Doctor> findByPatientId(int patientId);
    // Custom query methods can be added here if needed

	List<PatientDoctor> findByDoctorId(int doctorid);
}
