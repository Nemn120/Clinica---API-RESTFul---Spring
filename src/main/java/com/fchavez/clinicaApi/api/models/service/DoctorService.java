package com.fchavez.clinicaApi.api.models.service;

import java.util.List;

import com.fchavez.clinicaApi.api.models.entity.Doctor;
import com.fchavez.clinicaApi.api.models.entity.Specialty;


public interface DoctorService extends CrudService<Doctor>{
	List<Doctor> getBySpecialty(Specialty specialty);
	List<Doctor> fetchDoctorByLastName(String lastName) throws Exception;
}
