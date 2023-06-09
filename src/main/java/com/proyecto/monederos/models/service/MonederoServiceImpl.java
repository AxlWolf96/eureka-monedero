package com.proyecto.monederos.models.service;

import com.proyecto.monederos.models.dao.MonederoDAO;
import com.proyecto.monederos.models.entity.Monedero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MonederoServiceImpl implements MonederoService {

    @Autowired
    private MonederoDAO monederoDAO;
    
    @Override
    @Transactional(readOnly=true)
    public List<Monedero> findAll() {
        return (List<Monedero>) monederoDAO.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Monedero findById(Long id) {
        return monederoDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Monedero save(Monedero monedero) {
        return monederoDAO.save(monedero);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        monederoDAO.deleteById(id);
    }
}
