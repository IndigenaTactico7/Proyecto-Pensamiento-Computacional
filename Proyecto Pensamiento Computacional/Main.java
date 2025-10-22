import java.util.Scanner;

import Base.Residuos;
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestion de residuos");
        System.out.println("A continuacion, se le indicaran los tipos de residuos existentes, seleccione el tipo de residuo que desea clasificar:");
        System.out.println("1. Organicos");
        System.out.println("2. Inorganicos");
        System.out.println("3. Peligrosos o especiales");
        System.out.println("4. Residuos no Aprovechables");
        System.out.println("5. Electronicos");
        System.out.println("6. Reciclables");
        System.out.println("Ingrese el numero del tipo de residuo que desea clasificar:");
        
        Scanner input = new Scanner(System.in);
        
        int opcion = input.nextInt();
        Residuos residuo = Residuos.CrearObjeto(opcion);
        residuo.ImprimirInfoDelResiduo();
        
        input.close();
    }
    
}