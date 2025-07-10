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
    private String login() {
        return "login.html";
    }

    @PostMapping("/validar-login")
    private String validarLogin(@RequestParam String nombreUsuario, @RequestParam String contrasena, HttpSession sesion, Model modelo) {
        Optional<Usuario> usuarioBuscado = usuarios.findByUsername(nombreUsuario);

        if (usuarioBuscado.isPresent()) {
            Usuario usuario = usuarioBuscado.get();

            if (!contrasena.equals(usuario.getContrasena())) {
                modelo.addAttribute("error", "Usuario o contraseña incorrectos.");

                return "login.html";
            }

            return switch (usuario.getRol()) {
                case "administrador" -> "index.html";
                case "secretario" -> "index.html";
                case "soporte" -> "index.html";
                case "estudiante" -> "index.html";
                default -> "index.html";
            };
        }

        modelo.addAttribute("error", "Usuario o contraseña incorrectos.");

        return "login.html";
    }
}
