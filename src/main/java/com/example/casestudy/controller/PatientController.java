package com.example.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casestudy.exception.InvalidIDException;
import com.example.casestudy.model.MedicalHistory;
import com.example.casestudy.model.Patient;
import com.example.casestudy.model.User;
import com.example.casestudy.service.AuthService;
import com.example.casestudy.service.MedicalHistoryService;
import com.example.casestudy.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired 
    private AuthService authService;
    @Autowired 
    private MedicalHistoryService medicalHistoryService;
    

    @PostMapping("/add/{uid}/{mid}")
    public Patient addPatient(@PathVariable int uid,@PathVariable int mid,@RequestBody Patient patient) throws InvalidIDException {
        User user=authService.getUserById(uid);
        MedicalHistory medicalHistory=medicalHistoryService.getDetailsById(mid);
        patient.setUser(user);
        patient.setMedicalHistory(medicalHistory);
    	
    	return patientService.addPatient(patient);
    }
}