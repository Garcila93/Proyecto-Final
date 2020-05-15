package com.ProyectoFinal.main.servicios;

import org.springframework.stereotype.Service;

import com.ProyectoFinal.main.modelo.Carrito;
import com.ProyectoFinal.main.repositorio.ICarritoRepository;
import com.ProyectoFinal.main.servicios.base.BaseService;

@Service
public class CarritoServicio extends BaseService<Carrito, Long, ICarritoRepository> {

	public CarritoServicio(ICarritoRepository repo) {
		super(repo);
	}

}
