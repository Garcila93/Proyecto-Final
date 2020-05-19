package com.ProyectoFinal.main.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@Entity
public class Vehiculo {

	@Id
	@GeneratedValue
	private long id;
	
	private String numBastidor, matricula, marca, modelo, tipoAuto,tipoCombustible, estado;
	private int motor, cv, km;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaAlta, fechaCompra, fechaVenta;
	private double precio;
	
	@ManyToOne
	private Carrito carrito;
	
	@ManyToOne
	private Operacion operacion;
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy="vehiculosFav")
	private List<UsuarioReg> UsuariosReg = new ArrayList<>();
	
	public Vehiculo(String numBastidor, String matricula, String marca, String modelo, String tipoAuto,
			String tipoCombustible, String estado, int motor, int cv, int km, LocalDate fechaAlta2,
			LocalDate fechaCompra2, LocalDate fechaVenta2, double precio) {
		super();
		this.numBastidor = numBastidor;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoAuto = tipoAuto;
		this.tipoCombustible = tipoCombustible;
		this.estado = estado;
		this.motor = motor;
		this.cv = cv;
		this.km = km;
		this.fechaAlta = fechaAlta2;
		this.fechaCompra = fechaCompra2;
		this.fechaVenta = fechaVenta2;
		this.precio = precio;
	}
	
	
}
