package com.example.casestudy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.casestudy.exception.InvalidIDException;
import com.example.casestudy.model.Doctor;
import com.example.casestudy.model.MedicalHistory;
import com.example.casestudy.model.Patient;
import com.example.casestudy.model.PatientDoctor;
import com.example.casestudy.model.Speciality;
import com.example.casestudy.model.User;
import com.example.casestudy.repository.PatientDoctorRepository;

@ExtendWith(MockitoExtension.class)
public class PatientDoctorServiceTest {

    @InjectMocks
    private PatientDoctorService patientDoctorService;

    @Mock
    private DoctorService doctorService;

    @Mock
    private PatientDoctorRepository patientDoctorRepository;

    private Patient patient;
    private Doctor doctor;
    private PatientDoctor patientDoctor;

    @BeforeEach
    public void init() {
       
        User patientUser = new User(3, "johndoe@example.com", "pass3", "PATIENT");
        User doctorUser = new User(1, "drsmith@example.com", "pass1", "DOCTOR");

        // Creating MedicalHistory instance
        MedicalHistory medicalHistory = new MedicalHistory(1, "Hypertension", 3, "Amlodipine 5mg daily");

        // Creating Patient with all fields populated
        patient = new Patient(1, "John Doe", 30, medicalHistory, patientUser);

        // Creating Doctor with all fields populated
        doctor = new Doctor(1, "Dr. Smith", Speciality.ORTHO, doctorUser);

        // Creating PatientDoctor association with appointment date and reason
        patientDoctor = new PatientDoctor(1, patient, doctor, LocalDate.of(2025, 4, 15), "Regular Checkup");
    }

    @Test
    public void testGetAllPatientByDoctorWithValidData() throws InvalidIDException {
       
        when(doctorService.getDoctorByID(1)).thenReturn(doctor);
        when(patientDoctorRepository.findByDoctorId(1)).thenReturn(Arrays.asList(patientDoctor));

       
        List<Patient> patients = patientDoctorService.getAllPatientByDoctor(1);
      
        assertEquals(1, patients.size(), "The patient list should contain one patient");
        assertEquals("John Doe", patients.get(0).getName(), "The patient's name should be 'John Doe'");

        // Verifying interactions
        verify(doctorService, times(1)).getDoctorByID(1);
        verify(patientDoctorRepository, times(1)).findByDoctorId(1);
    }
}
