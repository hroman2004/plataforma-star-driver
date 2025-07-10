package com.stardriver.plataforma.entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tramite")
public class Tramite {
    @Id
    @Column(name = "id_tramite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_tramite", nullable = false)
    private String nombre;
    private String tipo;

    @Column(name = "fecha_realizo")
    private LocalDate fechaRealizo;

    @Column(name = "fecha_culminado")
    private LocalDate fechaCulminado;

    private String estado;
}
