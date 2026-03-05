package com.project.department_service.service;

import com.project.department_service.entity.Department;
import com.project.department_service.form.DepartmentFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {

    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm filterForm);
    public Department getDepartmentById(int id);
}
