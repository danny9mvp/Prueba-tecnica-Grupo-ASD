package com.grupoasd.repositories;

import com.grupoasd.entities.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * AreaRepository es una interface usada como clase utilitaria para la implementación de operaciones CRUD en la entidad Area.
 *
 * Esta interface hereda los métodos de {@link org.springframework.data.repository.CrudRepository}.
 *
 * @author Daniel Mauricio
 */

@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {
}
