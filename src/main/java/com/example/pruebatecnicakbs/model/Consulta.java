package com.example.pruebatecnicakbs.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public LocalDateTime getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDateTime fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }
}
