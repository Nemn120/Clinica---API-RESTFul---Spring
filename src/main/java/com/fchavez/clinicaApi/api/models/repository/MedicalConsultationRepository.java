package com.fchavez.clinicaApi.api.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fchavez.clinicaApi.api.models.entity.MedicalConsultation;
import com.fchavez.clinicaApi.api.models.entity.Patient;


public interface MedicalConsultationRepository  extends JpaRepository<MedicalConsultation, Integer>{
		
	List<MedicalConsultation> findAllByPatient(Patient patient);
}
