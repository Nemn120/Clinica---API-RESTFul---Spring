package com.fchavez.clinicaApi.api.models.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fchavez.clinicaApi.api.models.entity.Patient;
import com.fchavez.clinicaApi.api.models.repository.PatientRepository;
import com.fchavez.clinicaApi.api.models.service.PatientService;



@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientRepository patientRepository;

	@Transactional
	@Override
	public Patient insertOrUpdate(Patient entity) {
		
		return patientRepository.save(entity);
	}

	@Override
	public Optional<Patient> getOne(Integer id) {
		return patientRepository.findById(id);
	}

	@Override
	public List<Patient> getAll() {
		return patientRepository.findAll();
	}
	@Transactional
	@Override
	public void delete(Integer id) {
		patientRepository.deleteById(id);
		
	}
	@Override
	public List<Patient> fetchPatientByDni(String dni) throws Exception {
		return patientRepository.findByDni(dni);
	}

	

}
