package com.fchavez.clinicaApi.api.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fchavez.clinicaApi.api.models.entity.Patient;


public interface PatientRepository extends JpaRepository<Patient,Integer> {
	
	List<Patient> findByDni(String dni);

}
