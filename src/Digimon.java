import java.util.Random;

public class Digimon {

	/**
	 * Clase que representa un Digimon
	 */
	
	private String nombre; //Nombre del Digimon 
	private int nivel; //Nivel del Digimon 
	private int ataque; //Puntos de ataque del Digimon 
	private int salud; // Puntos de salud del Digimon
	private int dp1; //Puntos de ataque digital 1 del Digimon 
	private int dp2; //Puntos de ataque digital 2 del Digimon
	
	/**
	 * Constructor de la clase Digimon 
	 * @param nombre El nombre del Digimon
	 */
	
	public Digimon (String nombre) {
		this.nombre=nombre;
		Random rand=new Random();
		this.nivel=rand.nextInt(5)+1;
		this.ataque=5*this.nivel;
		this.salud=10*this.nivel;
		this.dp1=10;
		this.dp2=10;
	}
	
	//Métodos getters y setters
	
	/**
	 * Método para obtener el nombre del Digimon
	 * @return El nombre del Digimon
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Método para obtener el nivel  del Digimon
	 * @return El nivel del Digimon
	 */
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	/**
	 * Método para obtener el ataque del Digimon
	 * @return El ataque del Digimon
	 */
	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}


	/**
	 * Método para obtener la Salud del Digimon
	 * @return La Salud del Digimon
	 */
	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}


	/**
	 * Método para obtener los puntos de ataque digital 1 del Digimon
	 * @return Los puntos de ataque digital 1  del Digimon
	 */
	public int getDp1() {
		return dp1;
	}

	public void setDp1(int dp1) {
		this.dp1 = dp1;
	}
	
	/**
	 * Método para obtener los puntos de ataque digital 2 del Digimon
	 * @return Los puntos de ataque digital 2  del Digimon
	 */

	public int getDp2() {
		return dp2;
	}

	public void setDp2(int dp2) {
		this.dp2 = dp2;
	}
	
	
	/**
	 * Método para reducir la salud  del Digimon cuando recibe daño.
	 * @param danio El daño recibido por el Digimon
	 */
	public void reducirSalud(int danio) {
		this.salud-=danio;
	}
	
	/**
	 * Método que simula el ataque 1 del Digimon 
	 * @return El daño causado por el ataque 1 del Digimon
	 */
	
	public int ataque1() {
		if(dp1>0) {
			dp1--;
			return ataque;
		}else {
			System.out.println(nombre+"no tiene suficientes puntos en el ataque 1.");
			
			return 0;
		}
	}
	
	/**
	 * Método que simula el ataque 2 del Digimon 
	 * @return El daño causado por el ataque 2 del Digimon
	 */
	
	public int ataque2() {
		if(dp2>0) {
			dp2-=2;
			return ataque*2;
			
		}else {
			System.out.println(nombre+"no tiene suficientes puntos en el ataque 2.");
			return 0;
		}
	}

	
	/**
	 * Método que devuelve una representación en cadena del Digimon 
	 * @return Representación en cadena del Digimon. 
	 */
	@Override
	public String toString() {
		return "Digimon [nombre=" + nombre + ", nivel=" + nivel + ", ataque=" + ataque + ", salud=" + salud + ", dp1="
				+ dp1 + ", dp2=" + dp2 + "]";
	}
	
	
}
