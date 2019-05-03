package com.grupoasd.repositories;

import com.grupoasd.entities.ListaActivosFijos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public interface ListaActivosFijosRepository extends PagingAndSortingRepository<ListaActivosFijos, Integer> {
    List<ListaActivosFijos> findAllByAfijTipo(String afijTipo);
    @Query("select l from ListaActivosFijos l where l.afijFechacompra = :fechaDeCompra")
    List<ListaActivosFijos> findAllByAfijFechacompraStartingWith(
            @Param("fechaDeCompra") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaDeCompra);
    List<ListaActivosFijos> findAllByAfijNumeroserie(String afijNumeroSerie);
}