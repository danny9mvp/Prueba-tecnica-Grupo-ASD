package com.grupoasd.services;

import com.grupoasd.entities.ActivoFijo;
import com.grupoasd.repositories.ActivoFijoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImplActivoFijoService implements ActivoFijoService{
    @Autowired private ActivoFijoRepository activoFijoRepository;

    @Override
    public ActivoFijo crearActivo(ActivoFijo nuevoActivoFijo) {
        return activoFijoRepository.save(nuevoActivoFijo);
    }

    @Override
    public ActivoFijo actualizarActivo(ActivoFijo activoFijo) {
        ActivoFijo activoFijoActualizado = activoFijoRepository.save(activoFijo);
        return activoFijoActualizado;
    }

    @Override
    public ActivoFijo actualizarSerialYFechaDeBaja(ActivoFijo anteriorActivoFijo) {
        return null;
    }

    @Override
    public Optional<ActivoFijo> buscarPorId(int id) {
        return activoFijoRepository.findById(id);
    }
}
