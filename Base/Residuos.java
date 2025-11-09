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
    protected String Tipo;
    protected String Nombre;
    double Peso;
    String destino;
    String estado;
    String fechaDeRecoleccion;
    
    public Residuos(int VidaUtil, String Nombre, String Tipo, double Peso, String destino,String estado, String fechaDeRecoleccion){
        this.VidaUtil=VidaUtil;
        this.Tipo=Tipo;
        this.Nombre=Nombre;
        this.Peso=Peso;
        this.destino=destino;
        this.estado=estado;
        this.fechaDeRecoleccion=fechaDeRecoleccion;
    }

public void ImprimirInfoDelResiduo(){
    System.out.println("Nombre: " + Nombre);
    System.out.println("Tipo: " + Tipo);
    System.out.println("Peso: " + Peso+" Kg");
    System.out.println("Vida Util: " + VidaUtil+" años");
    System.out.println("Destino: " + destino);
    System.out.println("Estado: " + estado);
    System.out.println("Fecha de Recoleccion: " + fechaDeRecoleccion);
}
public static Residuos CrearObjeto(int opcion, Scanner input){


    System.out.println("Ingrese el nombre del residuo:");
    String Nombre = input.nextLine();

    System.out.println("Ingrese la vida util del residuo en años:");
    int VidaUtil = input.nextInt();
    input.nextLine();  
    if (VidaUtil < 0) {
        System.out.println("La vida util no puede ser negativa.");
        return null;
    }
    

    System.out.println("Ingrese el peso del residuo en Kg:");
    double Peso = input.nextDouble();
    input.nextLine();
    if (Peso <0) {
        System.out.println("El peso no puede ser negativo.");
        return null;
    }

    System.out.println("Ingrese el destino del residuo:");
    String destino = input.nextLine();

    System.out.println("Ingrese el estado del residuo:");
    String estado = input.nextLine();

    System.out.println("Ingrese la fecha de recoleccion del residuo (El formato es Dia/Mes/Año):");
    String fechaDeRecoleccion = input.nextLine();
    
    if (opcion == 1) {
        System.out.println("Ingrese el nivel de biodegradacion del residuo organico:");
        int nivelBiodegradacion = input.nextInt();
        input.nextLine();  
        if (nivelBiodegradacion < 0) {
            System.out.println("El nivel de biodegradacion no puede ser negativo.");
            return null;
        }
        Organico organico = new Organico(VidaUtil, Nombre,"Organico", Peso, destino, estado,fechaDeRecoleccion, nivelBiodegradacion);
        listaDeResiduos.add(organico);
        return organico;
    }
    else if (opcion == 2) {
        System.out.println("Ingrese si el residuo inorganico es combustible (true/false):");
        boolean combustible = input.nextBoolean();
        Inorganico inorganico = new Inorganico(VidaUtil, Nombre, "Inorganico", Peso, destino,estado, fechaDeRecoleccion, combustible);
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
        Peligrosos peligroso = new Peligrosos(VidaUtil, Nombre, "Peligroso", Peso, destino,estado, fechaDeRecoleccion, nivelPeligrosidad);
        listaDeResiduos.add(peligroso);
        return peligroso;
    }
    else if (opcion == 4) {
        System.out.println("Ingrese la razon por la cual el residuo no es aprovechable :");
        String razonNoAprovechable = input.nextLine();
        NoAprovechables noAprovechable = new NoAprovechables(VidaUtil, Nombre, "No Aprovechable", Peso, destino,estado,  fechaDeRecoleccion, razonNoAprovechable);
        listaDeResiduos.add(noAprovechable);
        return noAprovechable;
    }
    else if (opcion == 5) {
        System.out.println("Ingrese si el residuo electronico necesita tratamiento especial (true/false):");
        boolean necesitaTratamientoEspecial = input.nextBoolean();
        Electronicos electronico = new Electronicos(VidaUtil, Nombre, "Electronico", Peso, destino,estado,  fechaDeRecoleccion, necesitaTratamientoEspecial);
        listaDeResiduos.add(electronico);
        return electronico;
    }
    else if (opcion == 6) {
        System.out.println("Ingrese el tipo de material del residuo reciclable:");
        String tipoMaterial = input.nextLine();
        Reciclables reciclable = new Reciclables(VidaUtil, Nombre, "Reciclable", Peso, destino, estado,  fechaDeRecoleccion, tipoMaterial);
        listaDeResiduos.add(reciclable);
        return reciclable;
    }
    else {
        System.out.println("Opcion no valida.");
        input.nextLine();  
        return null;
        
    }   
}

