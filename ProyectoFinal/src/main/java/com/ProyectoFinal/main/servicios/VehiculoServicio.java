package com.ProyectoFinal.main.servicios;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ProyectoFinal.main.modelo.Vehiculo;
import com.ProyectoFinal.main.repositorio.IVehiculoRepository;
import com.ProyectoFinal.main.servicios.base.BaseService;

@Service
public class VehiculoServicio extends BaseService<Vehiculo, Long, IVehiculoRepository>{

	private final DBStorageService dbStorageService;

	public VehiculoServicio(IVehiculoRepository repo, 
			DBStorageService dbStoreService
			) {
		super(repo);
		this.dbStorageService = dbStoreService;
	}
	
	// gaurdar entidad
	public Vehiculo save(Vehiculo c, MultipartFile imagen) {
		// Pasos a seguir
		
		// 1) Transformar la imagen en un String
		String pathImagen = dbStorageService.store(imagen);
		// 2) Asignar esta cadena de caracteres con nuestra entidad
		c.setImagen(pathImagen);
		// 3) Almacenarla
		return this.save(c);
	}

	//Eliminar entidad
	@Override
	public void delete(Vehiculo veh) {
		String idImagen = veh.getImagen();
		dbStorageService.delete(Long.valueOf(idImagen));
		super.delete(veh);
	}

	// Eliminar entidad por Id
	 
	@Override
	public void deleteById(Long id) {
		Vehiculo veh = findById(id);
		if (veh != null)
			delete(veh);
	}
}
