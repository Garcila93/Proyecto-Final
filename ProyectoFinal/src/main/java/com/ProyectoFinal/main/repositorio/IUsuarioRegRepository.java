package com.ProyectoFinal.main.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoFinal.main.modelo.UsuarioReg;

public interface IUsuarioRegRepository extends JpaRepository<UsuarioReg, Long>{

	Optional<UsuarioReg> findFirstByEmail(String username);
}
