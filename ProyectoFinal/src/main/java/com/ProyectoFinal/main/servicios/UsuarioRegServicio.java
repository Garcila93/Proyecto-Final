package com.ProyectoFinal.main.servicios;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ProyectoFinal.main.modelo.UsuarioReg;
import com.ProyectoFinal.main.repositorio.IUsuarioRegRepository;
import com.ProyectoFinal.main.servicios.base.BaseService;

@Service
public class UsuarioRegServicio extends BaseService<UsuarioReg, Long, IUsuarioRegRepository>{

	public UsuarioRegServicio(IUsuarioRegRepository repo) {
		super(repo);
	
	}
	public Optional<UsuarioReg> buscarPorEmail(String username) {
		return repositorio.findFirstByEmail(username);
	}
}
