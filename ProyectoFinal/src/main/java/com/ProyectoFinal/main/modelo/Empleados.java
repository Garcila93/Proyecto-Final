package com.ProyectoFinal.main.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@Entity
public class Empleados {
	
	@Id
	@GeneratedValue
	private long id;
	private String nomUser, pass, nombre, apellido, correo, direccion, numTel;
	
	//asociaciones empleados-operacion
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="Empleados")
	private List<Operacion> operaciones = new ArrayList<>();
	
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
	
	//Helpers asociacion emp-ope
	public void addOperacionAdmin(Operacion ope) {
		this.operaciones.add(ope);
		ope.setEmpleados(this);
	}
	
	public void removeOperacionAdmin(Operacion ope) {
		this.operaciones.remove(ope);
		ope.setEmpleados(null);;
	}
	
	

	
	
	
	

}
