package com.nahuel.persona.repositories;

import com.nahuel.persona.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository <Autor, Long>{

    @Query(
            value = "SELECT * FROM autor WHERE autor.nombre LIKE %:filtro% OR autor.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Autor> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM autor WHERE autor.nombre LIKE %:filtro% OR autor.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM autor",
            nativeQuery = true
    )
    Page<Autor> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
