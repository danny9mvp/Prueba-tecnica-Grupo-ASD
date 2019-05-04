package com.grupoasd.services;

import com.grupoasd.entities.ActivoFijo;
import com.grupoasd.repositories.ActivoFijoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ImplActivoFijoService hace implementación de los métodos de {@link com.grupoasd.services.ActivoFijoService} destinados a ser usados en el controlador
 *  REST ActivosApi.
 *
 *  Consultar la interface {@link ActivoFijoService}.
 *
 * @author Daniel Mauricio
 */

@Service
public class ImplActivoFijoService implements ActivoFijoService{
    /**
     * Instancia de {@link com.grupoasd.repositories.ActivoFijoRepository} para llamar todos los métodos de esta inteface ya sean heredados o escritos
     * por el desarrollador.
     */
    @Autowired private ActivoFijoRepository activoFijoRepository;

    /**
     * Método diseñado para crear un nuevo Activo Fijo.
     *
     * @param nuevoActivoFijo el Activo Fijo que va a ser guardado.
     * @return el objeto del tipo ActivoFijo guardad.
     */
    @Override
    public ActivoFijo crearActivo(ActivoFijo nuevoActivoFijo) {
        return activoFijoRepository.save(nuevoActivoFijo);
    }

    /**
     * Método diseñado para actualizar un Activo Fijo ya existente.
     *
     * @param activoFijo un Activo Fijo existente que será actualizado.
     * @return el Activo Fijo actualizado.
     */
    @Override
    public ActivoFijo actualizarActivo(ActivoFijo activoFijo) {
        ActivoFijo activoFijoActualizado = activoFijoRepository.save(activoFijo);
        return activoFijoActualizado;
    }

    /**
     * Método diseñado para actualizar solamente el número serial interno de inventario y la fecha de baja de un Activo
     *  Fijo ya existente.
     * @param activoFijo un Activo Fijo existente que será actualizado.
     * @return el Activo Fijo actualizado.
     */
    @Override
    public ActivoFijo actualizarSerialYFechaDeBaja(ActivoFijo activoFijo) {
        return activoFijoRepository.save(activoFijo);
    }

    /**
     * Método diseñado para buscar un Activo Fijo existente dentro de la base de datos.
     * @param id el id del Activo Fijo.
     * @return una representación de Spring Optional del Activo Fijo encontrado.
     */
    @Override
    public Optional<ActivoFijo> buscarPorId(int id) {
        return activoFijoRepository.findById(id);
    }
}
