package com.example.casestudy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.casestudy.exception.InvalidIDException;
import com.example.casestudy.model.Doctor;
import com.example.casestudy.repository.DoctorRepository;
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}
	public Doctor getDoctorByID(int doctorid) throws InvalidIDException {
	    Optional<Doctor> optional = doctorRepository.findById(doctorid);
	    if (optional.isEmpty()) 
	        throw new InvalidIDException("Invalid Doctor ID: " + doctorid);
	
	    return optional.get();
	}
	
}
