package com.grupoasd.repositories;

import com.grupoasd.entities.ListaPersonas;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * ListaPersonasRepository es una interface usada como clase utilitaria para la implementación de consultas en
 * la entidad ListaPersonas.
 *
 * Esta interface hereda los métodos de {@link org.springframework.data.repository.PagingAndSortingRepository}.
 *
 * @author Daniel Mauricio
 */

@Repository
public interface ListaPersonasRepository extends PagingAndSortingRepository<ListaPersonas, Integer> {
}
