package com.grupoasd.repositories;

import com.grupoasd.entities.ListaPersonas;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaPersonasRepository extends PagingAndSortingRepository<ListaPersonas, Integer> {
}
