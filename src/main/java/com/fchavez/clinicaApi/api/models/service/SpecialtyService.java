package com.fchavez.clinicaApi.api.models.service;

import java.util.List;

import com.fchavez.clinicaApi.api.models.entity.Specialty;



public interface SpecialtyService extends CrudService<Specialty>{
	
	public List<Specialty> findByNombre(String term);

}
