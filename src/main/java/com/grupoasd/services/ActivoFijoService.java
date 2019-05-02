package com.grupoasd.services;

import com.grupoasd.entities.ActivoFijo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ActivoFijoService {
    ActivoFijo crearActivo(ActivoFijo nuevoActivoFijo);
    ActivoFijo actualizarActivo(ActivoFijo activoFijo);
    ActivoFijo actualizarSerialYFechaDeBaja(ActivoFijo anteriorActivoFijo);
    Optional<ActivoFijo> buscarPorId(int id);
}
