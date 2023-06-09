package com.proyecto.monederos.controllers;

import com.proyecto.monederos.feign.PersonaFeign;
import com.proyecto.monederos.models.entity.Monedero;
import com.proyecto.monederos.models.service.MonederoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monedero/v0")
public class MonederoController {

    @Autowired
    private MonederoService monederoService;

    @GetMapping("/monedero")
    public List<Monedero> findAll() {
        return monederoService.findAll();
    }

    @GetMapping("/monedero/{monedero-id}")
    public Monedero findById(@PathVariable("monedero-id") Long monederoId) {
        return monederoService.findById(monederoId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/monedero")
    public Monedero create(@RequestBody Monedero monedero) {
        
        Monedero monederoDB = null;
        
        if (PersonaFeign.findById(monedero.getIdPersona())) {
            monederoDB = monederoService.save(monedero);
        }
        
        return monederoDB;
    }

    @PutMapping("/monedero/{monedero-id}")
    public Monedero update(@PathVariable("monedero-id") Long monederoId, @RequestBody Monedero monedero) {

        Monedero monederoBD = monederoService.findById(monederoId);
        if (monederoBD != null) {
            monederoBD.setIdPersona(monedero.getIdPersona());
            monederoBD.setSaldo(monedero.getSaldo());
        }
        return monederoService.save(monederoBD);
    }
    
    @DeleteMapping("/monedero/{monedero-id}")
    public void delete(@PathVariable("monedero-id") Long monederoId) {
        monederoService.delete(monederoId);
    }

}
