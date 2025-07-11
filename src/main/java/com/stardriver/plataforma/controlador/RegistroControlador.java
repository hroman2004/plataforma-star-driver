package com.stardriver.plataforma.controlador;

import com.stardriver.plataforma.entidad.Estudiante;
import com.stardriver.plataforma.entidad.Usuario;
import com.stardriver.plataforma.repositorio.EstudianteRepositorio;
import com.stardriver.plataforma.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class RegistroControlador {
    @Autowired
    private UsuarioRepositorio usuarios;

    @Autowired
    private EstudianteRepositorio estudiantes;

    @GetMapping("/registro")
    private String registro(Model modelo) {
        return "registro.html";
    }

    @PostMapping("/validar-registro")
    private String validarRegistro(@RequestParam Map<String, String> params, Model modelo) {
        String nombreUsuario = params.get("nombre_usuario");

        if (usuarios.existsByUsername(nombreUsuario)) {
            modelo.addAttribute("error", "Nombre de usuario existente.");
            return "registro.html";
        }

        String contrasena = params.get("contrasena");
        String confirmarContrasena = params.get("confirmar_contrasena");

        if (!contrasena.equals(confirmarContrasena)) {
            modelo.addAttribute("error", "Las contraseñas no coinciden.");
            return "registro.html";
        }

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasena(contrasena);
        usuario.setRol("estudiante");

        String nombre = params.get("nombre");
        String apellidos = params.get("apellidos");
        String dni = params.get("dni");
        String correo = params.get("correo");
        String telefono = params.get("telefono");

        Estudiante estudiante = new Estudiante();
        estudiante.setUsuario(usuarios.save(usuario));
        estudiante.setNombre(nombre);
        estudiante.setApellidos(apellidos);
        estudiante.setDni(dni);
        estudiante.setTelefono(telefono);
        estudiante.setCorreo(correo);

        estudiantes.save(estudiante);

        return "login.html";
    }
}
