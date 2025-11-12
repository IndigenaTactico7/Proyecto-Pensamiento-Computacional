package com.eafit.pensamiento.Herederos;

import com.eafit.pensamiento.Base.Residuos;

public class NoAprovechables extends Residuos {
    String razonNoAprovechable;

    public NoAprovechables() {
        super.setTipo("noAprovechable");

    }
    public String getRazonNoAprovechable() {
        return razonNoAprovechable;
    }

    public void setRazonNoAprovechable(String razonNoAprovechable) {
        this.razonNoAprovechable = razonNoAprovechable;
    }
}
