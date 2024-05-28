import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Clase principal que contiene el método main para ejecutar el juego
 * @author José Manuel Flores Marzo 
 */
public class Principal {

	
	/**
	 * Método principal que ejecuta el juego 
	 * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).

	 */
	public static void main(String[] args) {
		
		//Se crea un objeto Scanner para leer la entrada del usuario
		Scanner scanner = new Scanner(System.in);
		
		//Se solicita al usuario que introduzca el nombre del domador
        System.out.println("Introduce el nombre del domador:");
        String nombreDomador = scanner.nextLine();
        
        //Se crea un objeto Domador con el nombre proporcionado por el usuario
        Domador domador = new Domador(nombreDomador);

        //Bucle principal del juego 
        while (true) {
        	try {
        	//Se muestran las opciones disponibles al usuario
            System.out.println("Opciones: 1. Iniciar batalla 2. Salir");
            //Se lee la opción elegida por el usuario
            int opcion = scanner.nextInt();
            
            //Se ejecuta la opción seleccionada 
            if (opcion == 1) {
            	//Se inicia la batalla
                BatallaDigital batalla = new BatallaDigital(domador);
                batalla.pelea();
            } else if (opcion == 2) {
            	//Se muestra un mensaje de despedida y se sale del bucle
                System.out.println("¡Hasta luego, " + nombreDomador + "!");
                break;
            }else {
            	/**
            	 * @throws Excepcion que se lanza si el usuario ingresa una opción invalida
            	 */
            	
            	throw new InputMismatchException("Opción no válida. Por favor, ingrese 1 o 2.");
            	
            }
            		
           }catch (InputMismatchException e) {
        	   //Se captura la excepción  y se muestra un mensaje de error
        	   System.out.println("Error: "+ e.getMessage());
        	   scanner.nextLine();
        
    }

	}
        //Se cierra el scanner al finalizar el juego
        scanner.close();
	}
}
