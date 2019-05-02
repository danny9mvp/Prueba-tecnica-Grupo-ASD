package com.grupoasd.services;

import com.grupoasd.entities.ListaAreas;
import com.grupoasd.repositories.ListaAreasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplListaAreasService implements ListaAreasService{
    @Autowired private ListaAreasRepository listaAreasRepository;

    @Override
    public List<ListaAreas> listarAreas() {
        return (ArrayList<ListaAreas>)listaAreasRepository.findAll();
    }
}
