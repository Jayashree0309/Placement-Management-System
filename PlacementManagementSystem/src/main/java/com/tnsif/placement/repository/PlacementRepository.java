package com.tnsif.placement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.placement.entity.JobOpening;

public interface PlacementRepository extends JpaRepository<JobOpening, Integer>{

}
