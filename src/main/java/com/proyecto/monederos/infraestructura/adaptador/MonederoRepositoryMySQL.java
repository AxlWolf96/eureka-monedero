package com.proyecto.monederos.infraestructura.adaptador;

import com.proyecto.monederos.dominio.modelo.Monedero;
import com.proyecto.monederos.dominio.puerto.MonederoRepository;
import com.proyecto.monederos.infraestructura.entidad.MonederoEntity;
import com.proyecto.monederos.infraestructura.excepciones.ResourceNotFoundException;
import com.proyecto.monederos.infraestructura.rest.mapper.MonederoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class MonederoRepositoryMySQL implements MonederoRepository {
    
    @Autowired
    private MonederoJpaRepositoryMySQL monederoJpaRepositoryMySQL;
    
    @Autowired
    private MonederoMapper monederoMapper;
    
    @Override
    @Transactional(readOnly = true)
    public List<Monedero> findAll() {
        return monederoMapper.toMonederos(monederoJpaRepositoryMySQL.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Monedero> findById(Long id) {
        MonederoEntity monedero = monederoJpaRepositoryMySQL.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso no encontrado")
        );
        
        return Optional.of(monederoMapper.toMonedero(monedero));
    }

    @Override
    @Transactional
    public Monedero save(Monedero monedero) {
        MonederoEntity monederoEntity = monederoMapper.toMonederoEntity(monedero);
        return monederoMapper.toMonedero(monederoJpaRepositoryMySQL.save(monederoEntity));
    }

    @Override
    @Transactional
    public Monedero update(Long id, Monedero monedero) {

        MonederoEntity monederoEntityDB = monederoJpaRepositoryMySQL.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso no encontrado")
        );
        
        MonederoEntity monederoEntityNew = monederoMapper.toMonederoEntity(monedero);

        monederoEntityDB.setIdPersona(monederoEntityNew.getIdPersona());
        monederoEntityDB.setSaldo(monederoEntityNew.getSaldo());
        
        return monederoMapper.toMonedero(monederoJpaRepositoryMySQL.save(monederoEntityDB));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        MonederoEntity monederoEntity = monederoJpaRepositoryMySQL.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso no encontrado")
        );
        
        monederoJpaRepositoryMySQL.deleteById(monederoEntity.getId());
    }
}
