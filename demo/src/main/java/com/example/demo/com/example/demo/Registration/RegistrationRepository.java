package com.example.demo.com.example.demo.Registration;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.com.example.demo.Student.Student;

public interface RegistrationRepository {
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
