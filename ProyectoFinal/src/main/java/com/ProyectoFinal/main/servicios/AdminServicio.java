package com.ProyectoFinal.main.servicios;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ProyectoFinal.main.modelo.Admin;
import com.ProyectoFinal.main.repositorio.IAdminRepository;
import com.ProyectoFinal.main.servicios.base.BaseService;

@Service
public class AdminServicio extends BaseService<Admin, Long, IAdminRepository> {
	
	public AdminServicio(IAdminRepository repo) {
		super(repo);
		
	}
	
	public Optional<Admin> buscarPorEmail(String username) {
		return repositorio.findFirstByEmail(username);
	}
}
