package com.example.jobconnect.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobconnect.model.JobPosting;
import com.example.jobconnect.repository.JobPostingRepository;

@Service
public class JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    public Optional<JobPosting> getJobPostingById(Long jobId) {
        return jobPostingRepository.findById(jobId);
    }

    public JobPosting createJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    public JobPosting updateJobPosting(Long jobId, JobPosting jobPostingDetails) {
        JobPosting jobPosting = jobPostingRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job Posting not found"));
        
        jobPosting.setTitle(jobPostingDetails.getTitle());
        jobPosting.setDescription(jobPostingDetails.getDescription());
        jobPosting.setLocation(jobPostingDetails.getLocation());
        jobPosting.setJobType(jobPostingDetails.getJobType());
        jobPosting.setSalaryRange(jobPostingDetails.getSalaryRange());
        jobPosting.setApplicationDeadline(jobPostingDetails.getApplicationDeadline());
        jobPosting.setUpdatedAt(LocalDateTime.now());

        return jobPostingRepository.save(jobPosting);
    }

    public void deleteJobPosting(Long jobId) {
        jobPostingRepository.deleteById(jobId);
    }
}
