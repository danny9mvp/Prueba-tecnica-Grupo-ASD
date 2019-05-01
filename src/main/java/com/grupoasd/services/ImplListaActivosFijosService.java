package com.grupoasd.services;

import com.grupoasd.entities.ListaActivosFijos;
import com.grupoasd.repositories.ListaActivosFijosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImplListaActivosFijosService implements ListaActivosFijosService{
    @Autowired private ListaActivosFijosRepository listaActivosFijosRepository;

    @Override
    public List<ListaActivosFijos> listarActivosFijos() {
        return (ArrayList<ListaActivosFijos>) listaActivosFijosRepository.findAll();
    }

    @Override
    public List<ListaActivosFijos> listarActivosFijosPorTipo(String tipo) {
        return null;
    }

    @Override
    public List<ListaActivosFijos> listarActivosFijosPorFechaDeCompra(Date fechaDeCompra) {
        return null;
    }

    @Override
    public List<ListaActivosFijos> listarActivosFijosPorNumeroDeSerie(String numeroDeSerie) {
        return null;
    }
}