package com.ProyectoFinal.main.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProyectoFinal.main.servicios.UsuarioRegServicio;
import com.ProyectoFinal.main.servicios.VehiculoServicio;

import lombok.Getter;
import lombok.Setter;

@Controller
@RequestMapping("/User/")
public class UsuarioController {
		
	@Autowired
	@Getter @Setter
	private UsuarioRegServicio userRegService;
		
	@Autowired
	@Getter @Setter
	private VehiculoServicio vehService;
	

	@GetMapping("/")
	public String index() {
		return "User/veh-stock-user";
	}
}
