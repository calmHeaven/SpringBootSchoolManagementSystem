package com.example.demo.com.example.demo.Registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.com.example.demo.Student.Student;
import com.example.demo.com.example.demo.Student.StudentService;

@RestController
@RequestMapping(path = { "api/v1/register" })
public class RegistrationController {
    private final StudentService studentService;

    @Autowired
    public RegistrationController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("Student", new Student());

        return "index";
    }

}