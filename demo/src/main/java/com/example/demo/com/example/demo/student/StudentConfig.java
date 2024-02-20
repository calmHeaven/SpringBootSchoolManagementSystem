package com.example.demo.com.example.demo.student;

import java.time.LocalDate;
import static java.time.Month.*;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args-> {
            Student mariam = new Student(
				"Mariam",
				"mariam.jamal@gmail.com",
				LocalDate.of(2000, JANUARY,5),
                "Mathematics",
                3 

                
			);
            Student alex = new Student(
				"Alex",
				"alex@gmail.com",
				LocalDate.of(2004, JANUARY, 5),
                "Applied Computer Science",
                4
				);
            repository.saveAll(List.of(mariam, alex)
            );
        };
    }
}
