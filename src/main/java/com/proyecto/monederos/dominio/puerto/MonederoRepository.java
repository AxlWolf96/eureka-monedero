package com.proyecto.monederos.dominio.puerto;

import com.proyecto.monederos.dominio.modelo.Monedero;

import java.util.List;
import java.util.Optional;

public interface MonederoRepository {

    public List<Monedero> findAll();
    public Optional<Monedero> findById(Long id);
    Monedero save(Monedero monedero);
    Monedero update(Long id, Monedero monedero);
    void delete(Long id);
}
