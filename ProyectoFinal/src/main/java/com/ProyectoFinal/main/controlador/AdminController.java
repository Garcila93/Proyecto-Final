package com.ProyectoFinal.main.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ProyectoFinal.main.modelo.Admin;
import com.ProyectoFinal.main.modelo.Empleados;
import com.ProyectoFinal.main.modelo.UsuarioReg;
import com.ProyectoFinal.main.modelo.Vehiculo;
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
	
	//inicio admin
	@GetMapping("/")
	public String adminViewHome(Model model, @AuthenticationPrincipal Admin Admin){
	
		model.addAttribute("nombre",Admin.getNombre());
		
		return "Admin/admin-view-home";
	}
	//lista de vehiculos
	@GetMapping("/admin-view-list-veh")
	public String adminViewListVeh(Model model, @AuthenticationPrincipal Admin Admin){
	
		model.addAttribute("nombre", Admin.getNombre());
		model.addAttribute("Vehiculo", vehService.findAll());
		
		return "Admin/admin-view-list-veh";
	}
	//lista de usuarios
	@GetMapping("/admin-view-list-user")
	public String adminViewListUser(Model model, @AuthenticationPrincipal Admin Admin){
	
		model.addAttribute("nombre", Admin.getNombre());
		model.addAttribute("Usuario", userRegService.findAll());
		
		return "Admin/admin-view-list-user";
	}
	//lista de empleados
	@GetMapping("/admin-view-list-emp")
	public String adminViewListEmp(Model model, @AuthenticationPrincipal Admin Admin){
	
		model.addAttribute("nombre", Admin.getNombre());
		
		return "Admin/admin-view-list-emp";
	}
	//lista de administadores
	@GetMapping("/admin-view-list-admin")
	public String adminViewListAdmin(Model model, @AuthenticationPrincipal Admin Admin){
	
		model.addAttribute("nombre", Admin.getNombre());
		
		return "Admin/admin-view-list-admin";
	}
	
	//Registro y redireccion a lista de vehiculos
	@GetMapping("/registro-veh")
	public String registroVehiculo(Model m) {
		m.addAttribute("registroVeh", new Vehiculo());
		return "/Admin/registro-veh";
	}
	
	@PostMapping("/Admin/registro-veh")
	public String registroVehiculoSubmit(@ModelAttribute("registroVeh") Vehiculo nuevoVeh) {
	
		vehService.save(nuevoVeh);
		return "redirect:/Admin/admin-view-list-veh";
	}
	
	//Registro y redireccion a lista de Usuarios
		@GetMapping("/registro-user")
		public String registroUsuario(Model m) {
			m.addAttribute("registroUser", new UsuarioReg());
			return "/Admin/registro-user";
		}
		
		@PostMapping("/Admin/registro-user")
		public String registroUsuarioSubmit(@ModelAttribute("registroUser") UsuarioReg nuevoUsuarioReg) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			nuevoUsuarioReg.setPassword(encoder.encode(nuevoUsuarioReg.getPassword()));
			userRegService.save(nuevoUsuarioReg);
			return "redirect:/Admin/admin-view-list-user";
		}
		
		//Registro y redireccion a lista de Empleados
		@GetMapping("/registro-emp")
		public String registroEmpleado(Model m) {
			m.addAttribute("registroEmp", new Empleados());
			return "/Admin/registro-emp";
		}
				
		@PostMapping("/Admin/registro-emp")
		public String registroEmpleadoSubmit(@ModelAttribute("registroEmp") Empleados nuevoEmp) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			nuevoEmp.setPassword(encoder.encode(nuevoEmp.getPassword()));
			empService.save(nuevoEmp);
			return "redirect:/Admin/admin-view-list-emp";
		}
		//Registro y redireccion a lista de Administradores
		@GetMapping("/registro-admin")
		public String registroEmpleadoAdmin(Model m) {
			m.addAttribute("registroAdmin", new Admin());
			return "/Admin/registro-admin";
		}
				
		@PostMapping("/Admin/registro-admin")
		public String registroEmpleadoAdminSubmit(@ModelAttribute("registroAdmin") Admin nuevoAdm) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			nuevoAdm.setPassword(encoder.encode(nuevoAdm.getPassword()));	
			adminService.save(nuevoAdm);
			return "redirect:/Admin/admin-view-list-admin";
		}
		
	
}
