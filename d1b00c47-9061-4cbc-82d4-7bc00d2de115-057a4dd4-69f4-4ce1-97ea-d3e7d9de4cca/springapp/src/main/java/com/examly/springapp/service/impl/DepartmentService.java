package com.examly.springapp.service.impl;

import com.examly.springapp.model.Department;
import java.util.List;

public interface DepartmentService {

    Department create(Department department);

    List<Department> getAll();

    Department getById(Long id);
}
