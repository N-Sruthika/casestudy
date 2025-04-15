package com.example.casestudy.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "patient_doctor")
public class PatientDoctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    private LocalDate appointmentDate;

    private String reason;

    
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

	public PatientDoctor(int id, Patient patient, Doctor doctor, LocalDate appointmentDate, String reason) {
		super();
		this.id = id;
		this.patient = patient;
		this.doctor = doctor;
		this.appointmentDate = appointmentDate;
		this.reason = reason;
	}

	public PatientDoctor(Patient patient, Doctor doctor, LocalDate appointmentDate, String reason) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.appointmentDate = appointmentDate;
		this.reason = reason;
	}
}
