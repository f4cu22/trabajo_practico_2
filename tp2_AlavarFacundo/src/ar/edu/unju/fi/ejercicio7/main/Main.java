package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {
	
	public static void main(String[] args) {
	ArrayList<Producto> productos = new ArrayList<>();
	do {
		mostrarMenu();
		int opcion = leerOpcion();
	switch (opcion){
		case 1:
			mostrarProductosDisponibles(productos);
			break;
		case 2:
			mostrarProductosFaltantes(productos);
			break;
		case 3:
			ArrayList<Producto> productosIncrementados = incrementarPrecios(productos);
			mostrarProductos(productosIncrementados);
			break;
		case 4:
			mostrarProductosElectrohogarDisponibles(productos);
			break;
		case 5:
			ordenarProductosPorPrecioDescendente(productos);
			mostrarProductos(productos);
			break;
		case 6:
			mostrarNombresEnMayusculas(productos);
			break;
		default:
			System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
		}while(opcion!=7);
	}
}
	private static void mostrarProductos(ArrayList<Producto> productos){
		//consumer para imprimir cada producto
		Consumer<Producto> imprimirProducto = p -> System.out.println(p);
		
		//contador para seguir la cantidad
		int contador = 0;
		
		//iterar sobre la lista de productos y muestra los 15 primeros
		for (Producto producto : productos) {
			imprimirProducto.accept(producto);
			contador++;
			if(contador==15) {
				break;//sale del bucle
			}
		}
	}
	
	private static void mostrarMenu() {
		System.out.println("");
	}
	
	private static int leerOpcion() {
		Scanner scanner = new Scanner(System.in);
		int opcion = scanner.nextInt();
		return opcion;
	}
	
	private static void mostrarProductosDisponibles(ArrayList<Producto> productos) {
		
	}
	
	private static void mostrarProductosFaltantes(ArrayList<Producto> productos) {
		
	}
	
	private static ArrayList<Producto> incrementarPrecios(ArrayList<Producto> productos){
		
		return null;
	}
	private static void mostrarProductosElectrohogarDisponibles(ArrayList<Producto> productos){
		
	}
	
	private static void ordenarProductosPorPrecioDescendente(ArrayList<Producto> productos){
		
	}
	
	private static void mostrarNombresEnMayusculas(ArrayList<Producto> productos){
		
	}	
}
