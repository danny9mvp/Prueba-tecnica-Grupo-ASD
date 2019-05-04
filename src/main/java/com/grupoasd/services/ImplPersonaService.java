package com.grupoasd.services;

import com.grupoasd.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * PersonaService hace implementación de los métodos de PersonaService destinados a ser usados en el controlador
 *  REST PersonasApi.
 *
 *  Consultar la interface {@link ListaPersonasService}.
 *
 * @author Daniel Mauricio
 */
@Service
public class ImplPersonaService implements PersonaService{
    @Override
    public ArrayList<Persona> listarPersonas() {
        return null;
    }
}
