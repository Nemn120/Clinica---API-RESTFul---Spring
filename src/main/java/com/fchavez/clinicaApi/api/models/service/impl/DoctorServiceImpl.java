package com.fchavez.clinicaApi.api.models.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fchavez.clinicaApi.api.models.entity.Doctor;
import com.fchavez.clinicaApi.api.models.entity.Specialty;
import com.fchavez.clinicaApi.api.models.repository.DoctorRepository;
import com.fchavez.clinicaApi.api.models.service.DoctorService;



@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Transactional
	@Override
	public Doctor insertOrUpdate(Doctor entity) {
		// 
		return doctorRepository.save(entity);
	}

	@Override
	public Optional<Doctor> getOne(Integer id) {
		return doctorRepository.findById(id);
	}

	@Override
	public List<Doctor> getAll() {
		return doctorRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		doctorRepository.deleteById(id);
		
	}
	
	@Transactional
	@Override
	public List<Doctor> getBySpecialty(Specialty specialty) {
		return doctorRepository.findAllBySpecialty(specialty);
	}

	@Override
	public List<Doctor> fetchDoctorByLastName(String lastName) throws Exception {
		return doctorRepository.findByLastName(lastName);
	}



}
