package com.grupoasd.repositories;

import com.grupoasd.entities.Area;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends CrudRepository<Area, Integer> {
}
