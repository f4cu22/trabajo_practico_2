package ar.edu.unju.fi.ejercicio2.constantes;
/**
*constante enum que contiene los meses y maximo de dias
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
public enum Mes {
	ENERO(31), FEBRERO(28), MARZO(31), ABRIL(30), MAYO(31), JUNIO(30), JULIO(31), AGOSTO(31), SEPTIEMBRE(30), OCTUBRE(31), NOVIEMBRE(30), DICIEMBRE(31);
	
	private final int maxDias;

	/**
	 * @param maxDias
	 */
	private Mes(int maxDias) {
		this.maxDias = maxDias;
	}
	
	public int getMaxDias() {
		return maxDias;
	}
}
