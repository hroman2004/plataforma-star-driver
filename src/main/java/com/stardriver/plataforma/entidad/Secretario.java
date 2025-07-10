package com.stardriver.plataforma.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "secretario")
public class Secretario {
    @Id
    @Column(name = "id_secretario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private String nombre;

    private String apellidos;

    @Column(unique = true)
    private String dni;

    private String telefono;

    private String correo;
}
