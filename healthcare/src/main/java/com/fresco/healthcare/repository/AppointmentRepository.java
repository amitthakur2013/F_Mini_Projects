package com.fresco.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.fresco.healthcare.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,String>{

}
