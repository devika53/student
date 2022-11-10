package com.example.student.services;

import com.example.student.dto.CourseDto;
import com.example.student.dto.DepartmentDto;
import com.example.student.entity.Course;
import com.example.student.entity.Department;
import com.example.student.repository.CourseRepository;
import com.example.student.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public String addNewCourse(CourseDto Coursedetails) {
        Course e =new Course();
        e.setCourseName(Coursedetails.getCourseName());
        courseRepository.save(e);
        return "Successfully saved the course details";

    }
}
