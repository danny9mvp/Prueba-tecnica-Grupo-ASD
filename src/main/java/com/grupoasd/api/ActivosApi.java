package com.grupoasd.api;

import com.grupoasd.com.grupoasd.pojos.USerialFechaRequest;
import com.grupoasd.entities.ActivoFijo;
import com.grupoasd.entities.ListaActivosFijos;
import com.grupoasd.pruebatecnica.PruebaTecnicaApplication;
import com.grupoasd.services.ImplActivoFijoService;
import com.grupoasd.services.ImplListaActivosFijosService;
import org.springframework.beans.factory.annotation.Autowired;
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
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición GET al recurso '/activos/todos'");
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
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición GET al recurso '/activos/tipo/"
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

    @GetMapping("/fechaDeCompra/{fechaDeCompra}")
    public ResponseEntity<?> buscarPorFechaDeCompra(@PathVariable("fechaDeCompra") String stringFecha){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición POST al recurso 'activos/fechaDecompra");
        try{
            Date fechaCompra = new SimpleDateFormat("yyyy-MM-dd").parse(stringFecha);
            PruebaTecnicaApplication.logger.info("Fecha: "+fechaCompra);
            List<ListaActivosFijos> activosPorFechaDeCompra = implListaActivosFijosService.listarActivosFijosPorFechaDeCompra(fechaCompra);
            if(!activosPorFechaDeCompra.isEmpty()){
                PruebaTecnicaApplication.logger.info("200: "+activosPorFechaDeCompra.size()+" Activos Fijos con fecha de compra " +
                        "'" + stringFecha + "' fueron encontrados.");
                return new ResponseEntity<>(activosPorFechaDeCompra, HttpStatus.OK);
            }
            else{
                PruebaTecnicaApplication.logger.warn("404: No se encontraron resultados en el recurso '/activos/fechaDeCompra.");
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
                List<ListaActivosFijos> listaActivosFijos = implListaActivosFijosService.buscarActivoFijoPorNumeroDeSerie(numeroDeSerie);
                PruebaTecnicaApplication.logger.info("200:"+listaActivosFijos.size()+" Activos Fijos con número de serie "+numeroDeSerie+" encontrados.");
                return new ResponseEntity(listaActivosFijos, HttpStatus.OK);
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
            PruebaTecnicaApplication.logger.error("404: Imposible crear el nuevo activo fijo. Asegúrese de que los datos ingresados" +
                    " sean correctos.");
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "/actualizarActivoFijo/{afijId}", consumes = "application/json")
    public ResponseEntity<?> actualizarActivo(@PathVariable("afijId") int afijId, @RequestBody ActivoFijo activoFijo){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición PUT al recurso 'activos/actualizarActivoFijo/"+afijId);
        if(!(implActivoFijoService.buscarPorId(afijId).isPresent())){
            PruebaTecnicaApplication.logger.warn("404: El activo fijo con id = "+afijId+" no existe.");
            return ResponseEntity.badRequest().build();
        }
        else{
            try {
                ActivoFijo activoFijoActualizado = implActivoFijoService.actualizarActivo(activoFijo);
                PruebaTecnicaApplication.logger.info("200: El activo fijo con id =" + afijId + " ha sido actualizado satisfactoriamente.");
                return ResponseEntity.ok().build();
            }
            catch (Exception ex){
                ex.printStackTrace();
                PruebaTecnicaApplication.logger.error("500: "+ex);
                return ResponseEntity.status(500).build();
            }
        }
    }

    @PutMapping(value = "/actualizarSerialInternoYFechaDeBaja/{afijId}", consumes = "application/json")
    public ResponseEntity<?> actualizarSerialInternoYFechaDeBaja(@PathVariable("afijId") int afijId, @RequestBody USerialFechaRequest usfRequest){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición PUT al recurso 'activos/actualizarSerial" +
                "InternoYFechaDeBaja/"+afijId);
        if(!(implActivoFijoService.buscarPorId(afijId)).isPresent()){
            PruebaTecnicaApplication.logger.warn("404: El activo fijo con id = "+afijId+" no existe.");
            return ResponseEntity.badRequest().build();
        }
        else{
            try {
                ActivoFijo activoFijoActualizado = implActivoFijoService.buscarPorId(afijId).get();
                activoFijoActualizado.setAfijNumeroinventario(usfRequest.getUsfrSerial());
                activoFijoActualizado.setAfijFechabaja(usfRequest.getUsfrFechaBaja());
                implActivoFijoService.actualizarSerialYFechaDeBaja(activoFijoActualizado);
                PruebaTecnicaApplication.logger.info("200: El activo fijo con id =" + afijId + " ha sido actualizado satisfactoriamente.");
                return ResponseEntity.ok().build();
            }
            catch(Exception ex){
                ex.printStackTrace();
                PruebaTecnicaApplication.logger.error("500: "+ex);
                return ResponseEntity.status(500).build();
            }
        }
    }

    @GetMapping(value = "/activoFijo/{afijId}", produces = "application/json")
    public ResponseEntity<?> buscarPorId(@PathVariable("afijId") int afijId){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición GET al recurso 'activos/activoFijo/"+afijId);
        Optional<ListaActivosFijos> activoFijoSolicitado = implListaActivosFijosService.buscarPorId(afijId);
        if(!activoFijoSolicitado.isPresent()){
            PruebaTecnicaApplication.logger.warn("404: El activo fijo con id = "+afijId+" no existe.");
            return ResponseEntity.notFound().build();
        }
        else{
            try{
                ListaActivosFijos activoFijoEncontrado = activoFijoSolicitado.get();
                PruebaTecnicaApplication.logger.info("200: El activo fijo con id =" + afijId + " ha sido encontrado.");
                return new ResponseEntity<>(activoFijoEncontrado, HttpStatus.OK);
            }
            catch (Exception ex){
                ex.printStackTrace();
                PruebaTecnicaApplication.logger.error("500: Error en el servidor"+ex);
                return ResponseEntity.status(500).build();
            }
        }
    }

    @GetMapping(value = "/listarSeriales", produces = "application/json")
    public ResponseEntity<?> listarSeriales(){
        PruebaTecnicaApplication.logger.info("El cliente con IP **** **** ***** ha hecho una petición GET al recurso 'activos/listarSeriales");
        try {
            List<String> listaSeriales = implListaActivosFijosService.listarSeriales(implListaActivosFijosService.listarActivosFijos());
            if(!listaSeriales.isEmpty()){
                PruebaTecnicaApplication.logger.info("200: "+listaSeriales.size()+" seriales fueron encontrados.");
                return ResponseEntity.ok(listaSeriales);
            }
            else{
                PruebaTecnicaApplication.logger.warn("404: No se encontraron resultados.");
                return ResponseEntity.notFound().build();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            PruebaTecnicaApplication.logger.error("500: Error en el servidor. "+ex);
            return ResponseEntity.status(500).build();
        }
    }
}
