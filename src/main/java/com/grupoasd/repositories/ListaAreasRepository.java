package com.grupoasd.repositories;

import com.grupoasd.entities.ListaAreas;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * ListaAreasRepository es una interface usada como clase utilitaria para la implementación de consultas en
 * la entidad ListaAreas.
 *
 * Esta interface hereda los métodos de {@link org.springframework.data.repository.PagingAndSortingRepository}.
 *
 * @author Daniel Mauricio
 */

@Repository
public interface ListaAreasRepository extends PagingAndSortingRepository<ListaAreas, Integer> {
}
