package com.wipro.jobpostingfeign.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.jobpostingfeign.model.JobPosting;
import com.wipro.jobpostingfeign.service.JobPostingService;


@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;
    @GetMapping
    public ResponseEntity<List<JobPosting>> getAllJobPostings() {
        // Logic to get job postings
        return ResponseEntity.ok(jobPostingService.getAllJobPostings());
    }

    @PostMapping("/create/{employerId}")
    public ResponseEntity<JobPosting> createJobPosting(@PathVariable Long employerId, @RequestBody JobPosting jobPosting) {
        JobPosting createdJobPosting = jobPostingService.createJobPosting(employerId, jobPosting);
        return new ResponseEntity<>(createdJobPosting, HttpStatus.CREATED);
    }

    @PutMapping("/update/{jobId}")
    public ResponseEntity<JobPosting> updateJobPosting(@PathVariable Long jobId, @RequestBody JobPosting jobPosting) {
        JobPosting updatedJobPosting = jobPostingService.updateJobPosting(jobId, jobPosting);
        return new ResponseEntity<>(updatedJobPosting, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{jobId}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long jobId) {
        jobPostingService.deleteJobPosting(jobId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employer/{employerId}")
    public ResponseEntity<List<JobPosting>> getJobPostingsForEmployer(@PathVariable Long employerId) {
        List<JobPosting> jobPostings = jobPostingService.getJobPostingsForEmployer(employerId);
        return new ResponseEntity<>(jobPostings, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<JobPosting>> searchJobPostings(
            @RequestParam String location,
            @RequestParam String jobType,
            @RequestParam String salaryRange) {
        List<JobPosting> jobPostings = jobPostingService.searchJobPostings(location, jobType, salaryRange);
        return new ResponseEntity<>(jobPostings, HttpStatus.OK);
    }
}
