package com.proyecto.monederos.infraestructura.adaptador;

import com.proyecto.monederos.dominio.modelo.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "servicio-personas")
public interface PersonaFeignClientRest {
    
    @GetMapping("/persona/v0/persona")
    ResponseEntity<List<Persona>> findAll();
    
    @GetMapping("/persona/v0/persona/{persona-id}")
    ResponseEntity<Persona> findById(@PathVariable("persona-id") Long personaId);
}
