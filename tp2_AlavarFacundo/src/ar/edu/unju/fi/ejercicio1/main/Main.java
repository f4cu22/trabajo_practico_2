package ar.edu.unju.fi.ejercicio1.main;
/**
*Clase main que representa el menu de opciones
*para la subida y modificacion de un producto
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.*;

public class Main {
	private static ArrayList<Producto> productos = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		do {
			/*
			 * Mostrar menu de opciones
			 */
			System.out.println("\nMenu de opciones: ");
			System.out.println("1 - Crear Producto");
			System.out.println("2 - Mostrar Productos");
			System.out.println("3 - Modificar producto");
			System.out.println("4 - Salir");
			System.out.println("Seleccione una opcion: ");
			
			/*
			 * 
			 */
			try {
				opcion = scanner.nextInt();
				scanner.nextLine(); //Limpia buffer de entrada
			}catch(InputMismatchException e){
				System.out.println("Por favor, ingrese numero valido");
				scanner.nextLine(); //Limpia buffer de entrada
				continue;
			}
			
			/*
			 * 
			 */
			switch (opcion) {
            case 1:
                crearProducto(scanner);
                break;
            case 2:
                mostrarProductos();
                break;
            case 3:
                modificarProducto(scanner);
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
			}
		}while(opcion !=4);
		scanner.close();
	}
	
	/*
	 * Metodo para crear nuevo producto
	 */
	private static void crearProducto(Scanner scanner) {

		System.out.println("Creando nuevo producto");
			
		//toma y valida el codigo
		System.out.println("Ingrese codigo del producto: ");
		String codigo = scanner.nextLine();
		
		// toma y valida descripcion
		System.out.print("Ingrese la descripción del producto: ");
		String descripcion = scanner.nextLine();
		
		//toma y validar el precio unitario
		double precioUnitario = 0;
		boolean precioValido = false;
	    while(!precioValido) {
	    	try {
	    		System.out.print("Ingrese el precio unitario del producto: ");
	    		precioUnitario = scanner.nextDouble();
	    		scanner.nextLine(); // Limpia el buffer de entrada
	    		if (precioUnitario <= 0) {
	    		throw new IllegalArgumentException("El precio unitario debe ser mayor que cero.");
	            }
	            precioValido = true;
	    	}catch(InputMismatchException e) {
	    		System.out.println("Error: Por favor, ingrese un número válido.");
	    	}catch(IllegalArgumentException e) {
	    		System.out.println("Error: " + e.getMessage());
	    	}
	    }
	    
	    //toma y valida el origen de fabricacion
	    OrigenFabricacion origenFabricacion = null;
	    boolean origenValido = false;
	    while(!origenValido) {
	    	try {
	    		System.out.println("---- Origen de fabricacion ----");
	    		System.out.println("1 - ARGENTINA");
	    		System.out.println("2 - CHINA");
	    		System.out.println("3 - BRASIL");
	    		System.out.println("4 - URUGUAY");
	    		System.out.println("Eliga una opcion: ");
	    		int opcion = scanner.nextInt();
	    		scanner.nextLine();//limpia buffer de entrada
	    		origenFabricacion = OrigenFabricacion.values()[opcion-1];
	    		origenValido=true;
	    	}catch(InputMismatchException | ArrayIndexOutOfBoundsException e){
	    		System.out.println("Error: porfavor, ingrese opcion valida");
	    		scanner.nextLine();//limpia buffer de entrada	    	
	    		}
	    }
	    
	  //toma y valida categoria
	    Categoria categoria = null;
	    boolean categoriaValida = false;
	    while(!categoriaValida) {
	    	try {
	    		System.out.println("---- Categoria ----");
	    		System.out.println("1 - Telefonia");
	    		System.out.println("2 - Informatica");
	    		System.out.println("3 - Electro Hogar");
	    		System.out.println("4 - Herramientas");
	    		System.out.println("Eliga una opcion: ");
	    		int opcion = scanner.nextInt();
	    		scanner.nextLine();//limpia buffer de entrada
	    		categoria = Categoria.values()[opcion-1];
	    		categoriaValida=true;
	    	}catch(InputMismatchException | ArrayIndexOutOfBoundsException e){
	    		System.out.println("Error: porfavor, ingrese opcion valida");
	    		scanner.nextLine();//limpia buffer de entrada	    	
	    		}
	    }
	    
	    //crear el producto y agregarlo a la lista
	    Producto producto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
	    productos.add(producto);
	    System.out.println("Producto agregado exitosamente. ");  
	}
	
	/*
	 * metodo para mostrar productos
	 */
	private static void mostrarProductos() {
		if(productos.isEmpty()) {
			System.out.println("No hay productos para mostrar.");
			return;
		}
		System.out.println("Lista de productos: ");
		for (Producto producto : productos) {
			System.out.println(producto);
		}
	}
	
	/*
	 * metodo para modificar un producto existente
	 */
	private static void modificarProducto(Scanner scanner) {
		if(productos.isEmpty()) {
			System.out.println("No hay productos para modificar.");
			return;
		}
		System.out.println("Lista de productos");
		for(int i=0;i<productos.size();i++) {
			System.out.println((i+1)+". "+productos.get(i));
		}
		
		int indiceProducto;
		do {
			try {
	    		System.out.print("Ingrese el numero del producto que desea modificar: ");
	    		indiceProducto = scanner.nextInt();
	    		scanner.nextLine(); // Limpia el buffer de entrada
	    		if (indiceProducto < 1 || indiceProducto > productos.size()) {
	    		throw new IllegalArgumentException("El precio unitario debe ser mayor que cero.");
	            }
	            break;
	    	}catch(InputMismatchException e) {
	    		System.out.println("Error: Por favor, ingrese un número válido.");
	    		scanner.nextLine();//limpia buffer de entrada
	    	}catch(IllegalArgumentException e) {
	    		System.out.println("Error: " + e.getMessage());
	    	}
		}while(true);
		
		Producto productoSeleccionado = productos.get(indiceProducto -1);
		
		System.out.println("Producto seleccionado: "+ productoSeleccionado);
		
		//opciones de modificacion
		System.out.println("Seleccione atributo que desea modificar: ");
		System.out.println("1 - Descripcion.");
		System.out.println("2 - Precio unitario.");
		System.out.println("3 - Origen de fabricacion.");
		System.out.println("4 - Categoria.");
		System.out.println("5 - Cancelar.");
		System.out.println("Elija una opcion: ");
		
		int opcionModificacion;
		do {
			try {
	    		opcionModificacion = scanner.nextInt();
	    		scanner.nextLine(); // Limpia el buffer de entrada
	    		if (opcionModificacion < 1 || opcionModificacion >5) {
	    		throw new IllegalArgumentException("Ingrese opcion valida");
	            }
	            break;
	    	}catch(InputMismatchException e) {
	    		System.out.println("Error: Por favor, ingrese un número válido.");
	    		scanner.nextLine();//limpia buffer de entrada
	    	}catch(IllegalArgumentException e) {
	    		System.out.println("Error: " + e.getMessage());
	    	}
		}while(true);
		
		switch(opcionModificacion){
			case 1:
				System.out.println("Ingrese la nueva descripcion: ");
				String nuevaDescripcion = scanner.nextLine();
				productoSeleccionado.setDescripcion(nuevaDescripcion);
				break;
			case 2:
				boolean precioValido = false;
				while(!precioValido) {
			    	try {
			    		System.out.print("Ingrese el precio unitario del producto: ");
			    		double nuevoPrecioUnitario = scanner.nextDouble();
			    		scanner.nextLine(); // Limpia el buffer de entrada
			    		if (nuevoPrecioUnitario <= 0) {
			    		throw new IllegalArgumentException("El precio unitario debe ser mayor que cero.");
			            }
			    		productoSeleccionado.setPrecioUnitario(nuevoPrecioUnitario);
			            precioValido = true;
			    	}catch(InputMismatchException e) {
			    		System.out.println("Error: Por favor, ingrese un número válido.");
			    	}catch(IllegalArgumentException e) {
			    		System.out.println("Error: " + e.getMessage());
			    	}
				}
				break;
			case 3:
				OrigenFabricacion nuevoOrigen = seleccionarOrigen(scanner);
				productoSeleccionado.setOrigenFabricacion(nuevoOrigen);
				break;
			case 4:
				Categoria nuevaCategoria = seleccionarCategoria(scanner);
				productoSeleccionado.setCategoria(nuevaCategoria);
				break;
			case 5:
				System.out.println("Cancelando la modificacion del producto");
				break;
			}
		}
	/*
	 * metodo para 
	 * seleccionar origen
	 */
	public static OrigenFabricacion seleccionarOrigen(Scanner scanner) {
		OrigenFabricacion nuevoOrigen = null;
	    boolean origenValido = false;
	    while(!origenValido) {
	    	try {
	    		System.out.println("---- Origen de fabricacion ----");
	    		System.out.println("1 - ARGENTINA");
	    		System.out.println("2 - CHINA");
	    		System.out.println("3 - BRASIL");
	    		System.out.println("4 - URUGUAY");
	    		System.out.println("Eliga una opcion: ");
	    		int opcion = scanner.nextInt();
	    		scanner.nextLine();//limpia buffer de entrada
	    		nuevoOrigen = OrigenFabricacion.values()[opcion-1];
	    		origenValido=true;
	    	}catch(InputMismatchException | ArrayIndexOutOfBoundsException e){
	    		System.out.println("Error: porfavor, ingrese opcion valida");
	    		scanner.nextLine();//limpia buffer de entrada	    	
	    		}
	    }
		return nuevoOrigen;
	}
	
	/*
	 * metodo para 
	 * seleccionar categoria
	 */
	public static Categoria seleccionarCategoria(Scanner scanner) {
		Categoria nuevaCategoria = null;
	    boolean categoriaValida = false;
	    while(!categoriaValida) {
	    	try {
	    		System.out.println("---- Categoria ----");
	    		System.out.println("1 - Telefonia");
	    		System.out.println("2 - Informatica");
	    		System.out.println("3 - Electro Hogar");
	    		System.out.println("4 - Herramientas");
	    		System.out.println("Eliga una opcion: ");
	    		int opcion = scanner.nextInt();
	    		scanner.nextLine();//limpia buffer de entrada
	    		nuevaCategoria = Categoria.values()[opcion-1];
	    		categoriaValida=true;
	    	}catch(InputMismatchException | ArrayIndexOutOfBoundsException e){
	    		System.out.println("Error: porfavor, ingrese opcion valida");
	    		scanner.nextLine();//limpia buffer de entrada	    	
	    		}
	    }
		return nuevaCategoria;
	}
	
	}
