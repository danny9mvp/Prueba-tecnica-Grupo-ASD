package com.grupoasd.services;

import com.grupoasd.entities.ListaAreas;
import com.grupoasd.repositories.ListaAreasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ImplListaAreasService hace implementación de los métodos de {@link com.grupoasd.services.ListaAreasService} destinados a ser usados en el controlador
 *  REST AreasApi.
 *
 *  Consultar la interface {@link ListaAreasService}.
 *
 * @author Daniel Mauricio
 */

@Service
public class ImplListaAreasService implements ListaAreasService{
    /**
     * Instancia de {@link com.grupoasd.repositories.ListaAreasRepository} para llamar todos los métodos de esta inteface ya sean heredados o escritos
     * por el desarrollador.
     */
    @Autowired private ListaAreasRepository listaAreasRepository;

    /**
     * Método diseñado para listar todas las áreas existentes.
     *
     * @return una lista con todas las áreas existentes.
     */
    @Override
    public List<ListaAreas> listarAreas() {
        return (List<ListaAreas>)listaAreasRepository.findAll();
    }
}
