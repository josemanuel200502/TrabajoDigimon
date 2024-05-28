import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase que representa una Batalla Digital entre el Domador y un Digimon enemigo.
 */

public class BatallaDigital {

	private Digimon enemigo; //Digimon enemigo 
	private Domador domador; //Domador que participa en la batalla 
	
	/**
	 * Constructor de la clase BatallaDigital
	 * @param domador
	 * @throws Lanza una excepcion si el domador no tiene ningun digimon en su equipo
	 */
	
	public BatallaDigital(Domador domador) {
		this.domador=domador;
		String[]nombresDigimon= {"Agumon","Gabumon","Patamon","Biyomon","Tentomon","Gomamon","Palmon","Gatomon","Veemon","Guilmon"};
		Random rand = new Random();
		this.enemigo=new Digimon (nombresDigimon[rand.nextInt(nombresDigimon.length)]);
		System.out.println("Un "+" " + enemigo.getNombre()+""+ "salvaje ha aparecido.");
	}
	
	
	/**
	 * Método para que el domador elija un Digimon de su equipo para pelear
	 * @return domador El domador que participa en la batalla
	 */
	
	public Digimon elige() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Elige un digimon de tu equipo: ");
		for(int i=0;i<domador.getEquipo().size(); i++) {
			System.out.println((i+1)+" "+domador.getEquipo().get(i));
		}
		int eleccion = scanner.nextInt();
		return domador.getEquipo().get(eleccion-1);
	}
	

	/**
	 * Método que simula la pelea entre el Digimon elegido por el domador y el Digimon enemigo.
	 * @exception nos lanza una excepcion en caso de que el enemigo o el usuario eligan una opcion invalida
	 */
	public void pelea()  throws InputMismatchException{
		
		 Scanner scanner = new Scanner(System.in);
		 try {
	        Digimon elegido = elige();
	        while (true) {
	        	
	        //Turno del jugador
	            System.out.println("Elige una acción: 1. Ataque1 2. Ataque2 3. Capturar");
	            int accion = scanner.nextInt();
	            if (accion == 1) {
	                enemigo.reducirSalud(elegido.ataque1());
	            } else if (accion == 2) {
	                enemigo.reducirSalud(elegido.ataque2());
	            } else if (accion == 3) {
	                domador.captura(enemigo);
	                break;
	            }else {
	            	throw new InputMismatchException("Opción no válida.");
	            }
	            
	            //Verificar si el enemigo ha sido derrotado
	            
	            if(enemigo.getSalud()<=0) {
	            	System.out.println("¡"+ enemigo.getNombre()+ " ha sido derrotado.");
	            	break;
	            }
	            
	            //Turno del enemigo
	            
	            int accionEnemigo= 1+(int)(Math.random()*2); //Selecionar una acción aleatoria para el enemigo
	            if (accionEnemigo == 1) {
	                elegido.reducirSalud(enemigo.ataque1());
	                System.out.println(enemigo.getNombre() + " ha usado Ataque1.");
	            } else {
	                elegido.reducirSalud(enemigo.ataque2());
	                System.out.println(enemigo.getNombre() + " ha usado Ataque2.");
	            }
	            // Verificar si el jugador ha perdido
	            if (elegido.getSalud() <= 0) {
	                System.out.println("¡" + elegido.getNombre() + " ha sido derrotado! ¡Has perdido la batalla!");
	                break;
	            }
	            // Mostrar la salud actual de ambos Digimon
	            System.out.println("La salud de " + enemigo.getNombre() + " es ahora de " + enemigo.getSalud() + " puntos.");
	            System.out.println("La salud de " + elegido.getNombre() + " es ahora de " + elegido.getSalud() + " puntos.");
	        }
	    } catch (InputMismatchException e) {
	        System.out.println("Error: " + e.getMessage());
	        scanner.nextLine();
	        throw e;
	    }
	}
	            
	        
	    }
	
	

