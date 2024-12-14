package mx.uaemex.fi.poo.microrobots.gui;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import mx.uaemex.fi.poo.microrobots.control.ControlGeneral;
import mx.uaemex.fi.poo.microrobots.data.TallaTablero;
import mx.uaemex.fi.poo.microrobots.juego.FueraDeRangoException;

/**
 * Clase donde se crean los botones con los que sabremos la opcion elegida despues de selecionar "crear tablero"
 *y el espiner para hacer un intervalo de seleccion para que no se metan datos erroneos este se incrementa 
 *y decrementa
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class VentanaCrearTablero extends VentanaAbstracta {
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel etq;
	private JSpinner txtFldTalla;
	public static final String ACEPTAR="Aceptar";
	public static final String CANCELAR="Cancelar";
	public static final String TALLA="Talla:";
	
/**
 * Modulo donde se instancian los objetos botones y se les da un comando para ser interpretados en el actionPerformed(ActionEvent)
 * se añaden al panel y se les da sus bordes 
 * @throws HeadlessException Lanzado cuando se llama al código que depende de un teclado, pantalla o mouse en un entorno que no admite un teclado, pantalla o mouse.
 */
	public VentanaCrearTablero() throws HeadlessException {
		super("PotroTablero");
		JPanel panelBtns;
		JPanel panelLaTF;
		this.btnAceptar = new JButton(ACEPTAR);
		this.btnAceptar.setActionCommand(ACEPTAR);
		this.btnAceptar.addActionListener(this);
		
		this.btnCancelar = new JButton(CANCELAR);
		this.btnCancelar.setActionCommand(CANCELAR);
		this.btnCancelar.addActionListener(this);
		
		panelBtns = new JPanel(new GridLayout(1,2));
		panelBtns.setBorder(new EmptyBorder(10,10,10,10));
		
		panelBtns.add(this.btnAceptar);
		panelBtns.add(this.btnCancelar);
		
		this.etq = new JLabel(TALLA);
		
		this.txtFldTalla = new JSpinner();
		this.txtFldTalla.setValue(1);
		
		panelLaTF = new JPanel(new GridLayout(1,2));
		panelLaTF.setBorder(new EmptyBorder(10,10,0,10));
		
		panelLaTF.add(this.etq);
		panelLaTF.add(this.txtFldTalla);
		
		this.getContentPane().add(panelLaTF, BorderLayout.CENTER);
		this.getContentPane().add(panelBtns, BorderLayout.SOUTH);
		this.pack();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * ActionPerformed donde se ejecutan los comandos establecidos para los botones ya preestablecidos cuando se creean
	 * @param e comando a ejecutar en los casos
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch(comando) {
			case ACEPTAR:
				int val = (Integer)this.txtFldTalla.getValue();
				try {
					if(val<1) {
						throw new FueraDeRangoException();
					}
					TallaTablero t = new TallaTablero(val);
					this.control.ejecutaComando("crear", t);
					this.txtFldTalla.setValue(1);
					this.dispose();
					//System.out.println(val);
				}catch(NumberFormatException excep) {
					JOptionPane.showMessageDialog(this,"Solo son aceptados numeros enteros");
				} catch (FueraDeRangoException e1) {
					JOptionPane.showMessageDialog(this,"El valor debe ser mayor o igual a uno");
				}
				
				break;
			case CANCELAR:
				this.txtFldTalla.setValue(1);
				break;
			}
	}

}
