package com.jobconnect.controller;

import com.jobconnect.entity.JobPosting;
import com.jobconnect.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    @PostMapping("/create")
    public ResponseEntity<JobPosting> createJob(@RequestBody JobPosting jobPosting) {
        return ResponseEntity.ok(jobPostingService.createJob(jobPosting));
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobPosting>> getAllJobs() {
        return ResponseEntity.ok(jobPostingService.getAllJobs());
    }
}
