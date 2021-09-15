package com.nahuel.persona.services;

import com.nahuel.persona.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocalidadService extends BaseService<Localidad, Long>{

    List<Localidad> search(String filtro) throws Exception;
    Page<Localidad> search(String filtro, Pageable pageable) throws Exception;

}
