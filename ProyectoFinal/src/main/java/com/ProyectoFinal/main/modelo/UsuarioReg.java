package com.ProyectoFinal.main.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@Entity
public class UsuarioReg implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique = true)
	private String email;
	
	
	private String password;
	
	private String nombre, apellidos, direccion, telCont;
	
	private boolean admin=false;
	
	//Asocicacion user-operciones
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="usuarioReg")
	private List<Operacion> operaciones = new ArrayList<>();
	
	//asociacion user-carrito
	@OneToOne
	private Carrito carrito;
	
	//asociacion user-vehiculos
	@ManyToMany
	@JoinTable(
		joinColumns = @JoinColumn(name="Usuario"),
		inverseJoinColumns = @JoinColumn(name="Vehiculo_Fav")
	)
	private List<Vehiculo> vehiculosFav = new ArrayList<>();
	
	//Constructores

	public UsuarioReg(String email, String password, String nombre, String apellidos, String direccion, String telCont,
			boolean admin, List<Operacion> operaciones, Carrito carrito, List<Vehiculo> vehiculosFav) {
		super();
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telCont = telCont;
		this.admin = admin;
		this.operaciones = operaciones;
		this.carrito = carrito;
		this.vehiculosFav = vehiculosFav;
	}


	// Helpers OneToMany user-ope
	public void addOperacionUser(Operacion ope) {
		this.operaciones.add(ope);
		ope.setUsuarioReg(this);
	}
	
	public void removeOperacionUser(Operacion ope) {
		this.operaciones.remove(ope);
		ope.setUsuarioReg(null);
	}

	//Helpers ManyToMany user-vehiculosFav
	public void addVehiculoFav(Vehiculo veh) {
		vehiculosFav.add(veh);
		veh.getUsuariosReg().add(this);
	}
	
	public void removeVehiculosFav(Vehiculo veh) {
		vehiculosFav.remove(veh);
		veh.getUsuariosReg().remove(this);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
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