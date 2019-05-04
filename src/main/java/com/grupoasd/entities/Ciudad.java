package com.grupoasd.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * La clase Ciudad es la entidad asociada a la tabla 'CIUDAD' en la base de datos.
 *
 * @author Daniel Mauricio
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Id de la ciudad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ciud_id")
    private Integer ciudId;
    /**
     * Nombre de la ciudad.
     */
    @Basic(optional = false)
    @Column(name = "ciud_nombre")
    private String ciudNombre;
    /**
     * Listado de áreas pertenecientes a una ciudad.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaCiudad")
    private List<Area> areaList;

    public Ciudad() {
    }

    public Ciudad(Integer ciudId) {
        this.ciudId = ciudId;
    }

    public Ciudad(Integer ciudId, String ciudNombre) {
        this.ciudId = ciudId;
        this.ciudNombre = ciudNombre;
    }

    public Integer getCiudId() {
        return ciudId;
    }

    public void setCiudId(Integer ciudId) {
        this.ciudId = ciudId;
    }

    public String getCiudNombre() {
        return ciudNombre;
    }

    public void setCiudNombre(String ciudNombre) {
        this.ciudNombre = ciudNombre;
    }

    @XmlTransient
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudId != null ? ciudId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.ciudId == null && other.ciudId != null) || (this.ciudId != null && !this.ciudId.equals(other.ciudId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication7.Ciudad[ ciudId=" + ciudId + " ]";
    }

}
