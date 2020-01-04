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

import com.fchavez.clinicaApi.api.models.entity.Patient;
import com.fchavez.clinicaApi.api.models.service.PatientService;


@RestController
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public List<Patient> listPatients() throws Exception {
		return patientService.getAll();
	}

	@GetMapping("/{id}")
	public Patient getPatient(@PathVariable("id") Integer id) throws Exception {
		return patientService.getOne(id).get();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPatient(@RequestBody Patient patient) throws Exception {
		patientService.insertOrUpdate(patient);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatient(@PathVariable("id") Integer id, @RequestBody Patient patient) throws Exception {
    	Patient existingPatient = patientService.getOne(id).get();
        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setDni(patient.getDni());
        patientService.insertOrUpdate(existingPatient);
    }
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable("id") Integer id) throws Exception {
    	patientService.delete(id);
    }
	

}
