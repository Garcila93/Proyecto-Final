package com.ProyectoFinal.main.modelo;

import java.util.Date;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @EqualsAndHashCode(callSuper=true) @ToString(callSuper=true) @NoArgsConstructor
@Entity
public class VehiculoPorEncargo extends Vehiculo {
	
	private String color;
	private boolean llantasAle;
	private boolean lunasTint;
	private boolean ac;
	private boolean navegador;
	private boolean farosLed;
	
	public VehiculoPorEncargo(String numBastidor, String matricula, String marca, String modelo, String tipoAuto,
			String tipoCombustible, String estado, int motor, int cv, int km, Date fechaAlta, Date fechaCompra,
			Date fechaVenta, double precio, String color, boolean llantasAle, boolean lunasTint, boolean ac,
			boolean navegador, boolean farosLed) {
		super(numBastidor, matricula, marca, modelo, tipoAuto, tipoCombustible, estado, motor, cv, km, fechaAlta,
				fechaCompra, fechaVenta, precio);
		this.color = color;
		this.llantasAle = llantasAle;
		this.lunasTint = lunasTint;
		this.ac = ac;
		this.navegador = navegador;
		this.farosLed = farosLed;
	}


	
	

}
