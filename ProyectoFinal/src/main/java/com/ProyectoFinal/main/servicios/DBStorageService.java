package com.ProyectoFinal.main.servicios;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ProyectoFinal.main.modelo.Vehiculo;
import com.ProyectoFinal.main.repositorio.IStorageServiceRepository;

import io.github.classgraph.Resource;

@Service
public class DBStorageService implements IStorageServiceRepository<Vehiculo,Long>{

	@Override
	public void init() {
		
		
	}

	@Override
	public String store(MultipartFile file) {
	
		return null;
	}

	@Override
	public Stream<Vehiculo> loadAll() {
	
		return null;
	}

	@Override
	public Vehiculo load(Long id) {
		
		return null;
	}

	@Override
	public Resource loadAsResource(Long id) {
		
		return null;
	}

	@Override
	public void delete(Long id) {
			
	}

	@Override
	public void deleteAll() {
		
		
	}

}
