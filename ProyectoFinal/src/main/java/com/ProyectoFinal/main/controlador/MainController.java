package com.ProyectoFinal.main.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ProyectoFinal.main.modelo.UsuarioReg;
import com.ProyectoFinal.main.modelo.Vehiculo;
import com.ProyectoFinal.main.servicios.UsuarioRegServicio;
import com.ProyectoFinal.main.servicios.VehiculoServicio;

@Controller
public class MainController {
	
	@Autowired
	private VehiculoServicio VehServicio;
	@Autowired
	private UsuarioRegServicio UserRegServicio;
	
	private final String BASE_IMAGE_PATH;
	
	//inicio
	@GetMapping("/")
	public String inicio() {
				
		return "Public/inicio";
	}
	
	/*
	 //TODO realizar plantilla de login sin modal para redireccionar
	
	@GetMapping("/login")
	public String login() {
				
		return "Public/login-page";
	}
	
	@PostMapping("User/user-home")
	public String userHome(Model m) {
		
		return "User/user-home";
	}
	 */
	
	//Registro y redireccion a inicio
	@GetMapping("/registro")
	public String nuevoUsuario(Model m) {
		m.addAttribute("registro", new UsuarioReg());
		return "Public/registro";
	}
	
	@PostMapping("Public/registro")
	public String nuevoUsuarioSubmit(@ModelAttribute("registro") UsuarioReg nuevoUsuarioReg) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		nuevoUsuarioReg.setPassword(encoder.encode(nuevoUsuarioReg.getPassword()));
		UserRegServicio.save(nuevoUsuarioReg);
		return "redirect:User/veh-stock-user";
	}
	
	
	//Stocks de vehiculos
	@GetMapping("/veh-stock")
	public String vehStock(Model model) {
				model.addAttribute("Stock", VehServicio.findAll());
		return "Public/veh-stock";
	}
	
	
	
	
	
	
	
	
	
	//controladores de subida de imagen
	public MainController(VehiculoServicio VehServicio, @Value("${image.base-path:/files}") String path) {
		this.VehServicio = VehServicio;
		this.BASE_IMAGE_PATH = path;
	}
	
	@ModelAttribute("base_image_path")
	public String baseImagePath() {
		return this.BASE_IMAGE_PATH;
	}
	
	//REVISAR
	@GetMapping("/add-car")
	public String showForm(Model model) {
		model.addAttribute("cosa", new Vehiculo());
		return "Form-add-coche";
	}
	
	
	@PostMapping("/submit")
	public String processForm(@ModelAttribute Vehiculo Vehiculo, MultipartFile file) {
		
		if (!file.isEmpty())
			VehServicio.save(Vehiculo, file);
		else 
			VehServicio.save(Vehiculo);
		
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("lista", VehServicio.findAll());
		return "list";
	}


}
