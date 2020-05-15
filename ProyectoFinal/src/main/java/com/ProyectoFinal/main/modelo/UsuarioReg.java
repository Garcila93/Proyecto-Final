package com.ProyectoFinal.main.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@Entity
public class UsuarioReg {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nomUser, pass, nombre, apellidos, correo, direccion, telCont;
	
	//Asocicacion user-operciones
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="UsuarioReg")
	private List<Operacion> operaciones = new ArrayList<>();
	
	//asociacion user-carrito
	@OneToOne
	private Carrito carrito;
	
	//asociacion user-vehiculos
	@ManyToMany
	@JoinTable(
		joinColumns = @JoinColumn(name="Usuario"),
		inverseJoinColumns = @JoinColumn(name="Vehiculo Fav")
	)
	private List<Vehiculo> VehiculosFav = new ArrayList<>();
	
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
		VehiculosFav.add(veh);
		veh.getUsuariosReg().add(this);
	}
	
	public void removeVehiculosFav(Vehiculo veh) {
		VehiculosFav.remove(veh);
		veh.getUsuariosReg().remove(this);
	}
}
