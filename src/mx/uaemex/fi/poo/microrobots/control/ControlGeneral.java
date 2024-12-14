package mx.uaemex.fi.poo.microrobots.control;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import mx.uaemex.fi.poo.microrobots.data.Data;
import mx.uaemex.fi.poo.microrobots.data.DatosCelda;
import mx.uaemex.fi.poo.microrobots.data.TallaTablero;
import mx.uaemex.fi.poo.microrobots.error.ColorNoValidoException;
import mx.uaemex.fi.poo.microrobots.gui.VentanaAddCelda;
import mx.uaemex.fi.poo.microrobots.gui.VentanaCrearTablero;
import mx.uaemex.fi.poo.microrobots.gui.VentanaPrincipal;
import mx.uaemex.fi.poo.microrobots.gui.VentanaTablero;
import mx.uaemex.fi.poo.microrobots.juego.Celda;
import mx.uaemex.fi.poo.microrobots.juego.FueraDeRangoException;
import mx.uaemex.fi.poo.microrobots.juego.Tablero;
import mx.uaemex.fi.poo.microrobots.juego.TableroLlenoException;
import mx.uaemex.fi.poo.microrobots.juego.UbicacionRobot;

/**
 * Control General del juego Microrobots
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class ControlGeneral {
	private Tablero tablero;
	private VentanaCrearTablero vCreacion;
	private VentanaAddCelda vAddCelda;
	private VentanaPrincipal vPrincipal;
	private VentanaTablero vTablero;
	private FileInputStream fis;
	private FileOutputStream fos;
	private XMLEncoder codificador;
	private XMLDecoder decodificador;
	
	/**
	 * Se inicializa vPrincipal que muestra las opciones principales
	 * @param vPrincipal recibe una variable de tipo VentanaPrincipal
	 */
	public void setvPrincipal(VentanaPrincipal vPrincipal) {
		this.vPrincipal = vPrincipal;
		this.vPrincipal.setControl(this);
	}
	
	/**
	 * Inicializa el tablero para que pudeda ser creada
	 * @param vCreacion es una ventana para la creacion de tablero 
	 */
	public void setvCreacion(VentanaCrearTablero vCreacion) {
		this.vCreacion = vCreacion;
		this.vCreacion.setControl(this);
	}

	public void setvAddCelda(VentanaAddCelda vAddCelda) {
		this.vAddCelda = vAddCelda;
		this.vAddCelda.setControl(this);
	}

	/**
	 * el metodo ejecuta comando recive un string que es la ventana que se llamara y el dato que 
	 * intentaremos comunicar con la ventana posterior a la estring 
	 * 
	 * @param c el comando a ejecutar
	 * @param d el tipo de informacion a manejar
	 */
	public void ejecutaComando(String c , Data d) {
		switch(c) {
		 	//abre ala ventana par que podamos ingresar los datos con los que se llenará nuestro tablero
			case "crear":
				//System.out.println(d);
				TallaTablero tTab = (TallaTablero)d;
				tablero = new Tablero(tTab.getTalla());
				this.vAddCelda.setVisible(true);
				break;
			//hacemos visible la ventana de la creacion de el tablero
			case "crearTablero":
				this.vCreacion.setVisible(true);
				break;
			/*tomamos los datos de la celda para que sea mandada obteniendo el color y su numero
			en esta misma mandamos a crear el archivo para ser escritos que son la talla y los
			datos de la celda para ser leidos en otros momentos*/
			case "celda":
				DatosCelda dCel = (DatosCelda)d;
				Celda cel = new Celda();
				cel.setNumero(dCel.getNumero());
				cel.setColor(dCel.getColor());
			try {
				this.tablero.setCelda(cel);
				this.vAddCelda.setVisible(true);
				// se lanza la exepcion de tablero lleno, cuando se llenan las celdas
				} catch (TableroLlenoException e) {
					try {
						this.vTablero = new VentanaTablero(this.tablero);
						//se instancia un tablero y se guardara en un xml para que pueda ser leido
						try {
							fos = new FileOutputStream("tablero.xml");
							codificador = new XMLEncoder(new BufferedOutputStream(fos));
							codificador.writeObject(this.tablero);
							codificador.writeObject(this.tablero.getTalla());
							for(int i=0;i<this.tablero.getTalla();i++) {
								for(int j=0;j<this.tablero.getTalla();j++) {
									codificador.writeObject(this.tablero.getCelda(i, j));
								}
							}
							codificador.close();
						} catch (FileNotFoundException e1) {
							System.out.println("no esta el archivo");
						}
						
						this.vTablero.setSize(tablero.getTalla()*100,tablero.getTalla()*100);;
						this.vTablero.setVisible(true);
					} catch (ColorNoValidoException e1) {
						JOptionPane.showMessageDialog(null, "Error Catastrofico");
					} catch (FueraDeRangoException e1) {
						JOptionPane.showMessageDialog(null, "Error Catastrofico");
					}
				}
				break;
			//se emplea cuando queremos leer un tablero pero no hay nada en su contemido se activa este dialogo y si no nose da visibilidad ala ventana
			case "ctrlDes":
				if(this.vTablero==null) {
					JOptionPane.showMessageDialog(this.vPrincipal,"Debes crear el tablero primero");
				}
				
				this.vTablero.setVisible(true);
				break;
				//se lee el tablero leyendo la talla y la celda del xml castendolos, para enviarlos a las ventanas y volver a crear el tablero automaticamente
			case "leerTablero":
			try {
				fis = new FileInputStream("tablero.xml");
				decodificador = new XMLDecoder(new BufferedInputStream(fis));
				this.tablero = (Tablero) decodificador.readObject();
				int talla = (Integer) decodificador.readObject();
				Celda celds = new Celda();
				this.tablero = new Tablero(talla);
				for(int i=0;i<talla;i++) {
					for(int j=0;j<talla;j++) {
						celds = (Celda) decodificador.readObject();
						this.tablero.setCelda(celds);
					}
				}
				decodificador.close();
			} catch (FileNotFoundException e) {
				System.out.println("No esta el archivo");
			} catch (TableroLlenoException e) {
				try {
					this.vTablero = new VentanaTablero(this.tablero);
					this.vTablero.setSize(this.tablero.getTalla()*100,this.tablero.getTalla()*100);
					//this.vTablero.pack();
				} catch (ColorNoValidoException e1) {
					System.out.println("No deberia estar aqui");
				} catch (FueraDeRangoException e1) {
					System.out.println("No deberia estar aqui");
				}
				this.vTablero.setVisible(true);
			}
				break;
		}
	}
}
