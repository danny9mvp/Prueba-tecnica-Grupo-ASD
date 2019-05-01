package com.grupoasd.api;

import com.grupoasd.entities.ActivoFijo;
import com.grupoasd.entities.ListaActivosFijos;
import com.grupoasd.pruebatecnica.PruebaTecnicaApplication;
import com.grupoasd.services.ImplActivoFijoService;
import com.grupoasd.services.ImplListaActivosFijosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/activos")
public class ActivosApi {
    @Autowired private ImplListaActivosFijosService implListaActivosFijosService;
    @Autowired private ImplActivoFijoService implActivoFijoService;

    @GetMapping(value = "/todos")
    public ResponseEntity<?> todos(){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición GET al recurso '/todos'");
        try {
            List<ListaActivosFijos> todos = implListaActivosFijosService.listarActivosFijos();
            if (!todos.isEmpty()) {
                PruebaTecnicaApplication.logger.info("200: "+todos.size()+" Activos Fijos fueron encontrados.");
                return new ResponseEntity<>(todos, HttpStatus.OK);
            } else {
                PruebaTecnicaApplication.logger.warn("404: No se encontraron resultados en el recurso '/todos'.");
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception ex){
            PruebaTecnicaApplication.logger.error("500: "+ex);
            return ResponseEntity.status(500).build();
        }
    }
}
