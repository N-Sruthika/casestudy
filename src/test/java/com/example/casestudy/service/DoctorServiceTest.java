package com.example.casestudy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.casestudy.model.Doctor;
import com.example.casestudy.model.Speciality;
import com.example.casestudy.repository.DoctorRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {

    @InjectMocks
    private DoctorService doctorService;

    @Mock
    private DoctorRepository doctorRepository;

    Doctor d1, d2;

    @BeforeEach
    public void setup() {
        d1 = new Doctor();
        d1.setId(1);
        d1.setName("Dr. John");
        d1.setSpeciality(Speciality.ORTHO);

        d2 = new Doctor();
        d2.setId(2);
        d2.setName("Dr. Lisa");
        d2.setSpeciality(Speciality.ORTHO);
    }

    @Test
    public void testGetDoctorsByPatientId() {
        int patientId = 10;
        List<Doctor> expectedDoctors = Arrays.asList(d1, d2);

        when(doctorRepository.findByPatientId(patientId)).thenReturn(expectedDoctors);

        List<Doctor> actualDoctors = doctorService.getDoctorsByPatientId(patientId);

        assertEquals(expectedDoctors, actualDoctors);
        assertEquals(2, actualDoctors.size());
        assertEquals("Dr. John", actualDoctors.get(0).getName());

        verify(doctorRepository, times(1)).findByPatientId(patientId);
    }
}
