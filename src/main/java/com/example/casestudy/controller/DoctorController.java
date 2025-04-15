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
import com.example.casestudy.model.User;
import com.example.casestudy.service.AuthService;
import com.example.casestudy.service.DoctorService;
import com.example.casestudy.service.PatientDoctorService;

@RestController
@RequestMapping("api/doctor")

public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@Autowired
	private AuthService authService;
	@Autowired
	private PatientDoctorService patientDoctorService;
	@PostMapping("/add/{userid}")

	public Doctor addDoctor (@PathVariable int uid, @RequestBody Doctor doctor) throws InvalidIDException{
		User user=authService.getUserById(uid);
		doctor.setUser(user);
		return doctorService.addDoctor (doctor);

 }
	@GetMapping("/getallpatient/{doctorid}")
	public List<Patient> getAllPatientByDoctor(@PathVariable int doctorid) throws InvalidIDException {
		return patientDoctorService.getAllPatientByDoctor(doctorid);
		
	}
}
