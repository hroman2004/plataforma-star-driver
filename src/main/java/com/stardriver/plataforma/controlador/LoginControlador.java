package com.stardriver.plataforma.controlador;

import com.stardriver.plataforma.entidad.Usuario;
import com.stardriver.plataforma.repositorio.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginControlador {
    @Autowired
    private UsuarioRepositorio usuarios;

    @RequestMapping("/login")
    private String login(HttpSession session) {
        if (session.getAttribute("usuario") != null) {
            String rol = (String) session.getAttribute("rol");

            if ("estudiante".equals(rol)) {
                return "redirect:/estudiante/dashboard";
            }
            if ("administrador".equals(rol)) {
                return "redirect:/administrador/dashboard";
            }
        }

        return "login.html";
    }

    @PostMapping("/validar-login")
    private String validarLogin(@RequestParam String nombreUsuario, @RequestParam String contrasena, HttpSession session, Model model) {
        Optional<Usuario> usuarioBuscado = usuarios.findByUsername(nombreUsuario);

        if (usuarioBuscado.isPresent()) {
            Usuario usuario = usuarioBuscado.get();

            if (!contrasena.equals(usuario.getContrasena())) {
                model.addAttribute("error", "Usuario o contraseña incorrectos.");

                return "login.html";
            }

            session.setAttribute("usuario", nombreUsuario);
            session.setAttribute("rol", usuario.getRol());

            return switch (usuario.getRol()) {
                case "administrador" -> "redirect:/administrador/dashboard";
                case "estudiante" -> "redirect:/estudiante/dashboard";
                default -> "index.html";
            };
        }

        model.addAttribute("error", "Usuario o contraseña incorrectos.");

        return "login.html";
    }

    @RequestMapping("/logout")
    private String logout(HttpSession session) {
        try {
            session.invalidate();
        }
        catch (Exception ignored) {}

        return "redirect:/login";
    }
}
