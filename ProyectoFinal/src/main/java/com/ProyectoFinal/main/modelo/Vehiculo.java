package com.ProyectoFinal.main.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Vehiculo {

	@Id
	@GeneratedValue
	private long id;
	
	private String numBastidor, matricula, marca, modelo, tipoAuto,tipoCombustible, estado;
	private int motor, cv, km;
	private Date fechaAlta, fechaCompra, fechaVenta;
	private double precio;
	
	public Vehiculo(String numBastidor, String matricula, String marca, String modelo, String tipoAuto,
			String tipoCombustible, String estado, int motor, int cv, int km, Date fechaAlta,
			Date fechaCompra, Date fechaVenta, double precio) {
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
		this.fechaAlta = fechaAlta;
		this.fechaCompra = fechaCompra;
		this.fechaVenta = fechaVenta;
		this.precio = precio;
	}
	
	
}
