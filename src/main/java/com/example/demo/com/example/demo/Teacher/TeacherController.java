package com.example.demo.com.example.demo.Teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = { "api/v1/teacher"})
public class TeacherController {
private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping()
    public List<Teacher> getTeacher() {
        return teacherService.getTeachers();
    }

    @PostMapping
    public void registerNewTeacher(Teacher teacher) {
        teacherService.addNewTeacher(teacher);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteTeacher(@PathVariable("studentID") Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

    @PutMapping(path = "{teacherId}")
    public void updateTeacher(
            @PathVariable("teacherId") Long teacherId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String faculty,
            @RequestParam(required = false) String degree) {
        teacherService.updateTeacher(teacherId, name, email, faculty, degree);
    }
}
