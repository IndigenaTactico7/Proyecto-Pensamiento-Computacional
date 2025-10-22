package Base;
import java.util.Scanner;

import Herederos.Organico;
import Herederos.Inorganico;
import Herederos.Peligrosos;
import Herederos.Electronicos;
import Herederos.Reciclables;
import Herederos.NoAprovechables;

public class Residuos {
    int VidaUtil;
    String Tipo;
    String Nombre;
    double Peso;
    String destino;
    String fechaDeRecoleccion;
    
    public Residuos(int VidaUtil, String Nombre, String Tipo, double Peso, String destino, String fechaDeRecoleccion){
        this.VidaUtil=VidaUtil;
        this.Tipo=Tipo;
        this.Nombre=Nombre;
        this.Peso=Peso;
        this.destino=destino;
        this.fechaDeRecoleccion=fechaDeRecoleccion;
    }

public void ImprimirInfoDelResiduo(){
    System.out.println("Vida Util: " + VidaUtil);
    System.out.println("Tipo: " + Tipo);
    System.out.println("Peso: " + Peso);
    System.out.println("Destino: " + destino);
    System.out.println("Fecha de Recoleccion: " + fechaDeRecoleccion);
}
public static Residuos CrearObjeto(int opcion){

    Scanner input = new Scanner(System.in);

    System.out.println("Ingrese el nombre del residuo:");
    String Nombre = input.next();

    System.out.println("Ingrese la vida util del residuo:");
    int VidaUtil = input.nextInt();
    if (VidaUtil < 0) {
        System.out.println("La vida util no puede ser negativa.");
        input.close();
        return null;
    }

    System.out.println("Ingrese el peso del residuo:");
    double Peso = input.nextDouble();
    if (Peso <0) {
        System.out.println("El peso no puede ser negativo.");
        input.close();
        return null;
    }

    System.out.println("Ingrese el destino del residuo:");
    String destino = input.next();

    System.out.println("Ingrese la fecha de recoleccion del residuo:");
    String fechaDeRecoleccion = input.next();
    
    if (opcion == 1) {
        System.out.println("Ingrese el nivel de biodegradacion del residuo organico:");
        int nivelBiodegradacion = input.nextInt();
        if (nivelBiodegradacion < 0) {
            System.out.println("El nivel de biodegradacion no puede ser negativo.");
            input.close();
            return null;
        }
        input.close();
        return new Organico(VidaUtil, Nombre,"Organico", Peso, destino, fechaDeRecoleccion, nivelBiodegradacion);
    }

    else if (opcion == 2) {
        System.out.println(" Ingrese si el residuo inorganico es combustible (true/false):");
        boolean combustible = input.nextBoolean();
        input.close();
        return new Inorganico(VidaUtil, Nombre, "Inorganico", Peso, destino, fechaDeRecoleccion, combustible);
    }
    else if (opcion == 3) {
        System.out.println(" Ingrese el indice de peligrosidad de el residuo peligroso :");
        int nivelPeligrosidad = input.nextInt();
        if (nivelPeligrosidad < 0) {
            System.out.println("El nivel de peligrosidad no puede ser negativo.");
            input.close();
            return null;
        }
        input.close();
        return new Peligrosos(VidaUtil, Nombre, "Peligroso", Peso, destino, fechaDeRecoleccion, nivelPeligrosidad);
    }
    else if (opcion == 4) {
        System.out.println(" Ingrese la razon por la cual el residuo no es aprovechable :");
        String razonNoAprovechable = input.next();
        input.close();
        return new NoAprovechables(VidaUtil, Nombre, "No Aprovechable", Peso, destino, fechaDeRecoleccion, razonNoAprovechable);
    }
    else if (opcion == 5) {
        System.out.println(" Ingrese si el residuo electronico necesita tratamiento especial (true/false):");
        boolean necesitaTratamientoEspecial = input.nextBoolean();
        input.close();
        return new Electronicos(VidaUtil, Nombre, "Electronico", Peso, destino, fechaDeRecoleccion, necesitaTratamientoEspecial);
    }
    else if (opcion == 6) {
        System.out.println(" Ingrese el tipo de material del residuo reciclable:");
        String tipoMaterial = input.next();
        input.close();
        return new Reciclables(VidaUtil, Nombre, "Reciclable", Peso, destino, fechaDeRecoleccion, tipoMaterial);
    }
    else {
        System.out.println("Opcion no valida.");
        input.close();
        return null;
        
    }
}
}
