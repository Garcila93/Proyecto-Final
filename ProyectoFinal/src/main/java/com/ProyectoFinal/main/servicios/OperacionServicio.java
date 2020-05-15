package com.ProyectoFinal.main.servicios;

import org.springframework.stereotype.Service;

import com.ProyectoFinal.main.modelo.Operacion;
import com.ProyectoFinal.main.repositorio.IOperacionRepository;
import com.ProyectoFinal.main.servicios.base.BaseService;

@Service
public class OperacionServicio extends BaseService<Operacion, Long, IOperacionRepository> {

	public OperacionServicio(IOperacionRepository repo) {
		super(repo);
	}

}
