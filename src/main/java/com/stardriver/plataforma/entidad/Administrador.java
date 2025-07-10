package com.stardriver.plataforma.entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "administrador")
public class Administrador {
    @Id
    @Column(name = "id_administrador")
    private int id;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false, unique = true)
    private Usuario usuario;

    private String nombre;

    private String apellidos;

    @Column(unique = true)
    private String dni;

    private String telefono;

    private String correo;
}
