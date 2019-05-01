package com.grupoasd.services;

import com.grupoasd.entities.Ciudad;
import com.grupoasd.repositories.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ImplCiudadService implements CiudadService{
    @Autowired private CiudadRepository ciudadRepository;
    @Override
    public ArrayList<Ciudad> listarCiudades() { return (ArrayList<Ciudad>)ciudadRepository.findAll(); }
}
