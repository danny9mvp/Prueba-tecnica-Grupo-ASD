package com.grupoasd.api;

import com.grupoasd.entities.Ciudad;
import com.grupoasd.services.ImplCiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequestMapping("/ciudades")
public class CiudadesApi {
    @Autowired private ImplCiudadService implCiudadService;

    @GetMapping("/todos")
    public ResponseEntity<?> todos(){
        ArrayList<Ciudad> ciudades = implCiudadService.listarCiudades();
        return new ResponseEntity<>(ciudades, HttpStatus.OK);
    }
}
