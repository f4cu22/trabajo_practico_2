package ar.edu.unju.fi.ejercicio3.constantes;
/**
*enum del paquete model que representa constantes de
*las provincias(poblacion, superficie y hace el calculo para la densidad
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
public enum Provincia {
	JUJUY(673307,53219),
	SALTA(1333365,155488),
	TUCUMAN(1696428,226938),
	CATAMARCA(367828,102606),
	LA_RIOJA(331847,89680),
	SANTIAGO_DEL_ESTERO(98245,136351);
	
	private int poblacion;
	private int superficie;
	/**
	 * @param poblacion
	 * @param superficie
	 */
	private Provincia(int poblacion, int superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}
	/**
	 * @return the poblacion
	 */
	public int getPoblacion() {
		return poblacion;
	}
	/**
	 * @param poblacion the poblacion to set
	 */
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	/**
	 * @return the superficie
	 */
	public int getSuperficie() {
		return superficie;
	}
	/**
	 * @param superficie the superficie to set
	 */
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	//Metodo para calcular la densidad
	public double calcularDensidadPoblacional() {
		return(double)poblacion/superficie;
	}
}
