package com.example.demo.com.example.demo.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.com.example.demo.Student.*;

@CrossOrigin(origins = "http://localhost:8080/api/v1/student/")
@RequestMapping("api/v1/register")
@RestController
public class RegistrationController {

    @Autowired
    private StudentService studentService;

    @Autowired
    public RegistrationController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // return the name of the HTML file (without the extension) containing the
                           // registration form
    }

    @PostMapping
    @ResponseBody
    public String registerNewStudent(@ModelAttribute("user") Student student) {
        studentService.addNewStudent(student);
        return "redirect:/register?success";
    }
}
