package Herederos;
import Base.Residuos;
public class Electronicos extends Residuos {
Boolean NecesitaTratamientoEspecial;
public Electronicos (int VidaUtil, String Nombre, String Tipo, double Peso, String destino, String fechaDeRecoleccion, Boolean NecesitaTratamientoEspecial){
    super(VidaUtil, Nombre, Tipo, Peso, destino, fechaDeRecoleccion);
    this.NecesitaTratamientoEspecial = NecesitaTratamientoEspecial;
}
@Override
    public void ImprimirInfoDelResiduo() {
        super.ImprimirInfoDelResiduo();
        System.out.println("Necesita tratamiento especial ?: " + NecesitaTratamientoEspecial); 
    }
}
