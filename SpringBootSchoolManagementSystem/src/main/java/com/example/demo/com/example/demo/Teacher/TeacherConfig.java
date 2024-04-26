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
    CommandLineRunner commandLineRunner(TeacherRepository repository){
        return args-> {
            Teacher mariam = new Teacher(
				"Mariam",
				"mariam.jamal@gmail.com",
				LocalDate.of(2000, JANUARY,5),
                "Masters in Applied Mathermatics",
                "Mathematics"

                
			);
            Teacher alex = new Teacher(
				"Alex",
				"alex@gmail.com",
				LocalDate.of(2004, JANUARY, 5),
                "PhD in Computer Science",
                "Applied Computer Science"
				);
            repository.saveAll(List.of(mariam, alex)
            );
        };
    }
}
