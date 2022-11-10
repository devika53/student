package com.example.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="students")
public class Student {
        @ManyToOne
        @JoinColumn(name = "dept_id")
        private Department department;
        @ManyToMany
        @JoinTable(name="student_course",
                joinColumns={
                        @JoinColumn(name = "student_id", referencedColumnName = "id",nullable = false,updatable = false)},
                inverseJoinColumns={@JoinColumn(name = "course_id",referencedColumnName = "id",nullable = false,updatable = false)}
        )
        private Set<Course> courses=new HashSet<>();
        public void addCourse(Course course) {
                courses.add(course);

        }
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;
        private String firstName;
        private String lastName;
        private String gender;
        private String address;
        private String marks;
}

