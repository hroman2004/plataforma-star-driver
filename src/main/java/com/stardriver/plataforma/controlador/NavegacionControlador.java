package com.stardriver.plataforma.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavegacionControlador {

    @RequestMapping("/sugerencias")
    private String sugerencias() {
        return "sugerencias.html";
    }

    @RequestMapping("/contactenos")
    private String contactenos() {
        return "contactenos.html";
    }

    @RequestMapping("/libro-reclamaciones")
    private String libroReclamaciones() {
        return "libro-reclamaciones.html";
    }

    @RequestMapping("/preguntas-frecuentes")
    private String preguntasFrecuentes() {
        return "preguntas-frecuentes.html";
    }
}
