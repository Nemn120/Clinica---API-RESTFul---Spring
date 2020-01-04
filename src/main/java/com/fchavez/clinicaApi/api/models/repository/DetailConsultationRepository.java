package com.fchavez.clinicaApi.api.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fchavez.clinicaApi.api.models.entity.DetailConsultation;



public interface DetailConsultationRepository extends  JpaRepository<DetailConsultation,Integer>{
	
	

}
