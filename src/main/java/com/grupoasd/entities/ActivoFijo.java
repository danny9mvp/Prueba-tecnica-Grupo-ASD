package com.grupoasd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "activo_fijo")
@XmlRootElement
public class ActivoFijo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "afij_id", columnDefinition = "serial")
    private Integer afijId;
    @Basic(optional = false)
    @Column(name = "afij_nombre")
    private String afijNombre;
    @Basic(optional = false)
    @Column(name = "afij_descripcion")
    private String afijDescripcion;
    @Basic(optional = false)
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
    @Basic(optional = false)
    @Column(name = "afij_estadoactual")
    private String afijEstadoactual;
    @Column(name = "afij_color")
    private String afijColor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "areaActivofijo")
    private Area area;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persActivofijo")
    private Persona persona;

    public ActivoFijo() {
    }

    public ActivoFijo(Integer afijId) {
        this.afijId = afijId;
    }

    public ActivoFijo(String afijNombre, String afijDescripcion, String afijTipo, BigInteger afijValorcompra, String afijEstadoactual) {
        this.afijNombre = afijNombre;
        this.afijDescripcion = afijDescripcion;
        this.afijTipo = afijTipo;
        this.afijValorcompra = afijValorcompra;
        this.afijEstadoactual = afijEstadoactual;
    }

    public ActivoFijo(@JsonProperty("id") int afijId, @JsonProperty("nombre") String afijNombre,
                      @JsonProperty("descripcion") String afijDescripcion
            , @JsonProperty("tipo") String afijTipo, @JsonProperty("serial") String afijNumeroserie,
                      @JsonProperty("numeroInventario") String afijNumeroinventario, @JsonProperty("alto") float afijAlto
            , @JsonProperty("largo") float afijLargo, @JsonProperty("ancho") float afijAncho, @JsonProperty("peso") float afijPeso,
                      @JsonProperty("valorCompra") BigInteger afijValorCompra , @JsonProperty("fechaCompra") Date afijFechacompra
            , @JsonProperty("fechaBaja") Date afijFechabaja, @JsonProperty("estadoActual") String afijEstadoactual,
                      @JsonProperty("color") String afijColor) {
        this.afijId = afijId;
        this.afijNombre = afijNombre;
        this.afijDescripcion = afijDescripcion;
        this.afijTipo = afijTipo;
        this.afijNumeroserie = afijNumeroserie;
        this.afijNumeroinventario = afijNumeroinventario;
        this.afijAlto = afijAlto;
        this.afijLargo = afijLargo;
        this.afijAncho = afijAncho;
        this.afijPeso = afijPeso;
        this.afijValorcompra = afijValorCompra;
        this.afijFechacompra = afijFechacompra;
        this.afijFechabaja = afijFechabaja;
        this.afijEstadoactual = afijEstadoactual;
        this.afijColor = afijColor;
    }

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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (afijId != null ? afijId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoFijo)) {
            return false;
        }
        ActivoFijo other = (ActivoFijo) object;
        if ((this.afijId == null && other.afijId != null) || (this.afijId != null && !this.afijId.equals(other.afijId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("ActivoFijo:{id:%s, nombre:%s, descripcion:%s, tipo:%s, estadoActual:%s}", this.getAfijId(),
                this.getAfijNombre(), this.getAfijDescripcion(), this.getAfijTipo(), this.getAfijEstadoactual());
    }
}
