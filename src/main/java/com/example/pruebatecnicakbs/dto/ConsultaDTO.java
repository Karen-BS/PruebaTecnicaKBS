package com.example.pruebatecnicakbs.dto;

import lombok.Data;

import java.time.LocalDateTime;

public class ConsultaDTO {
    private String tipoConsulta;
    private LocalDateTime fechaConsulta;

    public ConsultaDTO() {}

    public ConsultaDTO(String tipoConsulta, LocalDateTime fechaConsulta) {
        this.tipoConsulta = tipoConsulta;
        this.fechaConsulta = fechaConsulta;
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
