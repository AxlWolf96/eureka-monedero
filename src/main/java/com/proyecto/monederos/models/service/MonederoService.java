package com.proyecto.monederos.models.service;

import com.proyecto.monederos.models.entity.Monedero;

import java.util.List;

public interface MonederoService {
    public List<Monedero> findAll();
    public Monedero findById(Long id);
    Monedero save(Monedero persona);
    void delete(Long id);
}
