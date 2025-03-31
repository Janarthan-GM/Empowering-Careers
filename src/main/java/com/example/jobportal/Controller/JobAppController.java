package com.example.jobportal.Controller;


import com.example.jobportal.model.JobAppEntity;
import com.example.jobportal.Service.JobAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobAppController {

    private final JobAppService jobAppService;

    public JobAppController(JobAppService jobAppService) {
        this.jobAppService = jobAppService;
    }

    @GetMapping
    public List<JobAppEntity> getAllJobs() {
        return jobAppService.getAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobAppEntity> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobAppService.getJobById(id));
    }

    @PostMapping
    public ResponseEntity<JobAppEntity> createJob(@RequestBody JobAppEntity jobPosting) {
        return ResponseEntity.ok(jobAppService.createJob(jobPosting));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobAppEntity> updateJob(@PathVariable Long id, @RequestBody JobAppEntity jobPosting) {
        return ResponseEntity.ok(jobAppService.updateJob(id, jobPosting));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobAppService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}
