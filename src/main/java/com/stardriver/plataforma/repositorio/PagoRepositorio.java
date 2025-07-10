package com.stardriver.plataforma.repositorio;

import com.stardriver.plataforma.entidad.Pago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepositorio extends CrudRepository<Pago, Integer> {}
