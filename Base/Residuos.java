package Base;
import java.util.Scanner;
import java.util.ArrayList;

import Herederos.Organico;
import Herederos.Inorganico;
import Herederos.Peligrosos;
import Herederos.Electronicos;
import Herederos.Reciclables;
import Herederos.NoAprovechables;

public class Residuos {
    public static ArrayList<Residuos> listaDeResiduos = new ArrayList<>();
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
    System.out.println("Nombre: " + Nombre);
    System.out.println("Tipo: " + Tipo);
    System.out.println("Peso: " + Peso);
    System.out.println("Vida Util: " + VidaUtil);
    System.out.println("Destino: " + destino);
    System.out.println("Fecha de Recoleccion: " + fechaDeRecoleccion);
}
public static Residuos CrearObjeto(int opcion, Scanner input){


    System.out.println("Ingrese el nombre del residuo:");
    String Nombre = input.nextLine();

    System.out.println("Ingrese la vida util del residuo:");
    int VidaUtil = input.nextInt();
    input.nextLine();  
    if (VidaUtil < 0) {
        System.out.println("La vida util no puede ser negativa.");
        return null;
    }
    

    System.out.println("Ingrese el peso del residuo:");
    double Peso = input.nextDouble();
    input.nextLine();
    if (Peso <0) {
        System.out.println("El peso no puede ser negativo.");
        return null;
    }

    System.out.println("Ingrese el destino del residuo:");
    String destino = input.nextLine();

    System.out.println("Ingrese la fecha de recoleccion del residuo:");
    String fechaDeRecoleccion = input.nextLine();
    
    if (opcion == 1) {
        System.out.println("Ingrese el nivel de biodegradacion del residuo organico:");
        int nivelBiodegradacion = input.nextInt();
        input.nextLine();  
        if (nivelBiodegradacion < 0) {
            System.out.println("El nivel de biodegradacion no puede ser negativo.");
            return null;
        }
        Organico organico = new Organico(VidaUtil, Nombre,"Organico", Peso, destino, fechaDeRecoleccion, nivelBiodegradacion);
        listaDeResiduos.add(organico);
        return organico;
    }
    else if (opcion == 2) {
        System.out.println("Ingrese si el residuo inorganico es combustible (true/false):");
        boolean combustible = input.nextBoolean();
        Inorganico inorganico = new Inorganico(VidaUtil, Nombre, "Inorganico", Peso, destino, fechaDeRecoleccion, combustible);
        listaDeResiduos.add(inorganico);
        return inorganico;
    }
    else if (opcion == 3) {
        System.out.println("Ingrese el indice de peligrosidad de el residuo peligroso :");
        int nivelPeligrosidad = input.nextInt();
        input.nextLine();  
        if (nivelPeligrosidad < 0) {
            System.out.println("El nivel de peligrosidad no puede ser negativo.");
            return null;
        }
        Peligrosos peligroso = new Peligrosos(VidaUtil, Nombre, "Peligroso", Peso, destino, fechaDeRecoleccion, nivelPeligrosidad);
        listaDeResiduos.add(peligroso);
        return peligroso;
    }
    else if (opcion == 4) {
        System.out.println("Ingrese la razon por la cual el residuo no es aprovechable :");
        String razonNoAprovechable = input.nextLine();
        NoAprovechables noAprovechable = new NoAprovechables(VidaUtil, Nombre, "No Aprovechable", Peso, destino, fechaDeRecoleccion, razonNoAprovechable);
        listaDeResiduos.add(noAprovechable);
        return noAprovechable;
    }
    else if (opcion == 5) {
        System.out.println("Ingrese si el residuo electronico necesita tratamiento especial (true/false):");
        boolean necesitaTratamientoEspecial = input.nextBoolean();
        Electronicos electronico = new Electronicos(VidaUtil, Nombre, "Electronico", Peso, destino, fechaDeRecoleccion, necesitaTratamientoEspecial);
        listaDeResiduos.add(electronico);
        return electronico;
    }
    else if (opcion == 6) {
        System.out.println("Ingrese el tipo de material del residuo reciclable:");
        String tipoMaterial = input.nextLine();
        Reciclables reciclable = new Reciclables(VidaUtil, Nombre, "Reciclable", Peso, destino, fechaDeRecoleccion, tipoMaterial);
        listaDeResiduos.add(reciclable);
        return reciclable;
    }
    else {
        System.out.println("Opcion no valida.");
        input.nextLine();  
        return null;
        
    }   
}
}

