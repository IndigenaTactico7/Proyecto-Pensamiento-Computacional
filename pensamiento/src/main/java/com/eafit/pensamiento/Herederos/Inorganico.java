package com.eafit.pensamiento.Herederos;

import com.eafit.pensamiento.Base.Residuos;

public class Inorganico extends Residuos {
    boolean combustible;



    public Inorganico() {
        super.setTipo("inorganico");

    }

    public boolean isCombustible() {
        return combustible;
    }

    public void setCombustible(boolean combustible) {
        this.combustible = combustible;
    }
}
