package com.example.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casestudy.exception.InvalidIDException;
import com.example.casestudy.model.Doctor;
import com.example.casestudy.model.Patient;
import com.example.casestudy.model.PatientDoctor;
import com.example.casestudy.service.DoctorService;
import com.example.casestudy.service.PatientDoctorService;
import com.example.casestudy.service.PatientService;
@RestController
@RequestMapping("/api")
public class PatientDoctorController {
	@Autowired
	private PatientDoctorService patientDoctorService;

	 @Autowired

	 private PatientService patientService;

	 @Autowired

	 private DoctorService doctorService;

	 @PostMapping("/add/{patientid}/{doctorid}")
	 public PatientDoctor addAppointment(@PathVariable int patientid, 
	                                     @PathVariable int doctorid, 
	                                     @RequestBody PatientDoctor patientDoctor) throws InvalidIDException { 
	     // Retrieve the patient and doctor by ID
	     Patient patient = patientService.getPatientByID(patientid);
	     Doctor doctor = doctorService.getDoctorByID(doctorid);

	     // Set the patient and doctor in the appointment
	     patientDoctor.setPatient(patient);
	     patientDoctor.setDoctor(doctor);

	     // Save the appointment
	     return patientDoctorService.addAppointment(patientDoctor);
	 }
	
}
