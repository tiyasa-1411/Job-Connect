package com.example.jobconnect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobconnect.model.JobPosting;
import com.example.jobconnect.service.JobPostingService;

@RestController
@RequestMapping("/api/job-postings")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    @GetMapping
    public ResponseEntity<List<JobPosting>> getAllJobPostings() {
        List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
        return new ResponseEntity<>(jobPostings, HttpStatus.OK);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long jobId) {
        Optional<JobPosting> jobPosting = jobPostingService.getJobPostingById(jobId);
        return jobPosting.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting jobPosting) {
        JobPosting createdJobPosting = jobPostingService.createJobPosting(jobPosting);
        return new ResponseEntity<>(createdJobPosting, HttpStatus.CREATED);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<JobPosting> updateJobPosting(@PathVariable Long jobId,
                                                       @RequestBody JobPosting jobPostingDetails) {
        JobPosting updatedJobPosting = jobPostingService.updateJobPosting(jobId, jobPostingDetails);
        return new ResponseEntity<>(updatedJobPosting, HttpStatus.OK);
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long jobId) {
        jobPostingService.deleteJobPosting(jobId);
        return ResponseEntity.noContent().build();
    }
}
