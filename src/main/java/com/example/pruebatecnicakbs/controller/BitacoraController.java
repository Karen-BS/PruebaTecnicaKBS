package com.example.pruebatecnicakbs.controller;

import com.example.pruebatecnicakbs.dto.ConsultaDTO;
import com.example.pruebatecnicakbs.model.Consulta;
import com.example.pruebatecnicakbs.repository.ConsultaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bitacora")
public class BitacoraController {
    private final ConsultaRepository consultaRepository;

    public BitacoraController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @GetMapping
    public List<ConsultaDTO> obtenerBitacora() {
        return consultaRepository.findAll().stream()
                .map(c -> new ConsultaDTO(c.getTipoConsulta(), c.getFechaConsulta()))
                .collect(Collectors.toList());
    }
}
