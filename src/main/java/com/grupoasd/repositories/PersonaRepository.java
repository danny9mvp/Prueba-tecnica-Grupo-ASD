package com.grupoasd.repositories;

import com.grupoasd.entities.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * PersonaRepository es una interface usada como clase utilitaria para la implementación de operaciones CRUD en la entidad
 * Persona.
 *
 * Esta interface hereda los métodos de {@link org.springframework.data.repository.CrudRepository}.
 *
 * @author Daniel Mauricio
 */

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
}
