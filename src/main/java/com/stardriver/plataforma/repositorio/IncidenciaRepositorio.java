package com.stardriver.plataforma.repositorio;

import com.stardriver.plataforma.entidad.Incidencia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenciaRepositorio extends CrudRepository<Incidencia, Integer> {}
