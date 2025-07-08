package com.stardriver.plataforma.repositorio;

import com.stardriver.plataforma.entidad.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {}
