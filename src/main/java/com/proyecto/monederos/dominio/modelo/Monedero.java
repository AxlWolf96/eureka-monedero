package com.proyecto.monederos.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monedero {
    
    private Long id;
    private Long idPersona;
    private BigDecimal saldo;
    
}
