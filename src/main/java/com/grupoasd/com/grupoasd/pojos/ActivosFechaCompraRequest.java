package com.grupoasd.com.grupoasd.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ActivosFechaCompraRequest {
    private int id;
    private Date fechaCompra;

    public ActivosFechaCompraRequest(@JsonProperty("id") int id, @JsonProperty("fechaCompra") Date fechaCompra){
        this.id = id;
        this.fechaCompra = fechaCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
