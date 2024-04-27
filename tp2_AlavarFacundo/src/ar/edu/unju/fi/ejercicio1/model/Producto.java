package ar.edu.unju.fi.ejercicio1.model;
/**
*Clase Producto que representa
*el producto para un menu
*con opciones.
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
public class Producto {
	private String codigo;
	private String descripcion;
	private double precioUnitario;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	
	public enum OrigenFabricacion{
		ARGENTINA,CHILE,BRASIL,URUGUAY;
	}
	
	public enum Categoria{
		TELEFONIA,INFORMATICA,ELECTRHOGAR,HERRAMIENTAS;
	}

	
	
	/**
	 * @param codigo
	 * @param descripcion
	 * @param precioUnitario
	 * @param origenFabricacion
	 * @param categoria
	 */
	public Producto(String codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the precioUnitario
	 */
	public double getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	/**
	 * @return the origenFabricacion
	 */
	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	/**
	 * @param origenFabricacion the origenFabricacion to set
	 */
	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto " +
				"Código: '" + codigo + '\'' +
				", Descripción: '" + descripcion + '\'' +
				", Precio unitario: $" + precioUnitario +
				", Origen de fabricación: " + origenFabricacion +
				", Categoría: " + categoria +
				'.';
	}
	
	
	
}
