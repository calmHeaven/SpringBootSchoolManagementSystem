package com.example.demo.com.example.demo.Student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;

@Entity
@Table

public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private String Major;
    private Integer Years;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id,
            String name,
            String email,
            LocalDate dob,
            String Major,
            Integer Years) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.Major = Major;
        this.Years = Years;
    }

    public Student(String name,
            String email,
            LocalDate dob,
            String Major,
            Integer Years) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.Major = Major;
        this.Years = Years;

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

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public String getMajor() {
        return Major;
    }

    public void setYears(Integer Years) {
        this.Years = Years;
    }

    public Integer getYears() {
        return Years;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\n id=" + id +
                "\n, name=" + name +
                "\n, email=" + email +
                "\n, dob=" + dob +
                "\n, age=" + age +
                "Major=" + Major +
                "LengthofDegree" + Years + "Years" + "\n}";
    }
}

/*
 * Switch up this Idea to have a dropdown of all the major courses in UW.
 * Make a HTTP path for registration,
 * then put all of the major courses into a sort of list DS
 * GOOD LUCK DAWGGGG!
 * 
 */