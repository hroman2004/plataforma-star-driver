package com.stardriver.plataforma.controlador;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EstudianteControlador {

    @RequestMapping("/estudiante/dashboard")
    private String dashboard(HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        return "estudiante/dashboard.html";
    }

    @RequestMapping("/estudiante/pagos")
    private String pagos(HttpSession session, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        // falta agregar el metodo para los pagos pendientes
        model.addAttribute("pagosPendientes", List.of());

        return "estudiante/pagos.html";
    }

    @RequestMapping("estudiante/programacion-clase")
    private String programacionClase(HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        return "estudiante/programacion-clase.html";
    }

    @RequestMapping("estudiante/reportes")
    private String reportes(HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        return "estudiante/reportes.html";
    }
}
