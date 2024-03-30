package com.tnsif.placement.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class JobOpening {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer jobId;
	private int companyId;
	private String title;
	private String description;
	private LocalDate postingDate;
	private LocalDate deadline;
	
	public JobOpening() {
		super();
	}

	public JobOpening(int companyId,String title, String description, LocalDate postingDate, LocalDate deadline)  {
		super();
		this.companyId=companyId;
		this.title = title;
		this.description = description;
		this.postingDate=postingDate;
		this.deadline=deadline;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(LocalDate postingDate) {
		this.postingDate = postingDate;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	
	

}
