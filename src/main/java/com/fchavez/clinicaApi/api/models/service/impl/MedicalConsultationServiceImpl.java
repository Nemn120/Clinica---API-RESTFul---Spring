package com.fchavez.clinicaApi.api.models.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fchavez.clinicaApi.api.models.entity.MedicalConsultation;
import com.fchavez.clinicaApi.api.models.entity.Patient;
import com.fchavez.clinicaApi.api.models.repository.MedicalConsultationRepository;
import com.fchavez.clinicaApi.api.models.service.MedicalConsultationService;



@Service
public class MedicalConsultationServiceImpl implements MedicalConsultationService{
	
	@Autowired
	private MedicalConsultationRepository medicalConsultationRepository;

	@Transactional
	@Override
	public MedicalConsultation insertOrUpdate(MedicalConsultation entity) {
		return medicalConsultationRepository.save(entity);
	}

	@Override
	public Optional<MedicalConsultation> getOne(Integer id) {
		return medicalConsultationRepository.findById(id);
	}

	@Override
	public List<MedicalConsultation> getAll() {
		return medicalConsultationRepository.findAll();
	}
	@Transactional
	@Override
	public void delete(Integer id) {
		medicalConsultationRepository.deleteById(id);
		
	}

	@Override
	public List<MedicalConsultation> getByPatient(Patient paciente) {
		return medicalConsultationRepository.findAllByPatient(paciente);
		
	}





}
