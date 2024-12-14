package mx.uaemex.fi.poo.microrobots.gui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 * Ventana principal del Juego MicroRobots
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class VentanaPrincipal extends VentanaAbstracta {
	//private VentanaCrearTablero v;
	/**
	 * Constructora del ventana principal donde se establece todo lo que hay que agregar
	 * @throws HeadlessException Arroja el nombre PotroRobots en la ventana
	 */
	public VentanaPrincipal() throws HeadlessException {
		super("PotroRobots");
		//v = new VentanaCrearTablero("Potrotablero");
		JMenuBar barra = new JMenuBar();
		JMenu menu = new JMenu("Archivo");
		JMenuItem opcion = new JMenuItem("Crear tablero");
		opcion.setActionCommand("Crear");
		opcion.addActionListener(this);
		
		menu.add(opcion);
		
		opcion = new JMenuItem("Salir");
		opcion.setActionCommand("Salir");
		opcion.addActionListener(this);
		
		menu.add(opcion);
		
		opcion = new JMenuItem("Leer Tablero");
		opcion.setActionCommand("leer");
		opcion.addActionListener(this);
		
		menu.add(opcion);
		barra.add(menu);
		
		menu = new JMenu("Ayuda");
		opcion = new JMenuItem("Acerca de ...");
		opcion.setActionCommand("About");
		opcion.addActionListener(this);
		
		menu.add(opcion);
		barra.add(menu);
		
		menu = new JMenu("Ventana");
		opcion = new JMenuItem("Control de Desplazamiento");
		opcion.setActionCommand("ctrlDes");
		opcion.addActionListener(this);
		menu.add(opcion);
		barra.add(menu);
		
		this.setJMenuBar(barra);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(50,50,400,600);
	}

	@Override
	/**
	 * Modulo del actionPerformed para ejecutar una accion del actioncommand
	 *  @param Recibe e para determinar que accion vamos a realizar con nuestro case
	 */
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		switch(comando) {
			case "Crear":
				//v.setVisible(true);
				this.control.ejecutaComando("crearTablero", null);
				break;
			case "About":
				JOptionPane.showMessageDialog(this,"PotroRobots:");
				break;
			case "ctrlDes":
				this.control.ejecutaComando("ctrlDes", null);
			case "leer":
				this.control.ejecutaComando("leerTablero", null);
				break;
			case "Salir":
				System.exit(1);
		}

	}

}
