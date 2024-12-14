package mx.uaemex.fi.poo.microrobots.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import mx.uaemex.fi.poo.microrobots.control.ControlGeneral;
import mx.uaemex.fi.poo.microrobots.data.DatosCelda;

/**
 * Clase en la que se  crean los jComboBox para que el usuiario solo escoja y no se pueda equibocar y no rompa con los
 * parametros requeridos para la construcion, y los arrays que se le enviaran
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class VentanaAddCelda extends VentanaAbstracta {
	private JComboBox<String> txtNumero;
	private JComboBox<String> txtColor;
	private String[] colores = {"Amarillo","Azul","Blanco","Rojo","Rosa","Verde"};
	private String[] numeros = {"1","2","3","4","5","6"}; 
	
	/**
	 * Se crean las opciones al menu con sus respectivas acciones de los jcombox para la eleccion del usuario
	 * @throws HeadlessException Lanzado cuando se llama al código que depende de un teclado, pantalla o mouse en un entorno que no admite un teclado, pantalla o mouse.
	 */
	public VentanaAddCelda() throws HeadlessException {
		super("Agregar Celda");
		JLabel etq = new JLabel("Numero:");
		JPanel panelCentro = new JPanel(new GridLayout(2,2));
		panelCentro.add(etq);
		
		this.txtNumero = new JComboBox<String>(numeros);
		panelCentro.add(txtNumero);
		
		etq = new JLabel("Color: ");
		panelCentro.add(etq);
		
		this.txtColor = new JComboBox<String>(colores);
		panelCentro.add(txtColor);
		
		panelCentro.setBorder(new EmptyBorder(5,5,5,5));
		
		this.getContentPane().add(panelCentro, BorderLayout.CENTER);
		
		JButton btnAceptar = new JButton("Agregar");
		btnAceptar.setActionCommand("add");
		btnAceptar.addActionListener(this);
		btnAceptar.setBorder(new EmptyBorder(5,5,5,5));
		this.getContentPane().add(btnAceptar, BorderLayout.SOUTH);
		this.pack();
	}
	
	/**
	 * Para cuando se le de click al boton agregar se llenara al indice con los datos que el usuario 
	 * seleciono y si no manda una excepcion de error de numeros que deben ser enteros
	 * @param arg0 dependiendo del actionCommand hara una de los casos enlistados
	 */
	public void actionPerformed(ActionEvent arg0) {
		String comando = arg0.getActionCommand();
		switch(comando) {
		case "add":
			//Lee valores
			try {
				int n= this.txtNumero.getSelectedIndex()+1;
				DatosCelda dC = new DatosCelda(n,this.txtColor.getSelectedIndex()+1);
				this.txtNumero.setSelectedIndex(0);
				this.txtColor.setSelectedIndex(0);
				this.dispose();
				this.control.ejecutaComando("celda", dC);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "El numero deber ser entero");
			}
			break;
		}
	}
	

}
