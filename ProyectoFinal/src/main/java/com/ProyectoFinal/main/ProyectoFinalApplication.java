package com.ProyectoFinal.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}
	@Bean
	public CommandLineRunner programa() {
		
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				System.out.println("Hola Mundo");
			}
			
		};
		
	}

}
