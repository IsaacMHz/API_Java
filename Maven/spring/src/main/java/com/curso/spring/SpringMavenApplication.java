package com.curso.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.curso.spring.config"})
public class SpringMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMavenApplication.class, args);
		System.out.println("Ejecutando...");
	}
}
