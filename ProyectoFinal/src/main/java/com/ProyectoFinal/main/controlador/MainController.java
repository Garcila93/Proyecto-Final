package com.ProyectoFinal.main.controlador;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ProyectoFinal.main.modelo.Vehiculo;
import com.ProyectoFinal.main.servicios.VehiculoServicio;

@Controller
public class MainController {
		
	private final VehiculoServicio VehServicio;
	private final String BASE_IMAGE_PATH;
	
	@GetMapping("/home")
	public String index() {
				
		return "inicio";
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
	
	
	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("cosa", new Vehiculo());
		return "inicio";
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