public static void generarInforme() {
    if (listaDeResiduos.isEmpty()) {
        System.out.println("\nNo hay residuos registrados para crear el informe.");
        return;
    }
    int total = listaDeResiduos.size();
    int reciclados = 0;
    int reutilizados = 0;
    int eliminados = 0;

    for (Residuos residuo : listaDeResiduos) {
        String destino = residuo.destino.toLowerCase();

        if (destino.contains("recicl")) { 
            reciclados++;
        } else if (destino.contains("reutil")) {
            reutilizados++;
        } else if (destino.contains("elimin")) {
            eliminados++;
        }
    }
    double porcReciclado = (reciclados * 100.0) / total;
    double porcReutilizado = (reutilizados * 100.0) / total;
    double porcEliminado = (eliminados * 100.0) / total;

    System.out.println("\nInforme de la Gestion de residuos:");
    System.out.println("Total de residuos registrados: " + total);
    System.out.printf("Reciclados: %.2f%% (%d residuos)\n", porcReciclado, reciclados);
    System.out.printf("Reutilizados: %.2f%% (%d residuos)\n", porcReutilizado, reutilizados);
    System.out.printf("Eliminados: %.2f%% (%d residuos)\n", porcEliminado, eliminados);

    java.util.HashMap<String, Double> pesoPorTipo = new java.util.HashMap<>();
    java.util.HashMap<String, Integer> cantidadPorTipo = new java.util.HashMap<>();

    for (Residuos residuo : listaDeResiduos) {
        String tipo = residuo.getTipo();
        pesoPorTipo.put(tipo, pesoPorTipo.getOrDefault(tipo, 0.0) + residuo.Peso);
        cantidadPorTipo.put(tipo, cantidadPorTipo.getOrDefault(tipo, 0) + 1);
    }

    System.out.println("\nPromedio de peso por tipo: ");
    for (String tipo : pesoPorTipo.keySet()) {
        double promedio = pesoPorTipo.get(tipo) / cantidadPorTipo.get(tipo);
        System.out.printf("%s: %.2f kg\n", tipo, promedio);
    }

    guardarReporte(total, reciclados, reutilizados, eliminados, porcReciclado, porcReutilizado, porcEliminado, pesoPorTipo, cantidadPorTipo);
}

