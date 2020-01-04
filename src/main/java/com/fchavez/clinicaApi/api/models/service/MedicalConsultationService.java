package com.fchavez.clinicaApi.api.models.service;

import java.util.List;

import com.fchavez.clinicaApi.api.models.entity.MedicalConsultation;
import com.fchavez.clinicaApi.api.models.entity.Patient;

public interface MedicalConsultationService extends CrudService<MedicalConsultation>{
	List<MedicalConsultation> getByPatient(Patient paciente);

}


