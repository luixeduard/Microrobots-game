package mx.uaemex.fi.poo.microrobots.juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.uaemex.fi.poo.microrobots.error.ColorNoValidoException;
import mx.uaemex.fi.poo.microrobots.gui.BotonCelda;

/**
 * Clase que hace una ventana con 4 elementos, imagen del robot, su posicion del mismo, imagen de la falla y posicion del mismo
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class juegoReferencia extends JFrame implements ActionListener{
	public static final int ROJO=4;
	public static final int AZUL=2;
	public static final int VERDE=6;
	public static final int AMARILLO=1;
	public static final int ROSA=5;
	public static final int BLANCO=3;
	public JButton robotImagen;
	public JButton fallaImagen;
	
	/**
	 * Constructora para crear el panel de referencia para que el jugador se guie
	 * @param numeroR El valor entero numerico del robot
	 * @param colorR El valor entero numerico del color del robot
	 * @param numeroF El valor entero numerico de la falla
	 * @param colorF El valor entero numerico del color de la falla
	 * @param i indice de coordenadas del panel
	 * @param j indice de coordenadas del panel
	 * @param k indice de coordenadas del panel
	 * @param l indice de coordenadas del panel
	 * @throws ColorNoValidoException Si tuviese un error equivoco salta la excepcion
	 */
	public juegoReferencia(int numeroR, int colorR, int numeroF, int colorF, int i, int j, int k, int l) throws ColorNoValidoException{
			JPanel panel = new JPanel(new GridLayout(2,2));	
			Icon icono = new ImageIcon(""+numeroR+"R.png");
			robotImagen = new JButton();
			robotImagen.setBackground(this.getColor(colorR));
			robotImagen.setIcon(icono);
			robotImagen.setSize(100,100);
			JLabel robot = new JLabel("Robot\n Posicion:\t["+i+"]["+j+"]");
			robot.setSize(300,100);
			panel.add(robotImagen);
			panel.add(robot);
			Icon ico = new ImageIcon(""+numeroF+"F.png");
			fallaImagen = new JButton();
			fallaImagen.setBackground(this.getColor(colorF));
			fallaImagen.setIcon(ico);
			fallaImagen.setSize(100,100);
			JLabel falla = new JLabel("Falla\n Posicion:\t["+k+"]["+l+"]");
			falla.setSize(300,100);
			panel.add(fallaImagen);
			panel.add(falla);
			this.getContentPane().add(panel,BorderLayout.CENTER);
	}
	
	/**
	 * Modulo en el que dependiendo de un numero devuelve su color
	 * @param color Valor entero numerico del color
	 * @return regresa el color ya sea el caso
	 * @throws ColorNoValidoException
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
