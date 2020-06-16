package com.ProyectoFinal.main.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProyectoFinal.main.modelo.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long>{
	
	Optional<Admin> findFirstByEmail(String username);

}
