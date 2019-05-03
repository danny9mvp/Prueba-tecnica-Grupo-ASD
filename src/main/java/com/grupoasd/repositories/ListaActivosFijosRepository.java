package com.grupoasd.repositories;

import com.grupoasd.entities.ListaActivosFijos;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public interface ListaActivosFijosRepository extends PagingAndSortingRepository<ListaActivosFijos, Integer> {
    List<ListaActivosFijos> findAllByAfijTipo(String afijTipo);
    List<ListaActivosFijos> findAllByAfijFechacompraStartingWith(@Temporal(TemporalType.DATE) Date afijFechaCompra);
    List<ListaActivosFijos> findAllByAfijNumeroserie(String afijNumeroSerie);
}
