package com.example.casestudy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.casestudy.exception.InvalidIDException;
import com.example.casestudy.model.MedicalHistory;
import com.example.casestudy.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;
    public MedicalHistory addHistory(MedicalHistory request) {
		
		return medicalHistoryRepository.save(request);
	}
    public MedicalHistory getDetailsById(int mid) throws InvalidIDException {
        Optional<MedicalHistory> optional = medicalHistoryRepository.findById(mid);
        if (optional.isEmpty()) {
            throw new InvalidIDException("Invalid Medical History ID: " + mid);
        }
        return optional.get();
    }

	
}
