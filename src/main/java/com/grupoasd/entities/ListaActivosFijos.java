package com.grupoasd.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "listaractivos")
@XmlRootElement
public class ListaActivosFijos {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "afij_id")
    private Integer afijId;
    @Column(name = "afij_nombre")
    private String afijNombre;
    @Column(name = "afij_descripcion")
    private String afijDescripcion;
    @Column(name = "afij_tipo")
    private String afijTipo;
    @Column(name = "afij_numeroserie")
    private String afijNumeroserie;
    @Column(name = "afij_numeroinventario")
    private String afijNumeroinventario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "afij_alto")
    private Float afijAlto;
    @Column(name = "afij_largo")
    private Float afijLargo;
    @Column(name = "afij_ancho")
    private Float afijAncho;
    @Column(name = "afij_peso")
    private Float afijPeso;
    @Column(name = "afij_valorcompra")
    private BigInteger afijValorcompra;
    @Column(name = "afij_fechacompra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date afijFechacompra;
    @Column(name = "afij_fechabaja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date afijFechabaja;
    @Column(name = "afij_estadoactual")
    private String afijEstadoactual;
    @Column(name = "afij_color")
    private String afijColor;

    public Integer getAfijId() {
        return afijId;
    }

    public void setAfijId(Integer afijId) {
        this.afijId = afijId;
    }

    public String getAfijNombre() {
        return afijNombre;
    }

    public void setAfijNombre(String afijNombre) {
        this.afijNombre = afijNombre;
    }

    public String getAfijDescripcion() {
        return afijDescripcion;
    }

    public void setAfijDescripcion(String afijDescripcion) {
        this.afijDescripcion = afijDescripcion;
    }

    public String getAfijTipo() {
        return afijTipo;
    }

    public void setAfijTipo(String afijTipo) {
        this.afijTipo = afijTipo;
    }

    public String getAfijNumeroserie() {
        return afijNumeroserie;
    }

    public void setAfijNumeroserie(String afijNumeroserie) {
        this.afijNumeroserie = afijNumeroserie;
    }

    public String getAfijNumeroinventario() {
        return afijNumeroinventario;
    }

    public void setAfijNumeroinventario(String afijNumeroinventario) {
        this.afijNumeroinventario = afijNumeroinventario;
    }

    public Float getAfijAlto() {
        return afijAlto;
    }

    public void setAfijAlto(Float afijAlto) {
        this.afijAlto = afijAlto;
    }

    public Float getAfijLargo() {
        return afijLargo;
    }

    public void setAfijLargo(Float afijLargo) {
        this.afijLargo = afijLargo;
    }

    public Float getAfijAncho() {
        return afijAncho;
    }

    public void setAfijAncho(Float afijAncho) {
        this.afijAncho = afijAncho;
    }

    public Float getAfijPeso() {
        return afijPeso;
    }

    public void setAfijPeso(Float afijPeso) {
        this.afijPeso = afijPeso;
    }

    public BigInteger getAfijValorcompra() {
        return afijValorcompra;
    }

    public void setAfijValorcompra(BigInteger afijValorcompra) {
        this.afijValorcompra = afijValorcompra;
    }

    public Date getAfijFechacompra() {
        return afijFechacompra;
    }

    public void setAfijFechacompra(Date afijFechacompra) {
        this.afijFechacompra = afijFechacompra;
    }

    public Date getAfijFechabaja() {
        return afijFechabaja;
    }

    public void setAfijFechabaja(Date afijFechabaja) {
        this.afijFechabaja = afijFechabaja;
    }

    public String getAfijEstadoactual() {
        return afijEstadoactual;
    }

    public void setAfijEstadoactual(String afijEstadoactual) {
        this.afijEstadoactual = afijEstadoactual;
    }

    public String getAfijColor() {
        return afijColor;
    }

    public void setAfijColor(String afijColor) {
        this.afijColor = afijColor;
    }
}
