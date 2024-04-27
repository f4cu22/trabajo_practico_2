package ar.edu.unju.fi.ejercicio2.model;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;

public class Efemeride {
	private String codigo;
	private Mes mes;
	private int dia;
	private String detalle;
	/**
	 * @param codigo
	 * @param mes
	 * @param dia
	 * @param detalle
	 */
	public Efemeride(String codigo, Mes mes, int dia, String detalle) {
		super();
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the mes
	 */
	public Mes getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(Mes mes) {
		this.mes = mes;
	}
	/**
	 * @return the dia
	 */
	public int getDia() {
		return dia;
	}
	/**
	 * @param dia the dia to set
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}
	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	@Override
	public String toString() {
		return "Efemeride [codigo=" + codigo + ", mes=" + mes + ", dia=" + dia + ", detalle=" + detalle + "]";
	}
	
	
}
