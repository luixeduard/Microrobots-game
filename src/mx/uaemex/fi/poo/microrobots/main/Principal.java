package mx.uaemex.fi.poo.microrobots.main;

import mx.uaemex.fi.poo.microrobots.control.ControlGeneral;
import mx.uaemex.fi.poo.microrobots.gui.VentanaAddCelda;
import mx.uaemex.fi.poo.microrobots.gui.VentanaCrearTablero;
import mx.uaemex.fi.poo.microrobots.gui.VentanaPrincipal;

/**
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class Principal {

	public static void main(String[] args) {
		ControlGeneral controlPrin = new ControlGeneral();
		VentanaPrincipal ventana= new VentanaPrincipal();
		VentanaCrearTablero v1 = new VentanaCrearTablero();
		VentanaAddCelda v2 = new VentanaAddCelda();
		
		controlPrin.setvAddCelda(v2);
		controlPrin.setvCreacion(v1);
		controlPrin.setvPrincipal(ventana);
		
		ventana.setVisible(true);
	}

}
