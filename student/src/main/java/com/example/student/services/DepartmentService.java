package com.example.student.services;

import com.example.student.dto.DepartmentDto;
import com.example.student.dto.StudentDto;
import com.example.student.entity.Department;
import com.example.student.entity.Student;
import com.example.student.repository.DepartmentRepository;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public String addNewDepartment(DepartmentDto Departmentdetails) {
        Department e =new Department();
        e.setDeptName(Departmentdetails.getDeptName());
        departmentRepository.save(e);
        return "Successfully saved the employee details";

    }

}
