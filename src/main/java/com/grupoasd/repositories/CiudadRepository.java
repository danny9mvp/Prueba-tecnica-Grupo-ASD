package com.grupoasd.repositories;

import com.grupoasd.entities.Ciudad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Integer> {
}
