package com.ProyectoFinal.main.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@Entity
public class Operacion {
	
	@Id
	@GeneratedValue
	private long id;
	private long idOperacion;
	private double precioTotal;
	private Date fechaOpe;
	
	@ManyToOne
	private Empleados Empleados;
	@ManyToOne
	private UsuarioReg UsuarioReg;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="Operacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehiculo> componentes = new ArrayList<>();
	
	public Operacion(long idOperacion, double precioTotal, Date fechaOpe) {
		super();
		this.idOperacion = idOperacion;
		this.precioTotal = precioTotal;
		this.fechaOpe = fechaOpe;
	}


}
