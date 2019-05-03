package com.grupoasd.services;

import com.grupoasd.entities.ListaActivosFijos;
import com.grupoasd.repositories.ListaActivosFijosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ImplListaActivosFijosService implements ListaActivosFijosService{
    @Autowired private ListaActivosFijosRepository listaActivosFijosRepository;

    @Override
    public List<ListaActivosFijos> listarActivosFijos() {
        return (ArrayList<ListaActivosFijos>) listaActivosFijosRepository.findAll(new Sort(Sort.Direction.ASC, "afijId"));
    }

    @Override
    public List<ListaActivosFijos> listarActivosFijosPorTipo(String tipo) {
        return listaActivosFijosRepository.findAllByAfijTipo(tipo);
    }

    @Override
    public List<ListaActivosFijos> listarActivosFijosPorFechaDeCompra(Date fechaDeCompra) {
        return listaActivosFijosRepository.findAllByAfijFechacompra(fechaDeCompra);
    }

    @Override
    public List<ListaActivosFijos> buscarActivoFijoPorNumeroDeSerie(String numeroDeSerie) {
        return (List<ListaActivosFijos>) listaActivosFijosRepository.findAllByAfijNumeroserie(numeroDeSerie);
    }

    @Override
    public Optional<ListaActivosFijos> buscarPorId(int id) {
        return listaActivosFijosRepository.findById(id);
    }

    @Override
    public List<String> listarSeriales(List<ListaActivosFijos> listaActivosFijos) {
        List<String> listaSeriales = new ArrayList<>();
        listaActivosFijos.forEach((activoFijo)->{
            if(activoFijo.getAfijNumeroserie() != null){
                listaSeriales.add(activoFijo.getAfijNumeroserie());
            }
        });
        return listaSeriales;
    }

    @Override
    public List<Integer> listarIds(List<ListaActivosFijos> listaActivosFijos) {
        List<Integer> listaIds = new ArrayList<>();
        listaActivosFijos.forEach((activoFijo)->{ listaIds.add(activoFijo.getAfijId());});
        return listaIds;
    }
}
