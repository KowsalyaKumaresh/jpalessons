package com.chainsys.application.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorService {
	@Autowired
	private DoctorRepository repo;

	/*
	 * @Bean public void setRepo(DoctorRepository repo) { this.repo = repo; }
	 */
	@GetMapping(value = "/getdoctorbyid", consumes = "applicaion/json")
	public Doctor getDoctor(int id) {
		return repo.findById(id);

	}
    
	    // We need give from where to read data from the HTTP request and also the
		// content type("application/json")
	
	@PostMapping(value = "/newdoctor")
	public String addDoctor(@RequestBody Doctor dr) {
    	System.out.println("Doctor: " + dr.getDoc_id() + " " + dr.getDoctor_name());
		repo.save(dr);
		return "redirect:/getalldoctors";
	}

	@DeleteMapping("/deletedoctor")
	public String deleteDoctor(int id) {
		repo.deleteById(id);
		return "redirect:/getalldoctors";
	}
	@PostMapping(value = "/modifydoctor")
	public String modifyDoctor(@RequestBody Doctor dr) {
		System.out.println("Doctor: " + dr.getDoc_id() + " " + dr.getDoctor_name());
		repo.save(dr);
		return "redirect:/getalldoctors";
	}

	@GetMapping("/getalldoctors")
	public List<Doctor> getAllDoctors() {
		return repo.findAll();
	}

}
