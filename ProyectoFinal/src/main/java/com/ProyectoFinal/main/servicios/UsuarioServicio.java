package com.ProyectoFinal.main.servicios;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ProyectoFinal.main.modelo.Usuario;
import com.ProyectoFinal.main.repositorio.IUsuarioRepository;
import com.ProyectoFinal.main.servicios.base.BaseService;

@Service
public class UsuarioServicio extends BaseService<Usuario, Long, IUsuarioRepository>{

	public UsuarioServicio(IUsuarioRepository repo) {
		super(repo);
	}
	
	public Optional<Usuario> buscarPorEmail(String email) {
		return repositorio.findFirstByEmail(email);
	}
}
