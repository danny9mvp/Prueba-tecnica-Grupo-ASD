package com.grupoasd.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DanielMauricio
 */
@Entity
@Table(name = "area")
@XmlRootElement
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "area_id")
    private Integer areaId;
    @Basic(optional = false)
    @Column(name = "area_nombre")
    private String areaNombre;
    @JoinColumn(name = "area_activofijo", referencedColumnName = "afij_id")
    @OneToOne(optional = false)
    private ActivoFijo areaActivofijo;
    @JoinColumn(name = "area_ciudad", referencedColumnName = "ciud_id")
    @ManyToOne(optional = false)
    private Ciudad areaCiudad;

    public Area() {
    }

    public Area(Integer areaId) {
        this.areaId = areaId;
    }

    public Area(Integer areaId, String areaNombre) {
        this.areaId = areaId;
        this.areaNombre = areaNombre;
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

    public ActivoFijo getAreaActivofijo() {
        return areaActivofijo;
    }

    public void setAreaActivofijo(ActivoFijo areaActivofijo) {
        this.areaActivofijo = areaActivofijo;
    }

    public Ciudad getAreaCiudad() {
        return areaCiudad;
    }

    public void setAreaCiudad(Ciudad areaCiudad) {
        this.areaCiudad = areaCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaId != null ? areaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.areaId == null && other.areaId != null) || (this.areaId != null && !this.areaId.equals(other.areaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication7.Area[ areaId=" + areaId + " ]";
    }

}
