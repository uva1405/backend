package com.examly.springapp.service.impl;

import java.util.List;
import com.examly.springapp.model.JobApplication;

public interface JobApplicationService {
    JobApplication create(JobApplication jobApplication);
    List<JobApplication> getAll();
    JobApplication getById(Long id);
}
