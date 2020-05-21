package com.ProyectoFinal.main.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Empleados implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique = true)
	private String email;
	
	private String password, nombre, apellido, direccion, numTel;
	private boolean admin=false;
	
	//asociaciones empleados-operacion
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="Empleados")
	private List<Operacion> operaciones = new ArrayList<>();

	//constructor
	public Empleados(String email, String password, String nombre, String apellido, String direccion, String numTel,
			boolean admin, List<Operacion> operaciones) {
		super();
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.numTel = numTel;
		this.admin = admin;
		this.operaciones = operaciones;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		if (admin) {
			role += "ADMIN";
		} else {
			role += "USER";
		}
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}		

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
