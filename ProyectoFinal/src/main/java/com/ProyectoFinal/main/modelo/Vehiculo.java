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
	
	private String numBastidor, matricula, marca, modelo, tipoAuto,tipoCombustible, estado, imagen;
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

	//Constructores
	public Vehiculo(String numBastidor, String matricula, String marca, String modelo, String tipoAuto,
			String tipoCombustible, String estado, String imagen, int motor, int cv, int km, LocalDate fechaAlta,
			LocalDate fechaCompra, LocalDate fechaVenta, double precio, Carrito carrito, Operacion operacion,
			List<UsuarioReg> usuariosReg) {
		super();
		this.numBastidor = numBastidor;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoAuto = tipoAuto;
		this.tipoCombustible = tipoCombustible;
		this.estado = estado;
		this.imagen = imagen;
		this.motor = motor;
		this.cv = cv;
		this.km = km;
		this.fechaAlta = fechaAlta;
		this.fechaCompra = fechaCompra;
		this.fechaVenta = fechaVenta;
		this.precio = precio;
		this.carrito = carrito;
		this.operacion = operacion;
		UsuariosReg = usuariosReg;
	}
}
