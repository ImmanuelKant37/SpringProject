package com.microservicio.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.microservicio.app.controller"}) //Buscar controladores en carpetas con este nombre
public class MicroservicioEjemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioEjemploApplication.class, args);
	}

}
