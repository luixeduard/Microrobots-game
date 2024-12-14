package mx.uaemex.fi.poo.microrobots.gui;

import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import mx.uaemex.fi.poo.microrobots.control.ControlGeneral;

/**
 * Clase tipo ventana abstracta
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public abstract class VentanaAbstracta extends JFrame implements ActionListener {
	protected ControlGeneral control; 
	
	/**
	 * Constructora que hereda de JFrame	
	 */
	public VentanaAbstracta(){
		super();
	}

	/**
	 * 
	 * @param arg0 Recibe la cadena con la que se creara VentanaAbstracta
	 */
	public VentanaAbstracta(String arg0){

		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param c Recibe 'c' de tipo control general para crear un nuevo control general
	 */
	public void setControl(ControlGeneral c) {
		this.control = c;	
	}
}
