package com.example.pruebatecnicakbs.controller;

import com.example.pruebatecnicakbs.service.PokemonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public String obtenerPokemones(@RequestParam(defaultValue = "10") int limit,
                                   @RequestParam(defaultValue = "0") int offset) {
        return pokemonService.obtenerListadoPokemon(limit, offset);
    }

    @GetMapping("/{nombre}")
    public String obtenerDetalle(@PathVariable String nombre) {
        return pokemonService.obtenerDetallePokemon(nombre);
    }
}
