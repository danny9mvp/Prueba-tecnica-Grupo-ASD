package com.grupoasd.services;

import com.grupoasd.entities.ActivoFijo;

import java.util.ArrayList;
import java.util.List;

public interface ActivoFijoService {
    ActivoFijo crearActivo(ActivoFijo nuevoActivoFijo);
    ActivoFijo actualizarActivo(ActivoFijo anteriorActivoFijo);
    ActivoFijo actualizarSerialYFechaDeBaja(ActivoFijo anteriorActivoFijo);
}
