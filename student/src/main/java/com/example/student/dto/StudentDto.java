package com.example.student.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class StudentDto {
        private Long id;
        private String firstName;
        private String lastName;
        private String gender;
        private String address;
        private String marks;
        private Long dept_id;
        private Long course_id;

    }
