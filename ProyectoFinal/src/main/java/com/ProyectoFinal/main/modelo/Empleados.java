package com.ProyectoFinal.main.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
public class Empleados extends Usuario{
	
	private static final long serialVersionUID = 1L;
	
	//asociaciones empleados-operacion
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="Empleados")
	private List<Operacion> operaciones = new ArrayList<>();

	//Constructor
	public Empleados(Long id, String email, String password, String nombre, String apellidos, String direccion,
			String numTel, boolean admin, List<Operacion> operaciones) {
		super(id, email, password, nombre, apellidos, direccion, numTel, admin);
		this.operaciones = operaciones;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
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
