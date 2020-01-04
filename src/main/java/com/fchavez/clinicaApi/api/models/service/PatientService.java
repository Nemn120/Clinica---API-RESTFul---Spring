package com.fchavez.clinicaApi.api.models.service;

import java.util.List;

import com.fchavez.clinicaApi.api.models.entity.Patient;


public interface PatientService extends CrudService<Patient>{
	List<Patient> fetchPatientByDni(String dni) throws Exception;
}
