package com.proyecto.monederos.aplicacion.servicio;

import com.proyecto.monederos.dominio.modelo.Monedero;

import java.util.List;

public interface MonederoService {
    public List<Monedero> findAll();
    public Monedero findById(Long id);
    Monedero save(Monedero monedero);
    Monedero update(Long id, Monedero monedero);
    void delete(Long id);
}
