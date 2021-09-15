package com.nahuel.persona.repositories;

import com.nahuel.persona.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long>{

    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<Localidad> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM localidad",
            nativeQuery = true
    )
    Page<Localidad> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
