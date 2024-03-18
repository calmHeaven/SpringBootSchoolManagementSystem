package com.example.demo.com.example.demo.Registration;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.com.example.demo.Student.Student;
import com.example.demo.com.example.demo.Teacher.Teacher;

public interface RegistrationRepository {
    // @Query("SELECT s FROM Student s WHERE s.email = ?1")
    // Optional<Teacher> findTeacherByEmail(String email);
    // Optional<Student> findTeacherByEmail(String email);

}
