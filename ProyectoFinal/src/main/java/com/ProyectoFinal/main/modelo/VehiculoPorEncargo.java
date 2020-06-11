package com.ProyectoFinal.main.modelo;

import java.time.LocalDate;
import java.util.List;

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
	
	//Constructor
	
	public VehiculoPorEncargo(String numBastidor, String matricula, String marca, String modelo, String tipoAuto,
			String tipoCombustible, String estado, String imagen, int motor, int cv, int km, LocalDate fechaAlta,
			LocalDate fechaCompra, LocalDate fechaVenta, double precio, Carrito carrito, Operacion operacion,
			List<UsuarioReg> usuariosReg, String color, boolean llantasAle, boolean lunasTint, boolean ac,
			boolean navegador, boolean farosLed) {
		super(numBastidor, matricula, marca, modelo, tipoCombustible, estado, imagen, motor, cv, km,
				fechaAlta, fechaCompra, fechaVenta, precio, carrito, operacion, usuariosReg);
		this.color = color;
		this.llantasAle = llantasAle;
		this.lunasTint = lunasTint;
		this.ac = ac;
		this.navegador = navegador;
		this.farosLed = farosLed;
	}
	



	
	

}
