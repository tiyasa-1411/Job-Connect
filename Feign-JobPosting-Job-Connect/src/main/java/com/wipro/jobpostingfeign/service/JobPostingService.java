package com.wipro.jobpostingfeign.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.jobpostingfeign.client.UserClient;
import com.wipro.jobpostingfeign.dto.UserDTO;
import com.wipro.jobpostingfeign.exception.ResourceNotFoundException;
import com.wipro.jobpostingfeign.model.JobPosting;
import com.wipro.jobpostingfeign.repository.JobPostingRepository;


@Service
public class JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @Autowired
    private UserClient userClient;

    public JobPosting createJobPosting(Long employerId, JobPosting jobPosting) {
        UserDTO employer = userClient.getUserById(employerId);

        if (!"EMPLOYER".equalsIgnoreCase(employer.getUserType())) {
            throw new IllegalArgumentException("User is not an employer");
        }

        jobPosting.setEmployerId(employerId);
        jobPosting.setPostedAt(LocalDateTime.now());
        return jobPostingRepository.save(jobPosting);
    }

    public JobPosting updateJobPosting(Long jobId, JobPosting updatedJobPosting) {
        JobPosting existingJobPosting = jobPostingRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job posting not found"));

        existingJobPosting.setTitle(updatedJobPosting.getTitle());
        existingJobPosting.setDescription(updatedJobPosting.getDescription());
        existingJobPosting.setLocation(updatedJobPosting.getLocation());
        existingJobPosting.setJobType(updatedJobPosting.getJobType());
        existingJobPosting.setSalaryRange(updatedJobPosting.getSalaryRange());
        existingJobPosting.setApplicationDeadline(updatedJobPosting.getApplicationDeadline());
        existingJobPosting.setUpdatedAt(LocalDateTime.now());

        return jobPostingRepository.save(existingJobPosting);
    }
    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll(); // Retrieves all job postings from the database
    }


    public void deleteJobPosting(Long jobId) {
        JobPosting jobPosting = jobPostingRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job posting not found"));
        jobPostingRepository.delete(jobPosting);
    }

    public List<JobPosting> getJobPostingsForEmployer(Long employerId) {
        return jobPostingRepository.findByEmployerId(employerId);
    }

    public List<JobPosting> searchJobPostings(String location, String jobType, String salaryRange) {
        return jobPostingRepository.findByLocationAndJobTypeAndSalaryRange(location, jobType, salaryRange);
    }
}