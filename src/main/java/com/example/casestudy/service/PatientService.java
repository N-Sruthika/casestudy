package com.example.casestudy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.casestudy.exception.InvalidIDException;
import com.example.casestudy.model.Patient;
import com.example.casestudy.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
            return patientRepository.save(patient);
    }
    public Patient getPatientByID(int patientid) throws InvalidIDException {
        Optional<Patient> optional = patientRepository.findById(patientid);
        if (optional.isEmpty()) 
            throw new InvalidIDException("Invalid Patient ID: " + patientid);
        
        return optional.get();
    }
}
