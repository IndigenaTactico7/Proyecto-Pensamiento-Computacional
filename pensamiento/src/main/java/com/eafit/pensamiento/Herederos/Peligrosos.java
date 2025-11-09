package com.eafit.pensamiento.Herederos;
import com.eafit.pensamiento.Base.Residuos;

public class Peligrosos extends Residuos{
    int nivelPeligrosidad;

    public Peligrosos(){
        super.setTipo("peligroso");
    }

    public int getNivelPeligrosidad() {
        return nivelPeligrosidad;
    }

    public void setNivelPeligrosidad(int nivelPeligrosidad) {
        this.nivelPeligrosidad = nivelPeligrosidad;
    }
}
