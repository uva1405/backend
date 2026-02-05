package com.examly.springapp.service.impl;

import com.examly.springapp.model.JobApplication;
import com.examly.springapp.repository.JobApplicationRepository;
import com.examly.springapp.service.JobApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository repo;

    public JobApplicationServiceImpl(JobApplicationRepository repo) {
        this.repo = repo;
    }

    @Override
    public JobApplication create(JobApplication application) {
        application.setApplicationId(null);
        return repo.save(application);
    }

    @Override
    public List<JobApplication> getAll() {
        return repo.findAll();
    }

    @Override
    public JobApplication getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Application not found"));
    }

    @Override
    public JobApplication update(Long id, JobApplication application) {
        JobApplication existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Application not found"));
        
        existing.setCoverLetter(application.getCoverLetter());
        existing.setResumeUrl(application.getResumeUrl());
        existing.setStatus(application.getStatus());
        existing.setPriority(application.getPriority());
        
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Job Application not found");
        }
        repo.deleteById(id);
    }
}
