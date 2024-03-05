package com.example.demo.com.example.demo.Teacher;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class TeacherService {

	private final TeacherRepository studentRepository;

	@Autowired
	public TeacherService(TeacherRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping
	public List<Teacher> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Teacher student) {
		// Optional<Student> studentOptional = studentRepository
		// 		.findStudentByEmail(student.getEmail());
		// if (studentOptional.isPresent()) {
		// 	throw new IllegalStateException("email taken");
		// }
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException("student with id " + studentId + "does not exist");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional // doesn't require JPQL Query
	public void updateStudent(Long studentId, String name, String email, int years, String major) {
		Teacher student = studentRepository.findById(studentId)
				.orElseThrow(() -> new IllegalStateException("student with id " + studentId + "does not exist"));
		if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Teacher> studentOptional = studentRepository.findStudentByEmail(email);
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			student.setEmail(email);
		}
		student.setYears(years);
		student.setMajor(major);
	}
}
