package com.grupoasd.api;

import com.grupoasd.entities.ListaPersonas;
import com.grupoasd.pruebatecnica.PruebaTecnicaApplication;
import com.grupoasd.services.ImplListaPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
@RequestMapping("/personas")
public class PersonasApi {
    @Autowired private ImplListaPersonasService implListaPersonasService;

    @GetMapping(value = "/todos",produces = "application/json")
    public ResponseEntity<?> todos(){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición GET al recurso 'personas/todos'");
        try {
            List<ListaPersonas> todos = implListaPersonasService.listarPersonas();
            if(!todos.isEmpty()){
                PruebaTecnicaApplication.logger.info("200: "+todos.size()+" personas encontradas.");
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
