package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private double montoPagado;
	private LocalDate fechaPago;
	
	/**
	 * @param montoPagado
	 * @param fechaPago
	 */
	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		super();
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	/*
	 * Implementacion de los metodos de la interfaz Pago
	 */
	@Override
	public void realizarPago(double monto) {
		this.montoPagado-=monto* 0.10;

	}

	@Override
	public void imprimirRecibo() {
		//Muestra informacion del pago en efectivo
		System.out.println("Monto de pago: "+fechaPago);
		System.out.println("Fecha de pago: "+montoPagado);
	}

	/**
	 * @return the montoPagado
	 */
	public double getMontoPagado() {
		return montoPagado;
	}

	/**
	 * @param montoPagado the montoPagado to set
	 */
	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	/**
	 * @return the fechaPago
	 */
	public LocalDate getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	

}
