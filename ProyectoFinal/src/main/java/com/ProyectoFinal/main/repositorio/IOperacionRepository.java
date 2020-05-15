package com.ProyectoFinal.main.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoFinal.main.modelo.Operacion;

public interface IOperacionRepository extends JpaRepository<Operacion, Long>{

}
