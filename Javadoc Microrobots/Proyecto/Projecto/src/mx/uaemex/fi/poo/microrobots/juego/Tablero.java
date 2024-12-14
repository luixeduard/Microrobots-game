package mx.uaemex.fi.poo.microrobots.juego;
/**
 * Clase que crea el tablero de microrobots
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class Tablero {
	private Celda[][] celdas;
	private int talla;
	private int llenos;
	
	/**
	 * Recibe un entero y con este se inicia una matriz de Celdas ademas de que establece talla
	 * @param celxLado Recibe un entero para establecer celdas y talla
	 */
	public Tablero(int celxLado) {
		this.celdas = new Celda[celxLado][celxLado];
		this.talla=celxLado;
	}
	
	/**
	 * Constructora sin parametros de Tablero
	 */
	public Tablero() {
	}
	
	/**
	 * Devuelve una talla con valores solicitados, renglon y columna
	 * @param ren Recibe un entero y lo ubica en una matriz de rango talla
	 * @param col Recibe un entero y lo ubica en una matriz de rango talla
	 * @return Regresa una celda dado ren y col en una matriz de rango talla
	 * @throws FueraDeRangoException En dado caso que se salga del rango de talla salta el error
	 */
	public Celda getCelda(int ren, int col) throws FueraDeRangoException {
		if((ren>(-1) && ren<this.talla) && (col<this.talla && col>(-1))) {
			return this.celdas[ren][col];
		}
		else {
			throw new FueraDeRangoException("Fuera de rango");
		}
	}
	
	/**
	 * Estable una celda en un conjunto determinado de celdas
	 * @param c Recibe una Celda y la guarda en la matriz de celdas
	 * @throws TableroLlenoException En dado caso que llegue al rango de celdas botara error
	 */
	public void setCelda(Celda c) throws TableroLlenoException {
		int i,j;
		for(i=0;i<this.talla;i++) {
			for(j=0;j<this.talla;j++) {
				if(this.celdas[i][j]==null) {
					this.celdas[i][j]=c;
					this.llenos++;
					if(llenos==talla*talla) {
						throw new TableroLlenoException();
					}
					return;
				}
			}
		}
		throw new TableroLlenoException();
	}

	/**
	 * Regresa talla del Tablero
	 * @return Regresa la talla
	 */
	public int getTalla() {
		return talla;
	}
}
