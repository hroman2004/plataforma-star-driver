package com.stardriver.plataforma.entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "clase")
public class Clase {
    @Id
    @Column(name = "id_clase")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String horario;

    @OneToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesor profesor;

    @OneToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    private LocalDate fecha;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_final", nullable = false)
    private LocalTime horaFinal;

    @Column(name = "tipo_vehiculo", nullable = false)
    private String tipoVehiculo;

    @Column(name = "asistencia_estudiante")
    private boolean asistenciaEstudiante;

    @Column(name = "asistencia_profesor")
    private boolean asistenciaProfesor;
}
