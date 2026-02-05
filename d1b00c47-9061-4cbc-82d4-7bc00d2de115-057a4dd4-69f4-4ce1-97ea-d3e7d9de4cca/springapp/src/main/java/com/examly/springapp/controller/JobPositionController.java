package com.examly.springapp.controller;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.service.JobPositionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin(origins = "*")
public class JobPositionController {

    private final JobPositionService service;

    public JobPositionController(JobPositionService service) {
        this.service = service;
    }

    @PostMapping("/department/{departmentId}")
    public ResponseEntity<JobPosition> addJob(
            @PathVariable Long departmentId,
            @RequestBody JobPosition jobPosition) {
        JobPosition created = service.addJob(departmentId, jobPosition);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<JobPosition>> getAllJobs() {
        List<JobPosition> jobs = service.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosition> getJobById(@PathVariable Long id) {
        JobPosition job = service.getJobById(id);
        return ResponseEntity.ok(job);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosition> updateJob(@PathVariable Long id, @RequestBody JobPosition jobPosition) {
        JobPosition updated = service.updateJob(id, jobPosition);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        service.deleteJob(id);
        return ResponseEntity.ok().build();
    }
}
