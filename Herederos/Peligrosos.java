package Herederos;
import Base.Residuos;
public class Peligrosos extends Residuos {
    int nivelPeligrosidad;
    public Peligrosos (int VidaUtil, String Nombre, String Tipo, double Peso, String destino,String estado, String fechaDeRecoleccion, int nivelPeligrosidad){
        super(VidaUtil, Nombre, Tipo, Peso, destino,estado, fechaDeRecoleccion);
        this.nivelPeligrosidad = nivelPeligrosidad;
    }
    @Override
    public void ImprimirInfoDelResiduo() {
        super.ImprimirInfoDelResiduo();
        System.out.println("El nivel de peligrosidad es de : " + nivelPeligrosidad); 
    }
}
