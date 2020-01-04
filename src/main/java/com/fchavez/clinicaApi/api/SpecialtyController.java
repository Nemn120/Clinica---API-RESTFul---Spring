package com.fchavez.clinicaApi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fchavez.clinicaApi.api.models.entity.Specialty;
import com.fchavez.clinicaApi.api.models.service.SpecialtyService;


@RestController
@RequestMapping("/specialtys")
public class SpecialtyController {
	
	@Autowired
	private SpecialtyService specialtyService;
	
	@GetMapping
	public List<Specialty> listDoctors() throws Exception {
		return specialtyService.getAll();
	}

	@GetMapping("/{id}")
	public Specialty getDoctor(@PathVariable("id") Integer id) throws Exception {
		return specialtyService.getOne(id).get();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDoctor(@RequestBody Specialty specialty) throws Exception {
		specialtyService.insertOrUpdate(specialty);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSpecialty(@PathVariable("id") Integer id, @RequestBody Specialty specialty) throws Exception {
    	Specialty existingSpecialty = specialtyService.getOne(id).get();
    	existingSpecialty.setNombre(specialty.getNombre());
        specialtyService.insertOrUpdate(existingSpecialty);
    }
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable("id") Integer id) throws Exception {
    	specialtyService.delete(id);
    }

}
