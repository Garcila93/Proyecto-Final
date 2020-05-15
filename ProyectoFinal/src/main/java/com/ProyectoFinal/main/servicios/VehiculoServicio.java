package com.ProyectoFinal.main.servicios;

import org.springframework.stereotype.Service;

import com.ProyectoFinal.main.modelo.Vehiculo;
import com.ProyectoFinal.main.repositorio.IVehiculoRepository;
import com.ProyectoFinal.main.servicios.base.BaseService;

@Service
public class VehiculoServicio extends BaseService<Vehiculo, Long, IVehiculoRepository>{

	public VehiculoServicio(IVehiculoRepository repo) {
		super(repo);
	}

}
