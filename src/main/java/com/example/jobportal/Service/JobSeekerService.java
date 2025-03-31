package com.example.jobportal.Service;

import com.example.jobportal.model.JobSeeker;
import com.example.jobportal.repository.JobSeeker_repo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerService {

    private final JobSeeker_repo jobSeekerRepository;

    public JobSeekerService(JobSeeker_repo jobSeekerRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
    }

    // Get all jobseekers
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }

    // Get jobseeker by ID
    public JobSeeker getJobSeekerById(Long id) {
        return jobSeekerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Seeker not found with id: " + id));
    }

    // Create new jobseeker
    public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }

    // Update jobseeker details
    public JobSeeker updateJobSeeker(Long id, JobSeeker updatedJobSeeker) {
        JobSeeker existingJobSeeker = jobSeekerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Seeker not found with id: " + id));

        existingJobSeeker.setName(updatedJobSeeker.getName());
        existingJobSeeker.setEmail(updatedJobSeeker.getEmail());


        return jobSeekerRepository.save(existingJobSeeker);
    }

    // Delete job seeker by ID
    public void deleteJobSeeker(Long id) {
        if (!jobSeekerRepository.existsById(id)) {
            throw new RuntimeException("Job Seeker not found with id: " + id);
        }
        jobSeekerRepository.deleteById(id);
    }
}
