package com.example.jobconnect.service;

import com.example.jobconnect.exception.ApplicationNotFoundException;
import com.example.jobconnect.exception.UserNotFoundException;
import com.example.jobconnect.model.Application;
import com.example.jobconnect.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    // Get all applications
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Get an application by ID
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("Application not found with id: " + id));
    }
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }


    public Application updateApplication(Long id, Application application) {
        Application existingApplication = applicationRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Application not found"));
        existingApplication.setCoverLetter(application.getCoverLetter());
        existingApplication.setResume(application.getResume());
        existingApplication.setApplicationStatus(application.getApplicationStatus());
        return applicationRepository.save(existingApplication);
    }

    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

   
   /* // Get applications by Job ID
    public List<Application> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    // Get applications by User ID
    public List<Application> getApplicationsByUserId(Long userId) {
        return applicationRepository.findByJobSeekerId(userId);
    } */
}
