package com.examly.springapp.service;

import com.examly.springapp.model.JobPosition;
import java.util.List;

public interface JobPositionService {
    JobPosition addJob(Long departmentId, JobPosition jobPosition);
    List<JobPosition> getAllJobs();
    JobPosition getJobById(Long id);
    JobPosition updateJob(Long id, JobPosition jobPosition);
    void deleteJob(Long id);
}