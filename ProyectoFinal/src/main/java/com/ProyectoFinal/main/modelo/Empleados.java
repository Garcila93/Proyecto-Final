package com.ProyectoFinal.main.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Empleados {
	
	@Id
	@GeneratedValue
	private long id;
	private String nomUser, pass, nombre, apellido, correo, direccion, numTel;
	
	//@asociacion
	
	public Empleados(String nomUser, String pass, String nombre, String apellido, String correo, String direccion,
			String numTel) {
		super();
		this.nomUser = nomUser;
		this.pass = pass;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.direccion = direccion;
		this.numTel = numTel;
	}
	
	

	
	
	
	

}
