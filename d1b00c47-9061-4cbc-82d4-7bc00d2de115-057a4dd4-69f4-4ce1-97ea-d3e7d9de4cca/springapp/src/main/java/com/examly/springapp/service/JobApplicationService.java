package com.examly.springapp.service;

import com.examly.springapp.model.JobApplication;
import java.util.List;

public interface JobApplicationService {
    JobApplication create(JobApplication application);
    List<JobApplication> getAll();
    JobApplication getById(Long id);
    JobApplication update(Long id, JobApplication application);
    void delete(Long id);
}