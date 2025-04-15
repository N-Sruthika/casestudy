package com.example.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.casestudy.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer> {
}
