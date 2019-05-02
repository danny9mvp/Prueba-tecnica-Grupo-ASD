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
 *
 * @author DanielMauricio
 */
@Entity
@Table(name = "listarpersonas")
@XmlRootElement
public class ListaPersonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "pers_id")
    private Integer persId;
    @Column(name = "pers_nombres")
    private String persNombres;
    @Column(name = "pers_apellidos")
    private String persApellidos;
    @Column(name = "pers_activofijo")
    private Integer persActivofijo;

    public ListaPersonas() {
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

    public Integer getPersActivofijo() {
        return persActivofijo;
    }

    public void setPersActivofijo(Integer persActivofijo) {
        this.persActivofijo = persActivofijo;
    }

}
