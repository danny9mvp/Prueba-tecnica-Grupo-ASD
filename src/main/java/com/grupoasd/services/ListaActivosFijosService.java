package com.grupoasd.services;

import com.grupoasd.entities.ListaActivosFijos;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ListaActivosFijosService {
    List<ListaActivosFijos> listarActivosFijos();
    List<ListaActivosFijos> listarActivosFijosPorTipo(String tipo);
    List<ListaActivosFijos> listarActivosFijosPorFechaDeCompra(Date fechaDeCompra);
    List<ListaActivosFijos> buscarActivoFijoPorNumeroDeSerie(String numeroDeSerie);
    Optional<ListaActivosFijos> buscarPorId(int id);
    List<String> listarSeriales(List<ListaActivosFijos> listaActivosFijos);
}
