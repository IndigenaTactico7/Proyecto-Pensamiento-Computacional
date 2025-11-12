package com.eafit.pensamiento.Herederos;

import com.eafit.pensamiento.Base.Residuos;

public class Electronicos extends com.eafit.pensamiento.Base.Residuos {
    Boolean necesitaTratamientoEspecial;

    public Electronicos() {
        super.setTipo("electronico");

    }

    public Boolean getNecesitaTratamientoEspecial() {
        return necesitaTratamientoEspecial;
    }

    public void setNecesitaTratamientoEspecial(Boolean necesitaTratamientoEspecial) {
        this.necesitaTratamientoEspecial = necesitaTratamientoEspecial;
    }
}
