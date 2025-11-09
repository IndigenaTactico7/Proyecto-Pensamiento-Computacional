package com.eafit.pensamiento.Herederos;

import com.eafit.pensamiento.Base.Residuos;

public class Electronicos extends com.eafit.pensamiento.Base.Residuos {
    Boolean NecesitaTratamientoEspecial;

    public Electronicos() {
        super.setTipo("electronico");

    }

    public Boolean getNecesitaTratamientoEspecial() {
        return NecesitaTratamientoEspecial;
    }

    public void setNecesitaTratamientoEspecial(Boolean necesitaTratamientoEspecial) {
        NecesitaTratamientoEspecial = necesitaTratamientoEspecial;
    }
}
