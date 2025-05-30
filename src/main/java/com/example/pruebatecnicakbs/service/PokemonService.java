package com.example.pruebatecnicakbs.service;

import com.example.pruebatecnicakbs.model.Consulta;
import com.example.pruebatecnicakbs.repository.ConsultaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class PokemonService {
    private final RestTemplate restTemplate;
    private final ConsultaRepository consultaRepository;
    private final String API_BASE = "https://pokeapi.co/api/v2/pokemon";

    public PokemonService(RestTemplate restTemplate, ConsultaRepository consultaRepository) {
        this.restTemplate = restTemplate;
        this.consultaRepository = consultaRepository;
    }

    public String obtenerDetallePokemon(String nombre) {
        guardarConsulta("detalle");
        String url = API_BASE + "/" + nombre;
        return restTemplate.getForObject(url, String.class);
    }

    void guardarConsulta(String tipo) {
        consultaRepository.save(new Consulta(tipo, LocalDateTime.now()));
    }

    public String obtenerListadoPokemon(int limit, int offset) {
        guardarConsulta("listado");
        String url = "https://pokeapi.co/api/v2/pokemon?limit=" + limit + "&offset=" + offset;
        return restTemplate.getForObject(url, String.class);
    }
}
