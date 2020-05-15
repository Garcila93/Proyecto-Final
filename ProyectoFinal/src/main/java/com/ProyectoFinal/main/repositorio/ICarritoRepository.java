package com.ProyectoFinal.main.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoFinal.main.modelo.Carrito;

public interface ICarritoRepository extends JpaRepository<Carrito, Long> {

}
