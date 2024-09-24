package com.example.jobconnect.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

  /*  @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPosting job;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private User jobSeeker; */

    private String resume;
    private String coverLetter;
    private String applicationStatus; // Applied, Interview Scheduled, Rejected, Accepted

    @Column(name = "applied_at")
    private LocalDateTime appliedAt;

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

/*	public JobPosting getJob() {
		return job;
	}

	public void setJob(JobPosting job) {
		this.job = job;
	}

	public User getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(User jobSeeker) {
		this.jobSeeker = jobSeeker;
	} */

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public LocalDateTime getAppliedAt() {
		return appliedAt;
	}

	public void setAppliedAt(LocalDateTime appliedAt) {
		this.appliedAt = appliedAt;
	}

    // Getters and Setters
    
}
