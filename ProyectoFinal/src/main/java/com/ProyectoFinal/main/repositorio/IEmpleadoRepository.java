package com.ProyectoFinal.main.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoFinal.main.modelo.Empleados;

public interface IEmpleadoRepository extends JpaRepository<Empleados, Long>{

}
