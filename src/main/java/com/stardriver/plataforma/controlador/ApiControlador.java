package com.stardriver.plataforma.controlador;

import com.stardriver.plataforma.entidad.Clase;
import com.stardriver.plataforma.entidad.Estudiante;
import com.stardriver.plataforma.entidad.Pago;
import com.stardriver.plataforma.repositorio.ClaseRepositorio;
import com.stardriver.plataforma.repositorio.EstudianteRepositorio;
import com.stardriver.plataforma.repositorio.PagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiControlador {
    @Autowired
    private EstudianteRepositorio estudiantes;

    @Autowired
    private ClaseRepositorio clases;

    @Autowired
    private PagoRepositorio pagos;

    @GetMapping("/api/estudiantes")
    private List<Estudiante> estudiantes() {
        return (List<Estudiante>) estudiantes.findAll();
    }

    @GetMapping("/api/clases")
    private List<Clase> clases() {
        return (List<Clase>) clases.findAll();
    }

    @GetMapping("/api/pagos")
    private List<Pago> pagos() {
        return (List<Pago>) pagos.findAll();
    }
}
