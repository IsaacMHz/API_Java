package com.curso.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMavenApplication.class, args);
		System.out.println("Ejecutando...");
	}
}
