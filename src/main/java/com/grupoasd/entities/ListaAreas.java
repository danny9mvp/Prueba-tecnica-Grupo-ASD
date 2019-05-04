package com.grupoasd.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Lista Areas es la entidad asociada a la vista 'listarareas' en la base de datos.
 *
 * @author DanielMauricio
 */
@Entity
@Table(name = "listarareas")
@XmlRootElement
public class ListaAreas implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Id del área.
     */
    @Id
    @Column(name = "area_id")
    private Integer areaId;
    /**
     * Nombre del área.
     */
    @Column(name = "area_nombre")
    private String areaNombre;
    /**
     * Id del Activo Fijo asociado a un área.
     */
    @Column(name = "area_activofijo")
    private Integer areaActivofijo;
    /**
     * Id de la ciudad donde se ubica un área.
     */
    @Column(name = "area_ciudad")
    private Integer areaCiudad;

    public ListaAreas() {
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaNombre() {
        return areaNombre;
    }

    public void setAreaNombre(String areaNombre) {
        this.areaNombre = areaNombre;
    }

    public Integer getAreaActivofijo() {
        return areaActivofijo;
    }

    public void setAreaActivofijo(Integer areaActivofijo) {
        this.areaActivofijo = areaActivofijo;
    }

    public Integer getAreaCiudad() {
        return areaCiudad;
    }

    public void setAreaCiudad(Integer areaCiudad) {
        this.areaCiudad = areaCiudad;
    }

}
