package mx.uaemex.fi.poo.microrobots.data;

/**
 * Pasamos talla para establecerla y obtenerla del tablero
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class TallaTablero implements Data {
	private int talla;
	/**
	 * Constructora de Talla tablero
	 * @param t talla de nustro tablero
	 */
	public TallaTablero(int t) {
		this.talla = t;
	}
	/**
	 * Obtiene la talla del tablero
	 * @return talla 
	 */
	public int getTalla() {
		return talla;
	}
	/**
	 * Recibe una variable entera para establecerla como una variable local de talla tablero
	 * @param talla Parametro que se recive para establecerla de tipo talla
	 */
	public void setTalla(int talla) {
		this.talla = talla;
	}
}
