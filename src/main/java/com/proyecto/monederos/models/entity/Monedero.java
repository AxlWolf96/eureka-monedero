package com.proyecto.monederos.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="monederos")
public class Monedero implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_persona")
    private Long idPersona;
    private BigDecimal saldo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Monedero{");
        sb.append("id=").append(id);
        sb.append(", idPersona=").append(idPersona);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }
}
