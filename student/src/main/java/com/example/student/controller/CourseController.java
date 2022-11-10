package com.example.student.controller;

import com.example.student.dto.CourseDto;
import com.example.student.dto.DepartmentDto;
import com.example.student.services.CourseService;
import com.example.student.services.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping("/addCourse")
    public String newCourse(@RequestBody CourseDto courseDto){
        courseService.addNewCourse(courseDto);
        return "Successfully saved the department details";
    }
}
