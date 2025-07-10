package com.stardriver.plataforma.repositorio;

import com.stardriver.plataforma.entidad.Clase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepositorio extends CrudRepository<Clase, Integer> {}
