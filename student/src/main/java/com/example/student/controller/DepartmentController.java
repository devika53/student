package com.example.student.controller;

import com.example.student.dto.DepartmentDto;
import com.example.student.services.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping("/addDepartment")
    public String newDepartment(@RequestBody DepartmentDto departmentDto){
        departmentService.addNewDepartment(departmentDto);
        return "Successfully saved the department details";
    }
}

