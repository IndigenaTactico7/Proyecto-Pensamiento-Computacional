package com.eafit.pensamiento.Herederos;

import com.eafit.pensamiento.Base.Residuos;

public class Inorganico extends Residuos {
    boolean Combustible;



    public Inorganico() {
        super.setTipo("inorganico");

    }

    public boolean isCombustible() {
        return Combustible;
    }

    public void setCombustible(boolean combustible) {
        Combustible = combustible;
    }
}
