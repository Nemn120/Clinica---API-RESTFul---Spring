package com.fchavez.clinicaApi.api.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fchavez.clinicaApi.api.models.entity.Specialty;



public interface SpecialtyRepository extends JpaRepository<Specialty, Integer>{
	public List<Specialty> findIsLikeNombreOrderByNombre(String nombre);

}
