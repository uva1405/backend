package com.examly.springapp.service.impl;

import com.examly.springapp.model.Department;
import com.examly.springapp.model.JobPosition;
import com.examly.springapp.repository.DepartmentRepository;
import com.examly.springapp.repository.JobPositionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JobPositionService{

    private final JobPositionRepository jobRepo;
    private final DepartmentRepository deptRepo;

    public JobPositionService(JobPositionRepository jobRepo,
                                  DepartmentRepository deptRepo) {
        this.jobRepo = jobRepo;
        this.deptRepo = deptRepo;
    }

    public JobPosition addJob(Long departmentId, JobPosition jobPosition) {

        Department department = deptRepo.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        jobPosition.setDepartment(department);
        return jobRepo.save(jobPosition);
    }
}
