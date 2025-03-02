package com.proyectofinal.backend_zafiro_azul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class BackendZafiroAzulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendZafiroAzulApplication.class, args);
	}
}
