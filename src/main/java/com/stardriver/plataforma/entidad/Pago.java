package com.stardriver.plataforma.entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @Column(name = "id_pago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @Column(nullable = false)
    private String metodo;

    @Column(nullable = false)
    private String estado;

    private LocalDate fecha;

    @JoinColumn(name = "fecha_cancelado")
    private LocalDate fechaCancelado;

    @OneToOne
    @JoinColumn(name = "id_tramite")
    private Tramite tramite;
}
