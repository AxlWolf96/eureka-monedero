package com.proyecto.monederos.models.dao;

import com.proyecto.monederos.models.entity.Monedero;
import org.springframework.data.repository.CrudRepository;

public interface MonederoDAO extends CrudRepository<Monedero, Long> {
}
