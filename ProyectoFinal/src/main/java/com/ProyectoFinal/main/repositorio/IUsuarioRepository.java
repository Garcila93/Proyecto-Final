package com.ProyectoFinal.main.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoFinal.main.modelo.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findFirstByEmail(String username);
}
