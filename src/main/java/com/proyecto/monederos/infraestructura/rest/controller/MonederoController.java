package com.proyecto.monederos.infraestructura.rest.controller;

import com.proyecto.monederos.dominio.modelo.Monedero;
import com.proyecto.monederos.aplicacion.servicio.MonederoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monedero/v0")
public class MonederoController {

    @Autowired
    private MonederoService monederoService;

    @GetMapping("/monedero")
    public ResponseEntity<List<Monedero>> findAll() {
        return new ResponseEntity<>(monederoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/monedero/{monedero-id}")
    public ResponseEntity<Monedero> findById(@PathVariable("monedero-id") Long monederoId) {
        return new ResponseEntity<>(monederoService.findById(monederoId), HttpStatus.OK);
    }
    
    @PostMapping("/monedero")
    public ResponseEntity<Monedero> create(@RequestBody Monedero monedero) {
        return new ResponseEntity<>(monederoService.save(monedero), HttpStatus.CREATED);
    }

    @PutMapping("/monedero/{monedero-id}")
    public ResponseEntity<Monedero> update(@PathVariable("monedero-id") Long monederoId, @RequestBody Monedero monedero) {
        return new ResponseEntity<>(monederoService.update(monederoId, monedero), HttpStatus.OK);
    }
        
    @DeleteMapping("/monedero/{monedero-id}")
    public void delete(@PathVariable("monedero-id") Long monederoId) {
        monederoService.delete(monederoId);
    }
    
}
