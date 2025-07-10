package com.stardriver.plataforma.repositorio;

import com.stardriver.plataforma.entidad.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM usuario WHERE nombre_usuario = :nombre_usuario", nativeQuery = true)
    Optional<Usuario> findByUsername(@Param("nombre_usuario") String username);
}
