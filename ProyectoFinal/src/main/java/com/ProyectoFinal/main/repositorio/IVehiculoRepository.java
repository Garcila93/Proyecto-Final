package com.ProyectoFinal.main.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoFinal.main.modelo.Vehiculo;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

}
