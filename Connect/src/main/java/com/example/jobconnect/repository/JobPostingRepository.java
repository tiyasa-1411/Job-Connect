package com.example.jobconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobconnect.model.JobPosting;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
}
