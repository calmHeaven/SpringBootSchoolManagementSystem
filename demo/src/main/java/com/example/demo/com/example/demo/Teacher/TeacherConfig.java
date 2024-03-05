package com.example.demo.com.example.demo.Teacher;

import java.time.LocalDate;
import static java.time.Month.*;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherConfig {

    @Bean
    CommandLineRunner commandLineRunner(teacherRepository repository){
        return args-> {
            Teacher mariam = new Teacher(
				"Mariam",
				"mariam.jamal@gmail.com",
				LocalDate.of(2000, JANUARY,5),
                "Mathematics",
                "Masters in Applied Mathermatics"

                
			);
            Teacher alex = new Teacher(
				"Alex",
				"alex@gmail.com",
				LocalDate.of(2004, JANUARY, 5),
                "Applied Computer Science",
                "PhD in Computer Science"
				);
            repository.saveAll(List.of(mariam, alex)
            );
        };
    }
}
