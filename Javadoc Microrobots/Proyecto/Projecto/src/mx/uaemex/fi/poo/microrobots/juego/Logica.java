package mx.uaemex.fi.poo.microrobots.juego;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mx.uaemex.fi.poo.microrobots.error.ColorNoValidoException;

/**
 * Logica del juego Microrobots
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class Logica {
	private int Ri, Rj, RColor,RNumero;
	private int Fi, Fj, FColor,FNumero;
	private int PosUi, PosUj, UColor, UNumero;
	juegoReferencia juegos;
	
	/**
	 * Constructora sin parametros
	 */
	public Logica() {	
	}

	/**
	 * Valida si no esta el robot justo en la falla en el inicio
	 * @param a1 Posicion del robot i
	 * @param b1 Posicion del robot j
	 * @param a2 Posicion de la falla i
	 * @param b2 Posicion de la falla j
	 * @return Si se encuentra o no en la misma posicion robot y falla 
	 */
	public int Validar(int a1, int b1, int a2, int b2){
		if(a1==a2 && b1==b2) {
			return 1;
		}
		return 0;
	}
	
	/**
	 * Modulo donde se valida si un movimiento hecho por el usuario es valido y actualiza la posicion del robot
	 * @return Si es un movimiento valido devuelve 0 en caso contrario 1
	 * @throws ColorNoValidoException regresa un error en el color
	 */
	public int validarPaso() throws ColorNoValidoException {
		this.juegos=new juegoReferencia(this.RNumero,this.RColor,this.FNumero,this.FColor,this.Ri,this.Rj,this.Fi,this.Fj);
		juegos.setSize(300,250);
		this.juegos.setVisible(true);
		if(this.PosUi!=this.Ri && this.PosUj!=this.Rj) {
			JOptionPane.showMessageDialog(null, "Nel");
			return 1;
		}
		if(this.UColor!=this.RColor && this.UNumero !=this.RNumero) {
			JOptionPane.showMessageDialog(null, "Nel prro :v");
			return 1;
		}
		else {
			juegos.dispose();
			this.juegos=new juegoReferencia(this.UNumero,this.UColor,this.FNumero,this.FColor,this.Ri,this.Rj,this.Fi,this.Fj);
			juegos.setSize(300,250);
			this.juegos.setVisible(true);
		}
		if(this.UColor==this.FColor && this.UNumero==this.FNumero) {
			JOptionPane.showMessageDialog(null, "Ganaste |:v|");
			return 0;
		}
		return 0;
	}

	/**
	 * Devuelve la posicion del robot
	 * @return posicion i del robot
	 */
	public int getRi() {
		return Ri;
	}
	
	/**
	 * Establece la posicion del robot
	 * @param ri posicion i del robot
	 */
	public void setRi(int ri) {
		Ri = ri;
	}
	
	/**
	 * Devuelve la posicion del robot
	 * @return posicion j del robot
	 */
	public int getRj() {
		return Rj;
	}

	/**
	 * Establece la posicion del robot
	 * @param rj posicion j del robot
	 */
	public void setRj(int rj) {
		Rj = rj;
	}

	/**
	 * Devuelve el color del robot
	 * @return color del robot
	 */
	public int getRColor() {
		return RColor;
	}

	/**
	 * Establece el color del robot
	 * @param rColor del robot
	 */
	public void setRColor(int rColor) {
		RColor = rColor;
	}
	
	/**
	 * Devuelve el numero del robot
	 * @return el numero del robot
	 */
	public int getRNumero() {
		return RNumero;
	}

	/**
	 * Establece el numero del robot
	 * @param rNumero numero del robot
	 */
	public void setRNumero(int rNumero) {
		RNumero = rNumero;
	}

	/**
	 * Devuelve la posicion de la falla
	 * @return posicion i del robot
	 */
	public int getFi() {
		return Fi;
	}
	
	/**
	 * Establece la posicion de la falla
	 * @param fi posicion i de la falla
	 */
	public void setFi(int fi) {
		Fi = fi;
	}

	/**
	 * Devuelve la posicion de la falla
	 * @return posicion j de la falla
	 */
	public int getFj() {
		return Fj;
	}

	/**
	 * Establece la posicion de la falla
	 * @param fj posicion j de la falla
	 */
	public void setFj(int fj) {
		Fj = fj;
	}

	/**
	 * Devuelve el color de la falla
	 * @return color de la falla
	 */
	public int getFColor() {
		return FColor;
	}

	/**
	 * Establece el color de la falla
	 * @param fColor color de la falla
	 */
	public void setFColor(int fColor) {
		FColor = fColor;
	}

	/**
	 * Devuelve el numero de la falla
	 * @return el numero de la falla
	 */
	public int getFNumero() {
		return FNumero;
	}
	
	/**
	 * Establece el numero de la falla
	 * @param fNumero de la falla
	 */
	public void setFNumero(int fNumero) {
		FNumero = fNumero;
	}

	/**
	 * Devuelve la posicion del usuario
	 * @return posicion i del usuario
	 */
	public int getPosUi() {
		return PosUi;
	}

	/**
	 * Establece la posicion del usuario
	 * @param posUi posicion i del usuario
	 */
	public void setPosUi(int posUi) {
		PosUi = posUi;
	}

	/**
	 * Devuelve la posicion del usuario
	 * @return posicion j del usuario
	 */
	public int getPosUj() {
		return PosUj;
	}

	/**
	 * Establece la posicion del usuario
	 * @param posUj posicion j del usuario
	 */
	public void setPosUj(int posUj) {
		PosUj = posUj;
	}

	/**
	 * Devuelve el color del usuario
	 * @return color del usuario
	 */
	public int getUColor() {
		return UColor;
	}

	/**
	 * Establece el color del usuario
	 * @param uColor color del usuario
	 */
	public void setUColor(int uColor) {
		UColor = uColor;
	}

	/**
	 * Devuelve el numero del usuario
	 * @return el numero del usuario
	 */
	public int getUNumero() {
		return UNumero;
	}

	/**
	 * Establece el numero de la falla
	 * @param uNumero de la falla
	 */
	public void setUNumero(int uNumero) {
		UNumero = uNumero;
	}
	
}
