package com.eafit.pensamiento.Herederos;
import com.eafit.pensamiento.Base.Residuos;

public class Reciclables extends Residuos{
    
    String tipoDeMaterial;

    public Reciclables(int vidaUtil, String tipo, String nombre, double peso, String destino, String estado, String tipoDeMaterial) {
        super(vidaUtil, tipo, nombre, peso, destino, estado);
        this.tipoDeMaterial = tipoDeMaterial;
    }

    public Reciclables(){
        super.setTipo("reciclable");

    }

    public String getTipoDeMaterial() {
        return tipoDeMaterial;
    }

    public void setTipoDeMaterial(String tipoDeMaterial) {
        this.tipoDeMaterial = tipoDeMaterial;
    }
}