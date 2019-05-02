package com.grupoasd.repositories;

import com.grupoasd.entities.ListaAreas;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaAreasRepository extends PagingAndSortingRepository<ListaAreas, Integer> {
}
