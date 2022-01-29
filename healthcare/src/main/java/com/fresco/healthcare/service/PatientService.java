package com.fresco.healthcare.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fresco.healthcare.model.Patient;
import com.fresco.healthcare.repository.PatientRepository;


@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	public Patient savePatient(Patient patient) {
		if(!patientRepository.findById(patient.getPatient_Id()).isPresent()) {
			return patientRepository.save(patient);
		}
		return null;
	}
	
	public List<Patient> findAllPatients() {
		return patientRepository.findAll();
	}
	
	public Patient getPatient(String pId) {
		Optional<Patient> p= patientRepository.findById(pId);
		if(p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}
	
	public void deletePatient(String pId) {
		patientRepository.deleteById(pId);
	}

}

