package com.grupoasd.api;

import com.grupoasd.entities.Ciudad;
import com.grupoasd.entities.ListaAreas;
import com.grupoasd.pruebatecnica.PruebaTecnicaApplication;
import com.grupoasd.services.ImplListaAreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AreasApi es la clase controladora para recursos REST de Áreas.
 *
 * @author Daniel Mauricio
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequestMapping("/areas")
public class AreasApi {
    @Autowired private ImplListaAreasService implListaAreasService;

    @GetMapping(value = "/todos",produces = "application/json")
    public ResponseEntity<?> todos(){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición GET al recurso 'areas/todos'");
        try {
            List<ListaAreas> todos = implListaAreasService.listarAreas();
            if(!todos.isEmpty()){
                PruebaTecnicaApplication.logger.info("200: "+todos.size()+" areas encontradas.");
                return new ResponseEntity<>(todos, HttpStatus.OK);
            }
            else{
                PruebaTecnicaApplication.logger.warn("404: No se encontraron resultados.");
                return ResponseEntity.notFound().build();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
            PruebaTecnicaApplication.logger.error("500: "+ex);
            return ResponseEntity.status(500).build();
        }
    }
}
