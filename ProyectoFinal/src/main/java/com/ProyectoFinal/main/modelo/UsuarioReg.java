package com.ProyectoFinal.main.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class UsuarioReg extends Usuario {
	
	private static final long serialVersionUID = 1L;
	
	//Asocicacion user-operciones
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="usuarioReg")
	private List<Operacion> operaciones = new ArrayList<>();
	
	//asociacion user-carrito
	@OneToOne
	private Carrito carrito;
	
	//asociacion user-vehiculos
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany
	@JoinTable(
		joinColumns = @JoinColumn(name="Usuario"),
		inverseJoinColumns = @JoinColumn(name="Vehiculo_Fav")
	)
	private List<Vehiculo> vehiculosFav = new ArrayList<>();
	
	//Constructores
	public UsuarioReg(Long id, String email, String password, String nombre, String apellidos, String direccion,
			String numTel, boolean admin, List<Operacion> operaciones, Carrito carrito, List<Vehiculo> vehiculosFav) {
		super(id, email, password, nombre, apellidos, direccion, numTel, admin);
		this.operaciones = operaciones;
		this.carrito = carrito;
		this.vehiculosFav = vehiculosFav;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
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

}