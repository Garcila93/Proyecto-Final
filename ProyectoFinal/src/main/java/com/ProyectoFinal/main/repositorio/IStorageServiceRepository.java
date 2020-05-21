package com.ProyectoFinal.main.repositorio;

import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import io.github.classgraph.Resource;

public interface IStorageServiceRepository<T,U> {

	void init();

    String store(MultipartFile file);

    Stream<T> loadAll();

    T load(U id);

    Resource loadAsResource(U id);
    
    void delete(U id);

    void deleteAll();
}
