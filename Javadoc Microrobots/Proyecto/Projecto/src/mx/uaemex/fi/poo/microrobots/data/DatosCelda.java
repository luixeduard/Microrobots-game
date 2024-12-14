package mx.uaemex.fi.poo.microrobots.data;


/**
 * Clase que implementa la interface Data
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class DatosCelda implements Data {
	private int numero;
	private int color;
	
	/**
	 * Constructora que establece los datos Celda
	 * @param n Numero de Celda
	 * @param c Color de la celda
	 */
	public DatosCelda(int n, int c) {
		this.numero = n;
		this.color = c;
	}

	/**
	 * Regresa un numero de una 
	 * @return Retorna el numero de la celda
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Modifica el numero de la celda 
	 * @param numero variable que se modifica
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Devuelve el color de la celda
	 * @return devuelve un entero suponiendo que es un color
	 */
	public int getColor() {
		return color;
	}

	/**
	 *Modifica el color de la celda
	 *@param color que se inserta en la tabla 
	 */
	public void setColor(int color) {
		this.color = color;
	}
	
}
