package com.example.pruebatecnicakbs.repository;

import com.example.pruebatecnicakbs.model.Consulta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {
    @Override
    List<Consulta> findAll();
}
