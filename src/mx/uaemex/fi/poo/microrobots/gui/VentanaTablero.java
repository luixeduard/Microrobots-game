package mx.uaemex.fi.poo.microrobots.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mx.uaemex.fi.poo.microrobots.error.ColorNoValidoException;
import mx.uaemex.fi.poo.microrobots.juego.Celda;
import mx.uaemex.fi.poo.microrobots.juego.FueraDeRangoException;
import mx.uaemex.fi.poo.microrobots.juego.Logica;
import mx.uaemex.fi.poo.microrobots.juego.Tablero;
import mx.uaemex.fi.poo.microrobots.juego.UbicacionFalla;
import mx.uaemex.fi.poo.microrobots.juego.UbicacionRobot;
import mx.uaemex.fi.poo.microrobots.juego.juegoReferencia;

/**
 * crea un panel para el tablero con el tamaño de la talla , despues llama al get celda para
 * tener esa celda de esa posicion y despues la añade al panel que se mostrara 
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class VentanaTablero extends JFrame implements ActionListener {
	private Celda celda;
	private int numero, color,italla,jtalla;
	private UbicacionFalla Falla;
	private UbicacionRobot Robot;
	private Logica Lo;
	private int UUi,UUj,URi,URj,UFi,UFj;
	juegoReferencia jue;
	
	/**
	 * Constructora del tablero donde lleva gran parte de recoleccion de datos de las celdas y ubicacion de robot, usuario y falla
	 * @param tablero tablero a leer del juego
	 * @throws ColorNoValidoException Si no esta en el rango de colores saltara la excepcion
	 * @throws FueraDeRangoException Si no esta en el rango de celdas saltara la excepcion
	 */
	public VentanaTablero(Tablero tablero) throws ColorNoValidoException, FueraDeRangoException {
		int talla = tablero.getTalla();
		JPanel panel = new JPanel(new GridLayout(talla,talla));
		Falla = new UbicacionFalla(talla);
		Robot = new UbicacionRobot(talla);
		for(int i=0; i<talla;i++) {
			for(int j=0;j<talla;j++) {
				BotonCelda btn = new BotonCelda(tablero.getCelda(i, j));
				this.celda=tablero.getCelda(i, j);
				this.numero=this.celda.getNumero();
				this.color=this.celda.getColor();
				this.italla=i;
				this.jtalla=j;
				btn.setActionCommand(""+i+"-"+j+""+"."+this.color+"*"+this.numero+"");
				btn.addActionListener(this);
				panel.add(btn);
			}
		}
		this.Lo = new Logica();
		//Obtencion de lugares de robot y falla
		this.URi = Robot.getPosColumna();
		this.URj = Robot.getPosFila();
		this.UFi = Falla.getPosColumna();
		this.UFj = Falla.getPosFila();
		while(Lo.Validar(URi, URj, UFi, UFj)==1) {
			this.URi = Robot.getPosColumna();
			this.URj = Robot.getPosFila();
			this.UFi = Falla.getPosColumna();
			this.UFj = Falla.getPosFila();
		}
		//Obtencion de los datos de la celda
		this.celda=tablero.getCelda(URi, URj);
		this.Lo.setRi(URi);
		this.Lo.setRj(URj);
		this.Lo.setRColor(this.celda.getColor());
		this.Lo.setRNumero(this.celda.getNumero());
		//Obtencion de los datos de la celda
		this.celda=tablero.getCelda(UFi, UFj);
		this.Lo.setFi(UFi);
		this.Lo.setFj(UFj);
		this.Lo.setFColor(this.celda.getColor());
		this.Lo.setFNumero(this.celda.getNumero());
		jue = new juegoReferencia(this.Lo.getRNumero(),this.Lo.getRColor(),this.Lo.getFNumero(),this.Lo.getFColor(),this.Lo.getRi(),this.Lo.getRj(),this.Lo.getFi(),this.Lo.getFj());
		jue.setSize(300,250);
		jue.setVisible(true);
		this.setContentPane(panel);
	}
	
	/**
	 * Convertidor de String a entero
	 * @param n posicion al que termina la subcadena
	 * @param as Comando a seleccionar subcadena
	 * @return entero con la posicion i del comando
	 */
	public int convItalla(int n, String as) {
		String italla;
		italla=as.substring(0, n);
		return Integer.parseInt(italla);
	}
	
	/**
	 * Convertidor de String a entero
	 * @param n posicion del que inicia la subcadena
	 * @param as Comando a seleccionar subcadena
	 * @return entero con la posicion j del comando
	 */
	public int convJtalla(int n, String as) {
		String is;
		is=as.substring(n+1, as.indexOf('.'));
		return Integer.parseInt(is);
	}
	
	/**
	 * Convertidor de String a entero
	 * @param n posicion al empieza la subcadena
	 * @param as Comando a seleccionar subcadena
	 * @return entero con el color del comando
	 */
	public int convColor(int n, String as) {
		String id;
		id=as.substring(n, as.indexOf('*'));
		return Integer.parseInt(id);
	}
	
	/**
	 * Convertidor de String a entero
	 * @param n posicion al que empieza la subcadena
	 * @param as Comando a seleccionar subcadena
	 * @return entero con el valor del comando
	 */
	public int convNumero(int n, String as) {
		String ig;
		ig=as.substring(n, as.length());
		return Integer.parseInt(ig);
	}
	
	/**
	 * actionPerformed con los pasos que hizo el usuario para el tablero y pasarlos a la logica
	 * @param arg0 comando a ejecutar previamente obtenido de la constructora
	 */
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		int usuarioI=0,usuarioJ=0,colorU=0,numeroU=0;
		usuarioI=convItalla(comando.indexOf('-'),comando);
		usuarioJ=convJtalla(comando.indexOf('-'),comando);
		colorU=convColor(comando.indexOf('.')+1,comando);
		numeroU=convNumero(comando.indexOf('*')+1,comando);
		this.Lo.setPosUi(usuarioI);
		this.Lo.setPosUj(usuarioJ);
		this.Lo.setUColor(colorU);
		this.Lo.setUNumero(numeroU);
		try {
			if(this.Lo.validarPaso()==0) {
				this.jue.dispose();
				this.Lo.setRi(this.Lo.getPosUi());
				this.Lo.setRj(this.Lo.getPosUj());
				this.Lo.setRColor(this.Lo.getUColor());
				this.Lo.setRNumero(this.Lo.getUNumero());
			}
		} catch (ColorNoValidoException e) {
			e.printStackTrace();
		} finally {
			jue.dispose();
		}
	}

}
