package com.ProyectoFinal.main.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
public class Carrito {

	@Id
	@GeneratedValue
	private long id;
	
	private long idCarrito;
	private double descuento;
	private int numArticulo;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="Carrito", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehiculo> componentes = new ArrayList<>();
	
	public Carrito(long idCarrito, double descuento, int numArticulo) {
		super();
		this.idCarrito = idCarrito;
		this.descuento = descuento;
		this.numArticulo = numArticulo;
	}
	

}
