package com.ProyectoFinal.main.seguridad;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.ProyectoFinal.main.servicios.EmpleadoServicio;
import com.ProyectoFinal.main.servicios.UsuarioRegServicio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UsuarioRegServicio usuarioRegServicio;
//  private final EmpleadoServicio empleadoServicio;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return usuarioRegServicio.buscarPorEmail(username)
				.orElseThrow(()-> new UsernameNotFoundException("Usuario no encontrado"));
	
	}
	
	/*public UserDetails loadUserByUsernameEmp(String username) throws UsernameNotFoundException {
		
		return empleadoServicio.buscarPorEmail(username)
				.orElseThrow(()-> new UsernameNotFoundException("Empleado no encontrado"));
	
	}
	*/


}
