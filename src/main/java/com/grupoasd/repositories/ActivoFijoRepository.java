package com.grupoasd.repositories;

import com.grupoasd.entities.ActivoFijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ActivoFijoRepository extends CrudRepository<ActivoFijo, Integer> {
}
