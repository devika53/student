package com.example.student.controller;

import com.example.student.dto.DepartmentDto;
import com.example.student.dto.StudentDto;
import com.example.student.entity.Student;
import com.example.student.services.DepartmentService;
import com.example.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")

public class HomeController {
    private final StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    @GetMapping("/home")
    public String home(){
        return "You are welcome to your student profile";
    }

    @PostMapping("/addStudent")
    public String registerNewStudent(@RequestBody StudentDto studentDto){
        studentService.addNewStudent(studentDto);
        return "Successfully saved the employee details";
    }
    @GetMapping("/student/name")
    public ResponseEntity<List<Student>> getStudentByName(@RequestParam String name) {
        return new ResponseEntity<List<Student>>(studentService.getNewStudent(name), HttpStatus.OK);
    }

    @DeleteMapping(value="/student")
    public String deleteStudent(@RequestParam(value="id") long id) {
        studentService.deleteStudentById(id);
        return "Successfully deleted the student details";
    }


}


