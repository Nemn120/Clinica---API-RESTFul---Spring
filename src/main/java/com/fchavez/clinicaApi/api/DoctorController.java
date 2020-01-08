package com.fchavez.clinicaApi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fchavez.clinicaApi.api.models.entity.Doctor;
import com.fchavez.clinicaApi.api.models.service.DoctorService;

@CrossOrigin(origins = ("https://clinica-frontend-01.herokuapp.com"))
@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping
	public List<Doctor> listDoctors() throws Exception {
		return doctorService.getAll();
	}

	@GetMapping("/{id}")
	public Doctor getDoctor(@PathVariable("id") Integer id) throws Exception {
		return doctorService.getOne(id).get();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDoctor(@RequestBody Doctor doctor) throws Exception {
		doctorService.insertOrUpdate(doctor);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDoctor(@PathVariable("id") Integer id, @RequestBody Doctor doctor) throws Exception {
    	Doctor existingDoctor = doctorService.getOne(id).get();
        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setDni(doctor.getDni());
        existingDoctor.setCmp(doctor.getCmp());
        doctorService.insertOrUpdate(existingDoctor);
    }
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable("id") Integer id) throws Exception {
    	doctorService.delete(id);
    }

}
