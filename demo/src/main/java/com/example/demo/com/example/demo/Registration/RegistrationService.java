package com.example.demo.com.example.demo.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.com.example.demo.Student.*;

@Service
public class RegistrationService {

    @Autowired
    private StudentRepository studentRepository;

    public void registerNewStudent(Student student) {
        // Perform registration logic, such as validation, data manipulation, etc.
        // For simplicity, let's just save the student to the database
        studentRepository.save(student);
    }
}
