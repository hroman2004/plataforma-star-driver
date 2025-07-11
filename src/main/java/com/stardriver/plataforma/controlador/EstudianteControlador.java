package com.stardriver.plataforma.controlador;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstudianteControlador {

    @RequestMapping("/estudiante/dashboard")
    private String dashboard(HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "login.html";
        }

        return "estudiante/dashboard.html";
    }
}
