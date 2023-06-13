package com.proyecto.monederos.infraestructura.rest.mapper;

import com.proyecto.monederos.dominio.modelo.Monedero;
import com.proyecto.monederos.infraestructura.entidad.MonederoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonederoMapper {
    
    Monedero toMonedero(MonederoEntity monederoEntity);
    List<Monedero> toMonederos(List<MonederoEntity> monederoEntityList);
    MonederoEntity toMonederoEntity(Monedero monedero);
    
}
