package com.stardriver.plataforma.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "rol")
    private String rol;

    @Column(name = "contrasena")
    private String contrasena;
}
