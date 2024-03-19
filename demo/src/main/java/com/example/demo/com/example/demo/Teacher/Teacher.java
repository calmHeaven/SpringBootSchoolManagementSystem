package com.example.demo.com.example.demo.Teacher;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;

@Entity
@Table

public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private String faculty;
    private String degree;
    @Transient
    private Integer age;

    public Teacher() {
    }

    public Teacher(Long id,
            String name,
            String email,
            LocalDate dob,
            String faculty,
            String degree) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.faculty = faculty;
        this.degree = degree;
    }

    public Teacher(String name,
            String email,
            LocalDate dob,
            String degree,
            String faculty) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.faculty = faculty;
        this.degree = degree;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getDegree() {
        return this.degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\n id=" + id +
                "\n, name=" + name +
                "\n, email=" + email +
                "\n, dob=" + dob +
                "\n, age=" + age +
                "Major=" + faculty +
                "LengthofDegree" + degree + "Years" + "\n}";
    }

}

/*
 * Switch up this Idea to have a dropdown of all the major courses in UW.
 * Make a HTTP path for registration,
 * then put all of the major courses into a sort of list DB
 * GOOD LUCK DAWGGGG!
 * 
 */