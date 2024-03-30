package com.tnsif.placement.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins ="http://localhost:4200")

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
	@GetMapping("/{jobId}")
	public Optional<JobOpening> getJobOpeningById(@PathVariable Integer jobId) {
		return repo.findById(jobId);
	}
	
	@DeleteMapping("/{jobId}")
	public void deleteJobOpening(@PathVariable Integer jobId) {
		repo.deleteById(jobId);
	}
	
	@PutMapping("/{jobId}")
	public JobOpening updateJobOpening(@PathVariable Integer jobId,@RequestBody JobOpening jb) {
		jb.setJobId(jobId);
		return repo.save(jb);
	}

}
