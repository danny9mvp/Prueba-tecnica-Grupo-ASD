package com.grupoasd.services;

import com.grupoasd.entities.ListaActivosFijos;
import com.grupoasd.repositories.ListaActivosFijosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
/**
 * ImplListaActivosFijosService hace implementación de los métodos de {@link com.grupoasd.services.ListaActivosFijosService} destinados a ser usados en el controlador
 *  REST ActivosApi.
 *
 *  Consultar la interface {@link ListaActivosFijosService}.
 *
 * @author Daniel Mauricio
 */
@Service
public class ImplListaActivosFijosService implements ListaActivosFijosService{
    /**
     * Instancia de {@link com.grupoasd.repositories.ListaActivosFijosRepository} para llamar todos los métodos de esta inteface ya sean heredados o escritos
     * por el desarrollador.
     */
    @Autowired private ListaActivosFijosRepository listaActivosFijosRepository;

    /**
     * Método diseñado para listar todos los activos fijos existentes.
     *
     * @return una lista con todos los activos fijos existentes.
     */
    @Override
    public List<ListaActivosFijos> listarActivosFijos() {
        return (ArrayList<ListaActivosFijos>) listaActivosFijosRepository.findAll(new Sort(Sort.Direction.ASC, "afijId"));
    }

    /**
     * Método diseñado para listar todos los activos fijos de un determinado tipo.
     *
     * @param tipo el tipo de activo fijo.
     * @return una lista con todos los activos fijos encontrados de ese tipo.
     */
    @Override
    public List<ListaActivosFijos> listarActivosFijosPorTipo(String tipo) {
        return listaActivosFijosRepository.findAllByAfijTipo(tipo);
    }

    /**
     * Método diseñado para listar todos los activos fijos según una fecha de compra determinada.
     *
     * @param fechaDeCompra la fecha de compra.
     * @return una lista con todos los activos fijos encontrados con esa fecha de compra.
     */
    @Override
    public List<ListaActivosFijos> listarActivosFijosPorFechaDeCompra(Date fechaDeCompra) {
        return listaActivosFijosRepository.findAllByAfijFechacompra(fechaDeCompra);
    }

    /**
     * Método diseñado para listar todos los activos fijos según un número de serie determinado.
     *
     * @param numeroDeSerie número de serie.
     * @return una lista con todos los activos fijos encontrados con ese número de serie.
     */
    @Override
    public List<ListaActivosFijos> buscarActivoFijoPorNumeroDeSerie(String numeroDeSerie) {
        return (List<ListaActivosFijos>) listaActivosFijosRepository.findAllByAfijNumeroserie(numeroDeSerie);
    }

    /**
     * Método diseñado para buscar un único activo fijo por su id.
     *
     * @param id el id del activo fijo.
     * @return una representación en Spring Optional del activo fijo encontrado.
     */
    @Override
    public Optional<ListaActivosFijos> buscarPorId(int id) {
        return listaActivosFijosRepository.findById(id);
    }

    /**
     * Método diseñado para listar todos los números de serie de los activos fijos existentes.
     *
     * @param listaActivosFijos el listado de activos fijos existentes.
     * @return una lista con todos los números de serie existentes.
     */
    @Override
    public List<String> listarSeriales(List<ListaActivosFijos> listaActivosFijos) {
        List<String> listaSeriales = new ArrayList<>();
        listaActivosFijos.forEach((activoFijo)->{
            if(activoFijo.getAfijNumeroserie() != null){
                listaSeriales.add(activoFijo.getAfijNumeroserie());
            }
        });
        return listaSeriales;
    }

    /**
     * Método diseñado para listar todos los ids de los activos fijos existentes.
     *
     * @param listaActivosFijos el listado de activos fijos existentes.
     * @return una lista con todos los ids existentes.
     */
    @Override
    public List<Integer> listarIds(List<ListaActivosFijos> listaActivosFijos) {
        List<Integer> listaIds = new ArrayList<>();
        listaActivosFijos.forEach((activoFijo)->{ listaIds.add(activoFijo.getAfijId());});
        return listaIds;
    }
}
