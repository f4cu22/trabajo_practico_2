package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	
	/**
	 * @param numeroTarjeta
	 * @param fechaPago
	 * @param montoPagado
	 */
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}
	/*
	 * Implementacion de los metodos de la interfaz Pago
	 */
	@Override
	public void realizarPago(double monto) {
		this.montoPagado+=monto*1.15;

	}

	@Override
	public void imprimirRecibo() {
		// Muestra la información del pago con tarjeta
		System.out.println("Numero de tarjeta: "+numeroTarjeta);
		System.out.println("Monto de pago: "+fechaPago);
		System.out.println("Fecha de pago: "+montoPagado);
	}

	
	//Getters y setters
	/**
	 * @return the numeroTarjeta
	 */
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	/**
	 * @param numeroTarjeta the numeroTarjeta to set
	 */
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
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
	
}
