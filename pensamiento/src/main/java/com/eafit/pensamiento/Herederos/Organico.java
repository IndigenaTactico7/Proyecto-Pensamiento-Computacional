package com.eafit.pensamiento.Herederos;
import com.eafit.pensamiento.Base.Residuos;

public class Organico extends Residuos {
int nivelBiodegradacion;

    public Organico(){
        super.setTipo("organico");

    }
    public int getNivelBiodegradacion() {
        return nivelBiodegradacion;
    }

    public void setNivelBiodegradacion(int nivelBiodegradacion) {
        this.nivelBiodegradacion = nivelBiodegradacion;
    }
}