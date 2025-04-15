package com.example.casestudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.casestudy.exception.InvalidIDException;
import com.example.casestudy.model.Doctor;
import com.example.casestudy.model.Patient;
import com.example.casestudy.model.PatientDoctor;
import com.example.casestudy.repository.PatientDoctorRepository;

@Service
public class PatientDoctorService {
	@Autowired
	private DoctorService doctorService;

    @Autowired
    private PatientDoctorRepository patientDoctorRepository;
   
	public PatientDoctor addAppointment(PatientDoctor patientDoctor) {
		 return patientDoctorRepository.save(patientDoctor);
	}

	public List<Patient> getAllPatientByDoctor(int doctorid) throws InvalidIDException {
		Doctor doctor = doctorService.getDoctorByID(doctorid);
		List<PatientDoctor> list = patientDoctorRepository.findByDoctorId(doctorid);
		return list.stream().map(patientDoctor -> patientDoctor.getPatient()).toList();
	}


}
