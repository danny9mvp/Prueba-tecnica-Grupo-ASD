package com.grupoasd.repositories;

import com.grupoasd.entities.Ciudad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CiudadRepository es una interface usada como clase utilitaria para la implementación de operaciones CRUD en la entidad Ciudad.
 *
 * Esta interface hereda los métodos de {@link org.springframework.data.repository.CrudRepository}.
 *
 * @author Daniel Mauricio
 */

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Integer> {
}
