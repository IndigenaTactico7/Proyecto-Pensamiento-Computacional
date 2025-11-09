package Herederos;
import Base.Residuos;
public class Inorganico extends Residuos {
    boolean Combustible;

    public Inorganico(int VidaUtil, String Nombre, String Tipo, double Peso, String destino,String estado, String fechaDeRecoleccion, boolean Combustible){
        super(VidaUtil, Nombre, Tipo, Peso, destino, estado, fechaDeRecoleccion );
        this.Combustible = Combustible;
    }
    @Override
    public void ImprimirInfoDelResiduo() {
        super.ImprimirInfoDelResiduo();
        System.out.println("¿El residuo es inflamable?: " + Combustible); 
    }
}
