package com.example.pruebatecnicakbs.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoConsulta; // Ej: "pokemon", "detalle"

    private LocalDateTime fechaConsulta;

    public Consulta() {
    }

    public Consulta(String tipoConsulta, LocalDateTime fechaConsulta) {
        this.tipoConsulta = tipoConsulta;
        this.fechaConsulta = fechaConsulta;
    }
}
