package com.example.jobportal.Service;

import com.example.jobportal.model.JobEntity;
import com.example.jobportal.repository.job_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private job_repo jobRepo;

    // Create job
    public JobEntity saveJob(JobEntity job) {
        return jobRepo.save(job);
    }

    // Bulk Insert Jobs
    public List<JobEntity> saveJobs(List<JobEntity> jobs) {
        return jobRepo.saveAll(jobs); // Bulk insert
    }

    // Read all jobs with sorting
    public List<JobEntity> getAllJobs(String sortBy) {
        return jobRepo.findAll(Sort.by(sortBy));
    }

    // Read jobs with pagination
    public Page<JobEntity> getJobsWithPagination(int page, int size) {
        return jobRepo.findAll(PageRequest.of(page, size));
    }

//    public Page<JobEntity> getJobsWithPagination(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return jobRepo.findAll(pageable);
//    }

    public List<JobEntity> getJobsSorted(String field, String order) {
        Sort sort = order.equalsIgnoreCase("desc") ? Sort.by(field).descending() : Sort.by(field).ascending();
        return jobRepo.findAll(sort);
    }

    // Read a single job by ID
    public Optional<JobEntity> getJobById(Long id) {
        return jobRepo.findById(id);
    }

    // Delete a job
    public void deleteJob(Long id) {
        jobRepo.deleteById(id);
    }
    // Delete a job
//    public void deleteJob(String location) {
//        jobRepo.deleteByLocation(location);
//    }


    // Find jobs by title using JPA
    public List<JobEntity> findJobsByTitle(String title,String location) {
        return jobRepo.findBySpecs(title,location);
    }
    // Find jobs by title and loc using JPA
    public List<JobEntity> findJobsByCompany(String title,String location) {
        return jobRepo.findBySpecs(title,location);
    }
    // Find jobs by loc using JPA
    public List<JobEntity>findloc(String location)
    {
        return jobRepo.findByLocation(location);
    }

    // update jobs by sal and loc
    public JobEntity updateJob(Long id, JobEntity updatedJob) {
        Optional<JobEntity> jobOptional = jobRepo.findById(id);
        if (jobOptional.isPresent()) {
            JobEntity job = jobOptional.get();
            job.setSalary(updatedJob.getSalary());
            job.setLocation(updatedJob.getLocation());
            return jobRepo.save(job); }
        return null;  } }
