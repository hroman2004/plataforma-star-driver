package com.stardriver.plataforma.repositorio;

import com.stardriver.plataforma.entidad.Pago;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepositorio extends CrudRepository<Pago, Integer> {}
