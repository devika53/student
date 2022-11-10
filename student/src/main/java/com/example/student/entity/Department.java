package com.example.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="department")
public class Department {
    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Student> students;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String deptName;
}
