package com.proyecto.monederos.infraestructura.adaptador;

import com.proyecto.monederos.infraestructura.entidad.MonederoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonederoJpaRepositoryMySQL extends JpaRepository<MonederoEntity, Long> {
}
