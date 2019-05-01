package com.grupoasd.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "persona")
@XmlRootElement
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pers_id", columnDefinition = "serial")
    private Integer persId;
    @Basic(optional = false)
    @Column(name = "pers_nombres")
    private String persNombres;
    @Basic(optional = false)
    @Column(name = "pers_apellidos")
    private String persApellidos;
    @JoinColumn(name = "pers_activofijo", referencedColumnName = "afij_id")
    @OneToOne(optional = false)
    private ActivoFijo persActivofijo;

    public Persona() {
    }

    public Persona(Integer persId) {
        this.persId = persId;
    }

    public Persona(Integer persId, String persNombres, String persApellidos) {
        this.persId = persId;
        this.persNombres = persNombres;
        this.persApellidos = persApellidos;
    }

    public Integer getPersId() {
        return persId;
    }

    public void setPersId(Integer persId) {
        this.persId = persId;
    }

    public String getPersNombres() {
        return persNombres;
    }

    public void setPersNombres(String persNombres) {
        this.persNombres = persNombres;
    }

    public String getPersApellidos() {
        return persApellidos;
    }

    public void setPersApellidos(String persApellidos) {
        this.persApellidos = persApellidos;
    }

    public ActivoFijo getPersActivofijo() {
        return persActivofijo;
    }

    public void setPersActivofijo(ActivoFijo persActivofijo) {
        this.persActivofijo = persActivofijo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persId != null ? persId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.persId == null && other.persId != null) || (this.persId != null && !this.persId.equals(other.persId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication7.Persona[ persId=" + persId + " ]";
    }

}
