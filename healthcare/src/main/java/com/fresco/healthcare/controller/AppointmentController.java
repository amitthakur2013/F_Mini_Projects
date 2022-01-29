package com.fresco.healthcare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.annotations.NotFound;
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

import com.fresco.healthcare.model.Appointment;
import com.fresco.healthcare.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("/register")
	public ResponseEntity<?> bookAppointment(@RequestBody Appointment appointment) {
		Map<String, String> respObj = new HashMap<>();
		Appointment ap=appointmentService.saveAppointment(appointment);
		if(ap != null) {
			respObj.put("message", "Booking successful");
			return ResponseEntity.ok(respObj);
		} else  {
			respObj.put("message", "Booking failure");
			return ResponseEntity.badRequest().body(respObj);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllAppointment(){
		List<Appointment> aList= appointmentService.getAllAppointments();
		return ResponseEntity.ok(aList);
	}
	
	@GetMapping("/view/{appointmentId}")
	public ResponseEntity<?> getAppointment(@PathVariable() String appointmentId){
		Appointment a= appointmentService.getAppointment(appointmentId);
		if(a!=null) {
			return ResponseEntity.ok(a);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/delete/{appointmentId}")
	public ResponseEntity<?> delAppointment(@PathVariable() String appointmentId){
		appointmentService.deleteAppointment(appointmentId);
		return ResponseEntity.ok("");
		
	}
	
	@GetMapping("/list/{patientId}")
	public ResponseEntity<?> getAllByPatientId(@PathVariable() String patientId){
		List<Appointment> apList=appointmentService.getAllAppointmentsByPatientId(patientId);
		return ResponseEntity.ok(apList);
	}
	
}
