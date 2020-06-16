package com.ProyectoFinal.main.seguridad;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ProyectoFinal.main.servicios.UsuarioServicio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UsuarioServicio usuarioServicio;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return usuarioServicio.buscarPorEmail(username)
				.orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));
		
	}

}
