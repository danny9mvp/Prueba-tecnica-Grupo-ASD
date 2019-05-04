package com.grupoasd.repositories;

import com.grupoasd.entities.ActivoFijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * ActivoFijoRepository es una interface usada como clase utilitaria para la implementación de operaciones CRUD en la entidad ActivoFijo.
 *
 * Esta interface hereda los métodos de {@link org.springframework.data.repository.CrudRepository}.
 *
 * @author Daniel Mauricio
 */

@Repository
public interface ActivoFijoRepository extends CrudRepository<ActivoFijo, Integer> {
}
