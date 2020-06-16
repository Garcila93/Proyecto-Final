package com.ProyectoFinal.main.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ProyectoFinal.main.modelo.Admin;
import com.ProyectoFinal.main.servicios.AdminServicio;
import com.ProyectoFinal.main.servicios.EmpleadoServicio;
import com.ProyectoFinal.main.servicios.UsuarioRegServicio;
import com.ProyectoFinal.main.servicios.VehiculoServicio;


import lombok.Getter;
import lombok.Setter;

@Controller
@RequestMapping("/Admin/")
public class AdminController {
	
	@Autowired
	@Getter @Setter
	private UsuarioRegServicio userRegService;
	
	@Autowired
	@Getter @Setter
	private EmpleadoServicio empService;
	
	@Autowired
	@Getter @Setter
	private VehiculoServicio vehService;
	
	@Autowired
	@Getter @Setter
	private AdminServicio adminService;
	
	@GetMapping("/")
	public String adminViewHome(Model model, @AuthenticationPrincipal Admin Admin){
	
		model.addAttribute("nombre",Admin.getNombre());
		
		return "Admin/admin-view-home";
	}

	@GetMapping("/admin-view-list")
	public String adminViewList(@RequestParam(name="nombre", required=false, defaultValue="user")String nombre, Model model){
	
		model.addAttribute("nombre", nombre);
		
		return "Admin/admin-view-list";
	}
}
