package com.example.pruebatecnicakbs.controller;

import com.example.pruebatecnicakbs.model.Consulta;
import com.example.pruebatecnicakbs.repository.ConsultaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/bitacora")
public class BitacoraController {
    private final ConsultaRepository consultaRepository;

    public BitacoraController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @GetMapping
    public List<Consulta> obtenerBitacora() {
        return (List<Consulta>) consultaRepository.findAll();
    }
}
