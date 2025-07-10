package com.stardriver.plataforma.repositorio;

import com.stardriver.plataforma.entidad.Estudiante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends CrudRepository<Estudiante, Integer> {
}
