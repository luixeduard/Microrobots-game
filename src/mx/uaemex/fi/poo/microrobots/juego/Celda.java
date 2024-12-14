package mx.uaemex.fi.poo.microrobots.juego;
/**
 * Clase que crea una Celda con su color y valor
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class Celda {
	
	private int Color;
	private int valor;
	
	/**
	 * Hace referencia al color guardado de la celda creada
	 * @return muestra el color de la celda
	 */
	public int getColor() {
		return Color;
	}
	/**
	 * Establece un color a la celda creada
	 * @param color recibimos un entero y lo asignamos a el color a la celda
	 */
	public void setColor(int color) {
		this.Color = color;
	}
	/**
	 * Hace referencia al valor guardado de la celda creada
	 * @return muestra la variable valor
	 */
	public int getNumero() {
		return valor;
	}
	/**
	 * Establece un numero a la celda creada
	 * @param numero recibimos un entero y lo signamos el numero a valor
	 */
	public void setNumero(int numero) {
		this.valor = numero;
	}
	
}
