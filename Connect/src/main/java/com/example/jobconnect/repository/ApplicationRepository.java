package com.example.jobconnect.repository;

import com.example.jobconnect.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
 /*   // Find applications by job ID
    List<Application> findByJobId(Long jobId);

    // Find applications by job seeker (user) ID
    List<Application> findByJobSeekerId(Long jobSeekerId); */
}
