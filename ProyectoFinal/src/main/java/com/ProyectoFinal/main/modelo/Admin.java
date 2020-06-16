package com.ProyectoFinal.main.modelo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;

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
public class Admin extends Empleados {

	private static final long serialVersionUID = 1L;
	private boolean admin= true;
	
	public Admin(Long id, String email, String password, String nombre, String apellidos, String direccion,
			String numTel, boolean admin, List<Operacion> operaciones, boolean admin2) {
		super(id, email, password, nombre, apellidos, direccion, numTel, admin, operaciones);
		admin = admin2;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}
