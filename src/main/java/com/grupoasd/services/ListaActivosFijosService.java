package com.grupoasd.services;

import com.grupoasd.entities.ListaActivosFijos;

import java.util.Date;
import java.util.List;

public interface ListaActivosFijosService {
    List<ListaActivosFijos> listarActivosFijos();
    List<ListaActivosFijos> listarActivosFijosPorTipo(String tipo);
    List<ListaActivosFijos> listarActivosFijosPorFechaDeCompra(Date fechaDeCompra);
    List<ListaActivosFijos> listarActivosFijosPorNumeroDeSerie(String numeroDeSerie);
}
