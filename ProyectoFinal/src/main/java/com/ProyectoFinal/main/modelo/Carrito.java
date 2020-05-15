package com.ProyectoFinal.main.modelo;

import java.util.ArrayList;
import java.util.List;

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
	private double precio;
	private int numArticulo;
		
	//asociacion carr-vehiStock
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="Carrito")
	private List<Vehiculo> VehiculosStock = new ArrayList<>();
	
	//asociacion carr-user
	
	public Carrito(long idCarrito, double precio, int numArticulo, List<Vehiculo> itemsCarro,
			List<Vehiculo> vehiculosStock) {
		super();
		this.idCarrito = idCarrito;
		this.precio = precio;
		this.numArticulo = numArticulo;
		VehiculosStock = vehiculosStock;
	}
	
	//Helpers carr-vehiStock
	public void addVehiculoCarr(Vehiculo veh) {
		this.VehiculosStock.add(veh);
		veh.setCarrito(this);
		}
	
	public void removeVehiculoCarr(Vehiculo veh) {
		this.VehiculosStock.remove(veh);
		veh.setCarrito(null);
		
	}



}