public static void buscarResiduo(Scanner input){
    if (listaDeResiduos.isEmpty()) {
        System.out.println("\nNo hay residuos registrados para buscar");
        return;
    }
    int OpcTemp;
    System.out.println("\nA continuacion podras buscar un residuo a través de:");
    System.out.println("\n1.Tipo\n2.Fecha de recoleccion\n3.Estado\n4.Nombre\n");
    OpcTemp=input.nextInt();
    input.nextLine();
    
    String evaluar="";
    switch (OpcTemp) {
        case 1:
            System.out.println("\nIngrese el tipo del residuo a buscar (organico,inorganico,peligroso,electronicos,No aprovechables,Reciclables):");
            evaluar=input.nextLine().toLowerCase();
            break;
        case 2:
            System.out.println("\nIngrese la fecha del residuo a buscar (Dia/Mes/Año):");
            evaluar=input.nextLine().toLowerCase();
            break;
        case 3:
            System.out.println("\nIngrese el estado del residuo a buscar:");
            evaluar=input.nextLine().toLowerCase();
            break;
        case 4:
            System.out.println("\nIngrese el nombre del residuo a buscar:");
            evaluar=input.nextLine().toLowerCase();
            break;
        default:
         System.out.println("Ingrese una opcion valida");
            return;
    }
    boolean encontrado= false;
    System.out.println("\nResultados de la busqueda:\n");
    for (Residuos residuos : listaDeResiduos) {
        String Buscado="";
        switch (OpcTemp) {
            case 1:
                Buscado= residuos.Tipo.toLowerCase();
                break;
            case 2:
                Buscado= residuos.fechaDeRecoleccion.toLowerCase();
                break;
            case 3:
                Buscado= residuos.estado.toLowerCase();
                break;
            case 4:
                Buscado= residuos.Nombre.toLowerCase();
                break;
        }
        if (Buscado.contains(evaluar)) {
            residuos.ImprimirInfoDelResiduo();
            System.out.println("");
            encontrado=true;
        }
    }

    if(encontrado==false){
        System.out.println("No se encontro un residuo.");
    }
}
public static void actualizarResiduo(Scanner input){
    
    System.out.print("Ingrese el nombre del residuo que desea actualizar: ");
    String nombre = input.nextLine();
    boolean encontrado = false;

    for (Residuos residuo : Residuos.listaDeResiduos) {
        if (residuo.getNombre().equalsIgnoreCase(nombre)) {
            System.out.println("Residuo encontrado: " + residuo.getNombre());
            System.out.println("Desea cambiar el estado o el destino?");
            String opc=input.nextLine().toLowerCase();
            switch (opc) {
                case "estado":
                System.out.println("Ingrese el nuevo estado: ");
                String nuevoEstado = input.nextLine();
                residuo.estado = nuevoEstado;
                    break;
                case "destino":
                System.out.println("Ingrese el nuevo destino (reciclado, reutilizado, eliminado): ");
                String nuevoDestino = input.nextLine();
                residuo.destino = nuevoDestino;
                    break;
                case "ambos":
                System.out.println("Ingrese el nuevo destino (reciclado, reutilizado, eliminado): ");
                nuevoDestino = input.nextLine();
                residuo.destino = nuevoDestino;
                System.out.println("Ingrese el nuevo estado: ");
                nuevoEstado = input.nextLine();
                residuo.estado = nuevoEstado;
                    break;
                default:
                System.out.println("Ingrese una opcion valida");
                    break;
            }
            System.out.println("Datos actualizados correctamente");
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontro un residuo");
    }

}
public static void guardarReporte( /*Para esta parte de aca si se uso chat gpt para saber como crear el archivo de txt en java*/
    int total, int reciclados, int reutilizados, int eliminados,
    double porcReciclado, double porcReutilizado, double porcEliminado,
    java.util.HashMap<String, Double> pesoPorTipo, java.util.HashMap<String, Integer> cantidadPorTipo) {

    try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter("reporte_residuos.txt", true))) {
        writer.println("Reporte generado el " + java.time.LocalDate.now());
        writer.println("Total residuos recolectados: " + total);
        writer.printf("Reciclados: %.2f%% (%d)\n", porcReciclado, reciclados);
        writer.printf("Reutilizados: %.2f%% (%d)\n", porcReutilizado, reutilizados);
        writer.printf("Eliminados: %.2f%% (%d)\n", porcEliminado, eliminados);
        writer.println("\nPromedio de peso por tipo de residuo:");
        for (String tipo : pesoPorTipo.keySet()) {
            double promedio = pesoPorTipo.get(tipo) / cantidadPorTipo.get(tipo);
            writer.printf("%s: %.2f kg\n", tipo, promedio);
        }
        writer.println("---------------------------------------------");
        System.out.println("Reporte guardado en 'reporte_residuos.txt'");
    } catch (Exception e) {
        System.out.println("Error al guardar el reporte: " + e.getMessage());
    }
}


//Metodos get 
public String getTipo(){
        return Tipo;
    }
public String getNombre(){
        return Nombre;
    }
public String getEstado(){
        return estado;
}
}

