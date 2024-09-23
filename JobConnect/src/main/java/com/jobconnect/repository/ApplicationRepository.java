package com.jobconnect.repository;

import com.jobconnect.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findAllByJobPosting_JobId(Long jobId); // Uncommented and corrected
}