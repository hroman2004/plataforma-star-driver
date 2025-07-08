package com.stardriver.plataforma.entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "incidencia")
public class Incidencia {
    @Id
    @Column(name = "id_incidencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String detalles;

    private String estado;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;
}
