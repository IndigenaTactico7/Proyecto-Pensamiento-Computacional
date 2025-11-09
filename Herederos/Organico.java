package Herederos;
import Base.Residuos;
public class Organico extends Residuos {
int nivelBiodegradacion;
public Organico (int VidaUtil, String Nombre, String Tipo, double Peso, String destino, String estado, String fechaDeRecoleccion, int nivelBiodegradacion){
    super(VidaUtil, Nombre, Tipo, Peso, destino,estado, fechaDeRecoleccion);
    this.nivelBiodegradacion = nivelBiodegradacion;
}
@Override
    public void ImprimirInfoDelResiduo() {
        super.ImprimirInfoDelResiduo();
        System.out.println("Su nivel de biodegradacion es de: " + nivelBiodegradacion); 
    }
}