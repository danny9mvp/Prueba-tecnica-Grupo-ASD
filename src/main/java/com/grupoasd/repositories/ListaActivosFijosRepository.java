package com.grupoasd.repositories;

import com.grupoasd.entities.ListaActivosFijos;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaActivosFijosRepository extends PagingAndSortingRepository<ListaActivosFijos, Integer> {
}
