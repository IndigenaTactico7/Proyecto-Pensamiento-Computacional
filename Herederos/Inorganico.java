package Herederos;
import Base.Residuos;
public class Inorganico extends Residuos {
    boolean Combustible;

    public Inorganico(int VidaUtil, String Nombre, String Tipo, double Peso, String destino, String fechaDeRecoleccion, boolean Combustible){
        super(VidaUtil, Nombre, Tipo, Peso, destino, fechaDeRecoleccion);
        this.Combustible = Combustible;
    }
    
}
