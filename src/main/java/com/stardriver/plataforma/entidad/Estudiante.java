package com.stardriver.plataforma.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @Column(name = "id_estudiante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String dni;

    private String telefono;

    @Column(unique = true)
    private String correo;
}
