package com.ProyectoFinal.main.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	//asociciacion ope-emp
	@ManyToOne
	private Empleados Empleados;
	
	//asociacion ope-user
	@ManyToOne
	private UsuarioReg UsuarioReg;
	
	//asociacion ope-vehi
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="Operacion")
	private List<Vehiculo> vehiculosOpe = new ArrayList<>();
	
	public Operacion(long idOperacion, double precioTotal, Date fechaOpe) {
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
