package com.sid.reactive_programming_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication(scanBasePackages = "com.sid.reactive_programming_practice.${intro}")
@EnableR2dbcRepositories(basePackages = "com.sid.reactive_programming_practice.${intro}")
public class ReactiveProgrammingPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingPracticeApplication.class, args);
	}

}
