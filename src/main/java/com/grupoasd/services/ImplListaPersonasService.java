package com.grupoasd.services;

import com.grupoasd.entities.ListaPersonas;
import com.grupoasd.repositories.ListaPersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * ImplListaPersonasService hace implementación de los métodos de {@link com.grupoasd.services.ListaPersonasService} destinados a ser usados en el controlador
 *  REST PersonasApi.
 *
 *  Consultar la interface {@link ListaPersonasService}.
 *
 * @author Daniel Mauricio
 */
@Service
public class ImplListaPersonasService implements ListaPersonasService {
    /**
     * Instancia de {@link com.grupoasd.repositories.ListaPersonasRepository} para llamar todos los métodos de esta inteface ya sean heredados o escritos
     * por el desarrollador.
     */
    @Autowired private ListaPersonasRepository listaPersonasRepository;

    /**
     * Método diseñado para listar todas las personas existentes.
     *
     * @return lista con todas las personas existentes.
     */
    @Override
    public List<ListaPersonas> listarPersonas() {
        return (List<ListaPersonas>)listaPersonasRepository.findAll();
    }
}
