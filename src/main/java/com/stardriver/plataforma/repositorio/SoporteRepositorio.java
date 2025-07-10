package com.stardriver.plataforma.repositorio;

import com.stardriver.plataforma.entidad.Soporte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoporteRepositorio extends CrudRepository<Soporte, Integer> {
}
