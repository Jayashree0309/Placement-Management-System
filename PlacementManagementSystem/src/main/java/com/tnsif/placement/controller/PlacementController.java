package com.tnsif.placement.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnsif.placement.entity.JobOpening;
import com.tnsif.placement.repository.PlacementRepository;
@RestController
@RequestMapping("/jobopening")
public class PlacementController {

	@Autowired
	PlacementRepository repo;
	
	@PostMapping
	public JobOpening addPlacement(@RequestBody JobOpening jb ) 
	{
		return repo.save(jb);
		
	}
	
	@GetMapping
	public List<JobOpening> getJobOpening(){
		return repo.findAll();
		
		
	}
	@GetMapping("/{id}")
	public Optional<JobOpening> getJobOpeningById(@PathVariable Integer id) {
		return repo.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteJobOpening(@PathVariable Integer id) {
		boolean delete=repo.existsById(id);
		if(delete) {
			repo.deleteById(id);
			return "Successfully deleted";
		}
		return "Job Id does not exsist";
	}
	
	@PutMapping("/{id}")
	public String updateJobOpening(@PathVariable Integer id,@RequestBody JobOpening jb) {
		boolean update=repo.existsById(id);
		
		if(update) {	
			jb.setJobId(id);
			repo.save(jb);
			return "Updated Successfully";
		}
		return "Update failed";
	}

}
