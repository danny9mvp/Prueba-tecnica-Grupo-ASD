package com.grupoasd.api;

import com.grupoasd.entities.ActivoFijo;
import com.grupoasd.entities.ListaActivosFijos;
import com.grupoasd.pruebatecnica.PruebaTecnicaApplication;
import com.grupoasd.services.ImplActivoFijoService;
import com.grupoasd.services.ImplListaActivosFijosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @GetMapping(value = "/tipo/{afijTipo}")
    public ResponseEntity<?> buscarPorTipo(@PathVariable("afijTipo") String afijTipo){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición GET al recurso 'activos/tipo/"
                +afijTipo+"'.");
        try{
            List<ListaActivosFijos> activosPorTipo = implListaActivosFijosService.listarActivosFijosPorTipo(afijTipo);
            if(!activosPorTipo.isEmpty()){
                PruebaTecnicaApplication.logger.info("200: "+activosPorTipo.size()+" Activos Fijos del tipo '"+afijTipo+"' fueron" +
                        " encontrados.");
                return new ResponseEntity<>(activosPorTipo, HttpStatus.OK);
            }
            else{
                PruebaTecnicaApplication.logger.warn("404: No se encontraron resultados en el recurso 'activos/tipo/"+afijTipo+"'.");
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception ex){
            PruebaTecnicaApplication.logger.error("500: "+ex);
            return ResponseEntity.status(500).build();
        }

    }

    @GetMapping("/fechaDeCompra/{stringFechaCompra}")
    public ResponseEntity<?> buscarPorFechaDeCompra(@PathVariable("stringFechaCompra")
                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date afijFechaCompra){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición GET al recurso 'activos/fechaDecompra/"
                +afijFechaCompra+"'.");
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            PruebaTecnicaApplication.logger.info("Fecha: "+afijFechaCompra);
            List<ListaActivosFijos> activosPorFechaDeCompra = implListaActivosFijosService.listarActivosFijosPorFechaDeCompra(afijFechaCompra);
            if(!activosPorFechaDeCompra.isEmpty()){
                PruebaTecnicaApplication.logger.info("200: "+activosPorFechaDeCompra.size()+" Activos Fijos con fecha de compra " +
                        "'" + afijFechaCompra + "' fueron encontrados.");
                return new ResponseEntity<>(activosPorFechaDeCompra, HttpStatus.OK);
            }
            else{
                PruebaTecnicaApplication.logger.warn("404: No se encontraron resultados en el recurso '/activos/fechaDeCompra/"+afijFechaCompra+"'.");
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            PruebaTecnicaApplication.logger.error("500: "+ex);
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/numeroDeSerie/{numeroDeSerie}")
    public ResponseEntity<?> buscarPorNumeroDeSerie(@PathVariable("numeroDeSerie") String numeroDeSerie){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición GET al recurso 'activos/numeroDeSerie/"
        +numeroDeSerie);
        try{
            if(implListaActivosFijosService.buscarActivoFijoPorNumeroDeSerie(numeroDeSerie) != null){
                PruebaTecnicaApplication.logger.info("200:  Activo Fijo con número de serie "+numeroDeSerie+" encontrado.");
                return new ResponseEntity(implListaActivosFijosService.buscarActivoFijoPorNumeroDeSerie(numeroDeSerie), HttpStatus.OK);
            }
            else{
                PruebaTecnicaApplication.logger.warn("404: No se encontraron resultados en el recurso '/activos/numeroDeSerie/"+numeroDeSerie+"'.");
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            PruebaTecnicaApplication.logger.error("500: "+ex);
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value = "/crearActivoFijo", consumes = "application/json")
    public ResponseEntity<?> crearActivo(@RequestBody ActivoFijo activoFijo){
        PruebaTecnicaApplication.logger.info("Creando nuevo activo...");
        try{
            ActivoFijo nuevoActivoFijo = implActivoFijoService.crearActivo(activoFijo);
            PruebaTecnicaApplication.logger.info("Activo Fijo con datos : "+nuevoActivoFijo.toString()+" \n creado satisfactoriamente.");
            return new ResponseEntity(activoFijo, HttpStatus.CREATED);
        }
        catch (Exception ex){
            PruebaTecnicaApplication.logger.error("Imposible crear el nuevo activo fijo. Asegúrese de que los datos ingresados" +
                    " sean correctos.");
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/actualizarActivoFijo/{afijId}", consumes = "application/json")
    public ResponseEntity<?> actualizarActivo(@PathVariable("afijId") int afijId, @RequestBody ActivoFijo activoFijo){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición PUT al recurso 'activos/actualizarActivoFijo/"+afijId);
        if(!(implActivoFijoService.buscarPorId(afijId).isPresent())){
            PruebaTecnicaApplication.logger.warn("400: El activo fijo con id = "+afijId+" no existe.");
            return ResponseEntity.badRequest().build();
        }
        else{
            PruebaTecnicaApplication.logger.info("200: El activo fijo con id ="+afijId+" ha sido actualizado satisfactoriamente.");
            ActivoFijo activoFijoActualizado = implActivoFijoService.actualizarActivo(activoFijo);
            return ResponseEntity.ok().build();
        }
    }
}
