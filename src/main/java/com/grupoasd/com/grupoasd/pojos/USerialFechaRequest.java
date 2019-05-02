package com.grupoasd.com.grupoasd.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class USerialFechaRequest {
    private String usfrSerial;
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
