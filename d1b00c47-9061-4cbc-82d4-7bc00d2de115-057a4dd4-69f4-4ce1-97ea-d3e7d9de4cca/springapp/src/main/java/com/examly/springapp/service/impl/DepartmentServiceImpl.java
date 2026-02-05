package com.examly.springapp.service.impl;

import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import com.examly.springapp.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentServiceImpl(DepartmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Department create(Department department) {
        department.setDepartmentId(null);
        return repo.save(department);
    }

    @Override
    public List<Department> getAll() {
        return repo.findAll();
    }

    @Override
    public Department getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public Department update(Long id, Department department) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Department not found");
        }
        department.setDepartmentId(id);
        return repo.save(department);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Department not found");
        }
        repo.deleteById(id);
    }
}
