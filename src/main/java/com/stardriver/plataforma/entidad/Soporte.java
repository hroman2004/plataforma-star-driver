package com.stardriver.plataforma.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "soporte")
public class Soporte {
    @Id
    @Column(name = "id_soporte")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "id_usuario", unique = true, nullable = false)
    private Usuario usuario;

    private String nombre;

    private String apellidos;

    @Column(unique = true)
    private String dni;

    private String telefono;

    private String correo;
}
