package com.craftsoft.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class CraftSoftFullStackAngularSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CraftSoftFullStackAngularSpringBootApplication.class, args);
	}
}