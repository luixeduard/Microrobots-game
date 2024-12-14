package mx.uaemex.fi.poo.microrobots.gui;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import mx.uaemex.fi.poo.microrobots.error.ColorNoValidoException;
import mx.uaemex.fi.poo.microrobots.juego.Celda;

/**
 * Clase del que crea un boton con una celda estableciendo en esta un color y un valor
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class BotonCelda extends JButton {
	
	public static final int ROJO=4;
	public static final int AZUL=2;
	public static final int VERDE=6;
	public static final int AMARILLO=1;
	public static final int ROSA=5;
	public static final int BLANCO=3;
	
	/**
	 * Modulo con el que crea un BotonCeldaque se le pondra un color y un icono que sera añadido al tablero
	 * @param cel Celda que se la pasa un metodo anterior
	 * @throws ColorNoValidoException Si el color no esta registrado
	 * 
	 * 
	 */
	public BotonCelda(Celda cel) throws ColorNoValidoException {
		Icon icono = new ImageIcon(""+cel.getNumero()+".png");
		this.setIcon(icono);
		this.setBackground(this.getColor(cel.getColor()));
	}
	
	/**
	 * retorna un valor con el que dependiendo el color que retorne se establecera un fondo con el color si no lanzara una excepcion.
	 * @param color Numero en el que se basara su color y entrara en un caso para ubicarse
	 * @return Retorna un color con el parametro ingresado
	 * @throws ColorNoValidoException Si no esta en los casos se dara una excepcion
	 */
	private Color getColor(int color) throws ColorNoValidoException {
		switch(color) {
		case BotonCelda.ROJO:
			return Color.RED;
		case BotonCelda.VERDE:
			return Color.GREEN;
		case BotonCelda.AMARILLO:
			return Color.YELLOW;
		case BotonCelda.AZUL:
			return Color.BLUE;
		case BotonCelda.BLANCO:
			return Color.WHITE;
		case BotonCelda.ROSA:
			return Color.PINK;
		default:
			throw new ColorNoValidoException();
		}
	}
}
