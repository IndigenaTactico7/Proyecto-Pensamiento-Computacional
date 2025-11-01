import java.util.Scanner;
import Base.Residuos;
public class Main {
    public static void main(String[] args) {
        String Iniciar;
        Scanner input = new Scanner(System.in);
        System.out.println("\nBienvenido al sistema de gestion de residuos");
        do {

        System.out.println("A continuacion, se le indicaran lo que puede hacer en nuestra plataforma por favor seleccione que desea hacer:\n");

        System.out.println("1. Clasificar un residuo");
        System.out.println("2. Mostrar todos los residuos");
        System.out.println("3. Hacer algo:\n");

        int opcionMenu = input.nextInt(); 
        input.nextLine();
            
        if (opcionMenu == 1) {
            System.out.println("Ingrese el numero del tipo de residuo que desea clasificar:\n");
            System.out.println("1. Organicos");
            System.out.println("2. Inorganicos");
            System.out.println("3. Peligrosos o especiales");
            System.out.println("4. Residuos no Aprovechables");
            System.out.println("5. Electronicos");
            System.out.println("6. Reciclables");
            int opcion = input.nextInt();
            input.nextLine();  
            Residuos residuo = Residuos.CrearObjeto(opcion, input);

            if (residuo != null) {
                System.out.println("\nEl residuo '" + residuo.getNombre() + "' ha sido clasificado correctamente como " + residuo.getTipo());
            } else {
                System.out.println("\nError en la clasificación. El residuo no se registró.");
            }
        }
        else if (opcionMenu == 2) {
            System.out.println("Lista de todos los residuos clasificados:(" + Residuos.listaDeResiduos.size() + ")");

            if (Residuos.listaDeResiduos.isEmpty()) {
                System.out.println("\n--- No hay residuos registrados. ---");
            }
            else {
                for (Residuos residuo : Residuos.listaDeResiduos) {
                    System.out.println("-----");
                    residuo.ImprimirInfoDelResiduo();
                }
            }
        }
        else if (opcionMenu == 3) {
                System.out.println("Gracias por usar el programa de clasificacion de residuos");
                break;
            }

        else {
                System.out.println("Opción no válida.");
            }

        System.out.println("Desea seguir usando el programa?, Ingrese Si o No");
        Iniciar = input.nextLine();
        
        if (Iniciar.equalsIgnoreCase("NO")){
            System.out.println("Gracias por usar el programa de clasificacion de residuos");
            break;
        }
        
    }
     while (true);
    input.close();
    }
}