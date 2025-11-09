package Herederos;
import Base.Residuos;

public class Reciclables extends Residuos {
    
    String tipoDeMaterial;

    public Reciclables(int VidaUtil, String Nombre, String Tipo, double Peso, String destino,String estado, String fechaDeRecoleccion, String tipoDeMaterial) {
        super(VidaUtil, Nombre, Tipo, Peso, destino,estado, fechaDeRecoleccion);
        this.tipoDeMaterial = tipoDeMaterial;
    }
    
    @Override
    public void ImprimirInfoDelResiduo() {
        super.ImprimirInfoDelResiduo();
        System.out.println("Tipo de Material: " + tipoDeMaterial);
    }
}