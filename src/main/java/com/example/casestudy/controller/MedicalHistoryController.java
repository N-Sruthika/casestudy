package com.example.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casestudy.model.MedicalHistory;
import com.example.casestudy.service.MedicalHistoryService;

@RestController
@RequestMapping("api/medicalhistory")
public class MedicalHistoryController {
	
	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	@PostMapping("/add")
	public MedicalHistory addHistory(@RequestBody MedicalHistory request) {
		return medicalHistoryService.addHistory(request);
	}
	
	
}