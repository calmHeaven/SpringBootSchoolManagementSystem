package com.example.demo.com.example.demo.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.com.example.demo.Student.*;

@Controller
@RequestMapping("api/v1/register")
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
    public String registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
        return "Student registration successful!";
    }
}
