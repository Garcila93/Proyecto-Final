package com.ProyectoFinal.main.controlador;

import org.springframework.beans.factory.annotation.Autowired;

import com.ProyectoFinal.main.servicios.UsuarioRegServicio;
import com.ProyectoFinal.main.servicios.VehiculoServicio;

import lombok.Getter;
import lombok.Setter;

public class EmpleadoController {

	@Autowired
	@Getter @Setter
	private UsuarioRegServicio userRegService;
	
	@Autowired
	@Getter @Setter
	private VehiculoServicio vehService;
	
}
