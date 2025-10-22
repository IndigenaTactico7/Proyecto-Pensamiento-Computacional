package Herederos;
import Base.Residuos;
public class Organico extends Residuos {
int nivelBiodegradacion;
public Organico (int VidaUtil, String Nombre, String Tipo, double Peso, String destino, String fechaDeRecoleccion, int nivelBiodegradacion){
    super(VidaUtil, Nombre, Tipo, Peso, destino, fechaDeRecoleccion);
    this.nivelBiodegradacion = nivelBiodegradacion;
}
}