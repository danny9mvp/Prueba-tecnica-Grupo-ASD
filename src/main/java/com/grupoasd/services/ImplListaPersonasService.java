package com.grupoasd.services;

import com.grupoasd.entities.ListaPersonas;
import com.grupoasd.repositories.ListaPersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplListaPersonasService implements ListaPersonasService {
    @Autowired private ListaPersonasRepository listaPersonasRepository;

    @Override
    public List<ListaPersonas> listarPersonas() {
        return (ArrayList<ListaPersonas>)listaPersonasRepository.findAll();
    }
}
