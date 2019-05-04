package com.grupoasd.services;

import com.grupoasd.entities.Area;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
/**
 * ImplAreaService hace implementación de los métodos de {@link com.grupoasd.services.AreaService} destinados a ser usados en el controlador
 *  REST AreasApi.
 *
 *  Consultar la interface {@link AreaService}.
 *
 * @author Daniel Mauricio
 */
@Service
public class ImplAreaService implements AreaService{
    @Override
    public ArrayList<Area> listarAreas() {
        return null;
    }
}
