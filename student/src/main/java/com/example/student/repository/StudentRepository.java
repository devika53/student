package com.example.student.repository;

import com.example.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long>

    {

        //@Query("SELECT e FROM Employee e WHERE e.firstName = :name ")
        //List<Employee> findByFirstName(@Param("name") String name);
        @Query(value = "SELECT * FROM students e WHERE e.first_name = :name", nativeQuery = true)
        List<Student> findByFirstName(@Param("name") String name);
    }



