package com.project.department_service.controller;


import com.project.department_service.dto.DepartmentDTO;
import com.project.department_service.entity.Department;
import com.project.department_service.form.DepartmentFilterForm;
import com.project.department_service.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {

    private final ModelMapper modelMapper;
    private final IDepartmentService service;

    @GetMapping()
    public Page<DepartmentDTO> getAllDepartments(
            Pageable pageable,
            @RequestParam(name = "search", required = false) String search,
            DepartmentFilterForm filterForm
    ){
        Page<Department> entityPages = service.getAllDepartments(pageable, search, filterForm);
        List<DepartmentDTO> dtos = modelMapper.map(
                entityPages.getContent(),
                new TypeToken<List<DepartmentDTO>>() {}.getType());

        Page<DepartmentDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());
        return dtoPages;
    }

    @GetMapping(value = "/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable(name = "id") int id) {
        Department entity = service.getDepartmentById(id);
        DepartmentDTO dto = modelMapper.map(entity, DepartmentDTO.class);
        return dto;
    }
}
