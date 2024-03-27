package com.example.demo.com.example.demo.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = { "api/v1/student"})
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public ResponseEntity<?> getStudents(@RequestParam(required = false) Long studentId) {
        if (studentId != null) {
            Student student = studentService.getStudents(studentId);
            if (student != null) {
                return ResponseEntity.ok(student);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            List<Student> students = studentService.getStudents();
            return ResponseEntity.ok(students);
        }
    }

    @PostMapping
    public void registerNewStudent(Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) int years,
            @RequestParam(required = false) String major) {
        studentService.updateStudent(studentId, name, email, years, major);
    }
}
