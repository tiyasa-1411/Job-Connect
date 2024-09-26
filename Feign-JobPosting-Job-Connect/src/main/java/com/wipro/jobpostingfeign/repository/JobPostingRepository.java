package com.wipro.jobpostingfeign.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.jobpostingfeign.model.JobPosting;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByEmployerId(Long employerId);
    List<JobPosting> findByLocationAndJobTypeAndSalaryRange(String location, String jobType, String salaryRange);
}