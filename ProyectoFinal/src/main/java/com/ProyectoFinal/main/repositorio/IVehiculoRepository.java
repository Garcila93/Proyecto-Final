package com.ProyectoFinal.main.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoFinal.main.modelo.Vehiculo;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
	
	//Encontrar por marca
	List <Vehiculo> findByMarca (String marca);

}
