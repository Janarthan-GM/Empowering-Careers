package com.example.jobportal.Controller;

import com.example.jobportal.model.JobEntity;
import com.example.jobportal.Service.JobService;
import com.example.jobportal.repository.job_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private job_repo jr;

    // Create Job
    @PostMapping()
    public ResponseEntity<JobEntity> saveJob(@RequestBody JobEntity job) {
        return ResponseEntity.ok(jobService.saveJob(job));
    }


    //bulk insert data
    @PostMapping("/bulk-insert")
    public ResponseEntity<?> addMultipleJobs(@RequestBody List<JobEntity> jobs) {
        List<JobEntity> savedJobs = jobService.saveJobs(jobs);
        return ResponseEntity.ok(savedJobs);
    }

    @GetMapping("/all")
    public List<JobEntity> getJob() {
        return jr.findAll();
    }

    // Get all jobs with sorting
    @GetMapping("/sort")
    public List<JobEntity> getJobsSorted(@RequestParam String field, @RequestParam String order) {
        return jobService.getJobsSorted(field, order);
    }

    // Get jobs with pagination
    @GetMapping("/page")
    public ResponseEntity<Page<JobEntity>> getJobsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(jobService.getJobsWithPagination(page, size));
    }

    // Get job by loc
    @GetMapping("/cn")
    public List<JobEntity>findloc(@RequestParam String location)
    {
        return jobService.findloc(location);
    }

    // Get job by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<JobEntity>> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    // Delete job
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted successfully.");
    }

//    @DeleteMapping("/delete/{location}")
//    public ResponseEntity<String> deleteJob(@PathVariable String location) {
//        jobService.deleteJob(location);
//        return ResponseEntity.ok("Job deleted successfully.");
//    }

    // Search jobs by title using JPQL
    @GetMapping("/search")
    public ResponseEntity<List<JobEntity>> searchJobs(@RequestParam String title,String location) {
        return ResponseEntity.ok(jobService.findJobsByCompany(title,location));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateJob(@PathVariable Long id, @RequestBody JobEntity updatedJob) {
        JobEntity job = jobService.updateJob(id, updatedJob);
        if (job != null) {
            return ResponseEntity.ok(job);
        }
        return ResponseEntity.notFound().build();
    }
}
//    @PostMapping("add")
//    public ResponseEntity<?> addJob(@RequestBody JobEntity job) {
//        try {
//            JobEntity savedJob = jobService.saveJob(job);
//            return ResponseEntity.ok(savedJob);
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
