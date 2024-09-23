package com.jobconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobconnect.entity.JobPosting;
import com.jobconnect.exception.ResourceNotFoundException;
import com.jobconnect.repository.JobPostingRepository;

@Service
public class JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    public JobPosting createJob(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    public List<JobPosting> getAllJobs() {
        return jobPostingRepository.findAll();
    }
    public JobPosting getJobPostingById(Long id) {
        return jobPostingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job Posting not found with id: " + id));
    }
}
