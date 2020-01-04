package com.fchavez.clinicaApi.api.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fchavez.clinicaApi.api.models.entity.Doctor;
import com.fchavez.clinicaApi.api.models.entity.Specialty;


public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	List<Doctor> findAllBySpecialty(Specialty specialty);
	List<Doctor> findByLastName(String lastName);
}
	

