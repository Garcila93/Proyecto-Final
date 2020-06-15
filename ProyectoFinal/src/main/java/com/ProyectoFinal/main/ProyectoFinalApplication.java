package com.ProyectoFinal.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import com.ProyectoFinal.main.modelo.Admin;
import com.ProyectoFinal.main.modelo.Empleados;
import com.ProyectoFinal.main.modelo.UsuarioReg;
import com.ProyectoFinal.main.modelo.Vehiculo;
import com.ProyectoFinal.main.servicios.EmpleadoServicio;
import com.ProyectoFinal.main.servicios.UsuarioRegServicio;
import com.ProyectoFinal.main.servicios.VehiculoServicio;

@SpringBootApplication
public class ProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}
	
	@Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    }
	@Bean
	public CommandLineRunner init(UsuarioRegServicio userRegServicio,EmpleadoServicio empServicio,VehiculoServicio VehServicio, BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			
			UsuarioReg u = new UsuarioReg();
			u.setAdmin(false);
			u.setNombre("Luis Miguel");
			u.setApellidos("López");
			u.setEmail("luismi.lopez@email.com");
			u.setPassword(passwordEncoder.encode("1234"));
			
			userRegServicio.save(u);
			
			
			Empleados a = new Admin();

			a.setAdmin(true);
			a.setNombre("Ángel");
			a.setApellido("Narajo");
			a.setEmail("angel.naranjo@email.com");
			a.setPassword(passwordEncoder.encode("1234"));
			
			empServicio.save(a);
			
			/*
			Vehiculo v= new Vehiculo();
			v.setNumBastidor("WP0AA2A96BS255642");
			v.setMatricula("7501DJK");
			v.setMarca("Ford");
			v.setModelo("F350");
			v.setTipoCombustible("Gasolina");
			*/
			
		};

		
	}

}
