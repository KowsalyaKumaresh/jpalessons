package com.chainsys.application.doctor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor,Integer>{
	Doctor findById(int id) ;
	 Doctor save(Doctor dr);       //used for adding a new doctor and modifying the doctor.
	void deleteById(int id);
	
	List<Doctor> findAll();
		
	

}
