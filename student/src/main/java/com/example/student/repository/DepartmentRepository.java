package com.example.student.repository;

import com.example.student.entity.Department;
import com.example.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
