package com.ProyectoFinal.main.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaOpe;
	
	//asociciacion ope-emp
	@ManyToOne
	private Empleados Empleados;
	
	//asociacion ope-user
	@ManyToOne
	private UsuarioReg usuarioReg;
	
	//asociacion ope-vehi
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="operacion")
	private List<Vehiculo> vehiculosOpe = new ArrayList<>();
	
	public Operacion(long idOperacion, double precioTotal, LocalDate fechaOpe) {
		super();
		this.idOperacion = idOperacion;
		this.precioTotal = precioTotal;
		this.fechaOpe = fechaOpe;
	}

	//helpers Oper-vehiStock
	public void addVehiculoOpe(Vehiculo veh) {
		this.vehiculosOpe.add(veh);
		veh.setOperacion(this);
	}
	
	public void removeVehiculosOpe(Vehiculo veh) {
		this.vehiculosOpe.remove(veh);
		veh.setOperacion(null);
	}

}
