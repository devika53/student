package com.example.student.services;

import com.example.student.dto.StudentDto;
import com.example.student.entity.Course;
import com.example.student.entity.Student;
import com.example.student.repository.CourseRepository;
import com.example.student.repository.DepartmentRepository;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.courseRepository = courseRepository;
    }
    public String addNewStudent(StudentDto Studentdetails) {
        Student e =new Student();
        e.setFirstName(Studentdetails.getFirstName());
        e.setLastName(Studentdetails.getLastName());
        e.setGender(Studentdetails.getGender());
        e.setAddress(Studentdetails.getAddress());
        e.setMarks(Studentdetails.getMarks());
        departmentRepository.findById(Studentdetails.getDept_id())
                .map(dept -> {

                            e.setDepartment(dept);
                    return null;
                });
        Optional<Course> course = courseRepository.findById(Studentdetails.getCourse_id());
        e.addCourse(course.get());
        studentRepository.save(e);
        return "Successfully saved the employee details";
    }
    public List<Student> getNewStudent(String  name) {

        if (studentRepository.findByFirstName(name).isEmpty()){
            throw new RuntimeException("Something went wrong");
        }
        return studentRepository.findByFirstName(name);
    }

    public void deleteStudentById(long id) {

        studentRepository.deleteById(id);

    }
}
