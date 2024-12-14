package mx.uaemex.fi.poo.microrobots.juego;

import java.util.Random;
/**
 * Clase generadora de una ubicacion para el robot de microrobots
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class UbicacionFalla {
	private int co;
	private int fi;
	/**
	 * generar un numero aleatorio para crear una posicion
	 * @param t el rango para la semilla del random
	 */
	
	public UbicacionFalla(int t){
		Random c = new Random();
		Random f = new Random();
		this.co = c.nextInt(t);
		this.fi = f.nextInt(t);
	}
	
	/**
	 * Retorna la fila aleatoria de la constructora
	 * @return la posicion de la fila
	 */
	public int getPosFila() {
		return fi;
	}

	/**
	 * Retorna la columa aleatoria de la constructora
	 * @return la posicion de la columna
	 */
	public int getPosColumna() {
		return co;
	}
}
