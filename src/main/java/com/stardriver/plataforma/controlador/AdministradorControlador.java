package com.stardriver.plataforma.controlador;

import com.stardriver.plataforma.entidad.Estudiante;
import com.stardriver.plataforma.repositorio.ClaseRepositorio;
import com.stardriver.plataforma.repositorio.EstudianteRepositorio;
import com.stardriver.plataforma.repositorio.PagoRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdministradorControlador {

    @RequestMapping("/administrador/dashboard")
    private String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        return "administrador/dashboard.html";
    }
}
