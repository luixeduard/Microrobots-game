package mx.uaemex.fi.poo.microrobots.juego;

/**
 * Clase que entrega una exception de tipo tablero lleno
 * @author Luis Eduardo Salas Hernandez
 * @author Salvador Aranza Gasca
 * @author Aaron Lara Valdes
 * @author Jesus Jeovanni Flores Zarza
 */
public class TableroLlenoException extends Exception {
	/**
	 * Construye una nueva excepción con Null en el mensaje de detalle especificado
	 */
	public TableroLlenoException() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Construye una nueva excepción con el mensaje de detalle 
	 * @param arg0 El mensaje detallado (que se guarda para la recuperación posterior por el método Throwable. getMessage ()).
	 */
	public TableroLlenoException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Construye una nueva excepción con la causa especificada y un mensaje de detalle de (causa = = null? NULL: cause. ToString ()) (que normalmente contiene el mensaje de clase y detalle de causa).
	 * @param arg0 La causa (que se guarda para la recuperación posterior por el método Throwable. getCause ()). (se permite un valor nulo e indica que la causa es inexistente o desconocida.)
	 */
	public TableroLlenoException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Construye una nueva excepción con el mensaje de detalle y la causa especificados.
	 * @param arg0 El mensaje detallado (que se guarda para la recuperación posterior por el método Throwable. getMessage ()).
	 * @param arg1 La causa (que se guarda para la recuperación posterior por el método Throwable. getCause ()). (se permite un valor nulo e indica que la causa es inexistente o desconocida.)
	 */
	public TableroLlenoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construye una nueva excepción con el mensaje de detalle especificado, causa, Suppression activada o deshabilitada, y la escritura del StackTrace habilitado o deshabilitado.
	 * @param arg0 El mensaje detallado
	 * @param arg1 La causa (que se guarda para la recuperación posterior por el método Throwable. getCause ()). (se permite un valor nulo e indica que la causa es inexistente o desconocida.)
	 * @param arg2 Si o no la supresión está activada o deshabilitada
	 * @param arg3 Si el rastreo de la pila debe escribirse o no
	 */
	public TableroLlenoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
