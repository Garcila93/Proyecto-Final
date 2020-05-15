package com.ProyectoFinal.main.servicios;

import org.springframework.stereotype.Service;

import com.ProyectoFinal.main.modelo.Empleados;
import com.ProyectoFinal.main.repositorio.IEmpleadoRepository;
import com.ProyectoFinal.main.servicios.base.BaseService;

@Service
public class EmpleadoServicio extends BaseService<Empleados, Long, IEmpleadoRepository>{
	
	public EmpleadoServicio(IEmpleadoRepository repo) {
		super(repo);
		
	}

}
