package com.project.department_service.service;

import com.project.department_service.entity.Department;
import com.project.department_service.form.DepartmentFilterForm;
import com.project.department_service.repository.IDepartmentRepository;
import com.project.department_service.specification.department.DepartmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service

public class DepartmentService implements IDepartmentService{

    @Autowired
    private IDepartmentRepository repository;

    @Override
    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm filterForm) {
        Specification<Department> where = DepartmentSpecification.buildWhere(search, filterForm);
        return repository.findAll(where, pageable);
    }

    @Override
    public Department getDepartmentById(int id) {
        return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    }
}
