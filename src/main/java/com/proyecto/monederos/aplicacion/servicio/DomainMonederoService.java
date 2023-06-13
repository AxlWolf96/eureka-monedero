package com.proyecto.monederos.aplicacion.servicio;

import com.proyecto.monederos.dominio.modelo.Monedero;
import com.proyecto.monederos.dominio.puerto.MonederoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainMonederoService implements MonederoService {

    @Autowired
    private MonederoRepository monederoRepository;

    @Override
    public List<Monedero> findAll() {
        return monederoRepository.findAll();
    }

    @Override
    public Monedero findById(Long id) {
        return monederoRepository.findById(id).get();
    }

    @Override
    public Monedero save(Monedero monedero) {
        return monederoRepository.save(monedero);
    }

    @Override
    public Monedero update(Long id, Monedero monedero) {
        return monederoRepository.update(id, monedero);
    }

    @Override
    public void delete(Long id) {
        monederoRepository.delete(id);
    }
}
