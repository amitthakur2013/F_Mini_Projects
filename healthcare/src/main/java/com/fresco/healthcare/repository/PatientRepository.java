package com.fresco.healthcare.repository;

import org.springframework.stereotype.Repository;

import com.fresco.healthcare.model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,String>{

}
