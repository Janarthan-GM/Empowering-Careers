package com.example.jobportal.Service;

import java.util.List;


import com.example.jobportal.model.JobAppEntity;
import com.example.jobportal.repository.JobApp_repo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAppService {

    private final JobApp_repo jobAppRepository;

    public JobAppService(JobApp_repo jobAppRepository) {
        this.jobAppRepository = jobAppRepository;
    }

    // Get all job applications
    public List<JobAppEntity> getAllJobs() {
        return jobAppRepository.findAll();
    }

    // Get job application by ID
    public JobAppEntity getJobById(Long id) {
        return jobAppRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Application not found with id: " + id));
    }

    // Create a new job application
    public JobAppEntity createJob(JobAppEntity jobApp) {
        return jobAppRepository.save(jobApp);
    }

    // Update an existing job application
    public JobAppEntity updateJob(Long id, JobAppEntity updatedJob) {
        JobAppEntity existingJob = jobAppRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Application not found with id: " + id));

        existingJob.setJobTitle(updatedJob.getJobTitle());
        existingJob.setCompanyName(updatedJob.getCompanyName());
        existingJob.setJobDescription(updatedJob.getJobDescription());
        existingJob.setLocation(updatedJob.getLocation());
        existingJob.setSalary(updatedJob.getSalary());

        return jobAppRepository.save(existingJob);
    }

    // Delete a job application by ID
    public void deleteJob(Long id) {
        if (!jobAppRepository.existsById(id)) {
            throw new RuntimeException("Job Application not found with id: " + id);
        }
        jobAppRepository.deleteById(id);
    }
}

