package com.examly.springapp.service.impl;

import com.examly.springapp.model.Department;
import com.examly.springapp.model.JobPosition;
import com.examly.springapp.repository.DepartmentRepository;
import com.examly.springapp.repository.JobPositionRepository;
import com.examly.springapp.service.JobPositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobPositionServiceImpl implements JobPositionService {

    private final JobPositionRepository jobRepo;
    private final DepartmentRepository deptRepo;

    public JobPositionServiceImpl(JobPositionRepository jobRepo,
                                  DepartmentRepository deptRepo) {
        this.jobRepo = jobRepo;
        this.deptRepo = deptRepo;
    }

    @Override
    public JobPosition addJob(Long departmentId, JobPosition jobPosition) {
        Department department = deptRepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        jobPosition.setDepartment(department);
        return jobRepo.save(jobPosition);
    }

    @Override
    public List<JobPosition> getAllJobs() {
        return jobRepo.findAll();
    }

    @Override
    public JobPosition getJobById(Long id) {
        return jobRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Position not found"));
    }

    @Override
    public JobPosition updateJob(Long id, JobPosition jobPosition) {
        JobPosition existing = jobRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Position not found"));
        
        existing.setPositionTitle(jobPosition.getPositionTitle());
        existing.setDescription(jobPosition.getDescription());
        existing.setExperienceRequired(jobPosition.getExperienceRequired());
        existing.setLocation(jobPosition.getLocation());
        existing.setOpenings(jobPosition.getOpenings());
        
        return jobRepo.save(existing);
    }

    @Override
    public void deleteJob(Long id) {
        if (!jobRepo.existsById(id)) {
            throw new RuntimeException("Job Position not found");
        }
        jobRepo.deleteById(id);
    }
}
