package com.grupoasd.com.grupoasd.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * La clase USerialFechaRequest es una entidad diseñada específicamente para representar el JSON recibido por el recurso
 * actualizarSerialInternoYFechaDeBaja.
 *
 * @author Daniel Mauricio
 */
public class USerialFechaRequest {
    /**
     * Número de inventario.
     */
    private String usfrSerial;
    /**
     * Fecha de baja.
     */
    private Date usfrFechaBaja;

    public USerialFechaRequest(@JsonProperty("serial") String usfrSerial, @JsonProperty("fechaBaja") Date usfrFechaBaja){
        this.usfrSerial = usfrSerial;
        this.usfrFechaBaja = usfrFechaBaja;
    }

    public String getUsfrSerial() {
        return usfrSerial;
    }

    public void setUsfrSerial(String usfrSerial) {
        this.usfrSerial = usfrSerial;
    }

    public Date getUsfrFechaBaja() {
        return usfrFechaBaja;
    }

    public void setUsfrFechaBaja(Date usfrFechaBaja) {
        this.usfrFechaBaja = usfrFechaBaja;
    }
}
