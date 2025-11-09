package Herederos;
import Base.Residuos;
public class NoAprovechables extends Residuos   {
    String razonNoAprovechable;
    public NoAprovechables (int VidaUtil, String Nombre, String Tipo, double Peso, String destino,String estado, String fechaDeRecoleccion, String razonNoAprovechable){
        super(VidaUtil, Nombre, Tipo, Peso, destino, estado, fechaDeRecoleccion);
        this.razonNoAprovechable = razonNoAprovechable;
    }
    @Override
    public void ImprimirInfoDelResiduo() {
        super.ImprimirInfoDelResiduo();
        System.out.println("La razon por la que no es aprovechable es: " + razonNoAprovechable); 
    }
    
}
