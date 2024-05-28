import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase que representa a un Domador de Digimons
 */
public class Domador {

	private String nombre; //Nombre del domador 
	private ArrayList<Digimon> equipo; //Lista de Digimons en el equipo del domador
	
	/**
	 * Constructor de la clase Domador
	 * @param nombre El nombre del domador
	 */
	
	public Domador(String nombre) {
		this.nombre=nombre;
		this.equipo=new ArrayList<>();
		String []nombresDigimon= {"Agumon","Gabumon","Patamon","Biyomon","Tentomon","Gomamon","Palmon","Gatomon","Veemon","Guilmon"};
		Random rand=new Random();
		Digimon digimonInicial= new Digimon(nombresDigimon[rand.nextInt(nombresDigimon.length)]);
		equipo.add(digimonInicial);
		System.out.println(digimonInicial.getNombre()+" "+"se ha unido a tu equipo.");
		
		if(equipo.size()==3) {
			System.out.println("¡Felicidades" +" "+ nombre + "!Has conseguido 3 digimons");
			seguirJugando();
	}
}
	
	/**
	 * Método para capturar un Digimon y agregarlo al equipo del domador.
	 * @param digimon El digimon a capturar 
	 */
	
	public void captura (Digimon digimon ) {
		
		if(digimon.getSalud()<=20) {
			equipo.add(digimon);
			System.out.println(digimon.getNombre() + " "+"se ha unido a tu equipo.");
		if(equipo.size() ==3) {
			System.out.println("!Felicidades, " + " "+ nombre + "! Has conseguido 3 Digimons ");
		}
		
		}else {
			System.out.println(digimon.getNombre() +" "+ "no se puede unir al equipo.");
		}
	}
	
	
	/**
	 *  Método privado para preguntar al usuario si desea seguir jugando.
	 */
	private void seguirJugando() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Quieres seguir jugando? (Si/No) ");
		String respuesta=scanner.nextLine().toLowerCase();
		if(respuesta.equals("si")) {
			
		}else if (respuesta.equals("no")) {
			System.out.println("¡Hasta luego ," + ""+ nombre + "!");
			System.exit(0);
		}else {
			System.out.println("Respuesta no válida. Por favor, responde 'Si' o 'No' .");
			seguirJugando();
		}
		
	}

	/**
	 * Método para obtener el equipo del domador.
	 * @return
	 */
	
	public ArrayList<Digimon> getEquipo(){
		return equipo;
	}
	
}

