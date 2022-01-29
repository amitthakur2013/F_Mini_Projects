package com.fresco.healthcare.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fresco.healthcare.model.Patient;
import com.fresco.healthcare.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	PatientService patientService;

	@PostMapping("/register")
	public ResponseEntity<?> registerPatient(@RequestBody Patient patient) {
		Map<String,String> respObj=new HashMap<>();
		
		Patient p=patientService.savePatient(patient);
		if(p!=null) {
			respObj.put("message", "Registration successful!");
			return ResponseEntity.ok(respObj);
		} else {
			respObj.put("message", "Registration Failure!");
			return ResponseEntity.badRequest().body(respObj);
		}
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllPatients() {
		List<Patient> pList= patientService.findAllPatients();
		return ResponseEntity.ok(pList);
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<?> getPatient(@PathVariable String id) {
		Patient p=patientService.getPatient(id);
		if(p!=null) {
			return ResponseEntity.ok(p);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/view/{id}")
	public ResponseEntity<?> deletePatient(@PathVariable String id) {
		patientService.deletePatient(id);
		return ResponseEntity.ok("");
	}
}
