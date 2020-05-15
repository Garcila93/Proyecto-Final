package com.ProyectoFinal.main.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class UsuarioReg {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nomUser, pass, nombre, apellidos, correo, direccion, telCont;

	public UsuarioReg(String nomUser, String pass, String nombre, String apellidos, String correo, String direccion,
			String telCont) {
		super();
		this.nomUser = nomUser;
		this.pass = pass;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.direccion = direccion;
		this.telCont = telCont;
	}

}
