package com.fresco.healthcare.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fresco.healthcare.model.Appointment;
import com.fresco.healthcare.repository.AppointmentRepository;



@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

    public void deleteAppointment(String appintId) {
    	appointmentRepository.deleteById(appintId);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
    public Appointment getAppointment(String id) {
        Appointment ap=appointmentRepository.findById(id).orElse(null);
        return ap;
    }
    
    public Appointment saveAppointment(Appointment appointment) {
    	Optional<Appointment> a=appointmentRepository.findById(appointment.getBooking_id());
    	if(!a.isPresent()) {
    	return appointmentRepository.save(appointment);
    	} else {
    		return null;
    	}
    }
    
    public List<Appointment> getAllAppointmentsByPatientId(String patientId) {
    	List<Appointment> appList= appointmentRepository.findAll().stream().filter(app ->{
    		return app.getPatientId() == patientId;
    	}).collect(Collectors.toList());
    	
    	return appList;
    }
}

