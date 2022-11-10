package com.example.student.repository;

import com.example.student.entity.Course;
import com.example.student.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
