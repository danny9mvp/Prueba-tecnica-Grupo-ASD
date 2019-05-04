package com.grupoasd.services;

import com.grupoasd.entities.Ciudad;
import com.grupoasd.repositories.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
/**
 * ImplCiudadService hace implementación de los métodos de {@link com.grupoasd.services.CiudadService} destinados a ser usados en el controlador
 *  REST CiudadApi.
 *
 *  Consultar la interface {@link CiudadService}.
 *
 * @author Daniel Mauricio
 */
@Service
public class ImplCiudadService implements CiudadService{
    /**
     * Instancia de {@link com.grupoasd.repositories.CiudadRepository} para llamar todos los métodos de esta inteface ya sean heredados o escritos
     * por el desarrollador.
     */
    @Autowired private CiudadRepository ciudadRepository;

    /**
     * Método diseñado para consultar todas las ciudades.
     * @return una lista con todas las ciudades encontradas.
     */
    @Override
    public ArrayList<Ciudad> listarCiudades() { return (ArrayList<Ciudad>)ciudadRepository.findAll(); }
}
