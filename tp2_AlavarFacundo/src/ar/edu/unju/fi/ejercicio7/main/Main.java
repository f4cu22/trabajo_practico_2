package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Producto> productos = cargarProductos();
		Scanner scanner = new Scanner(System.in);
		int opcion;
	do {
		mostrarMenu();
		opcion = leerOpcion(scanner);
		scanner.nextLine(); // Consumir el carácter de nueva línea
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
		}
	}while(opcion!=7);
	scanner.close();
}
	
	private static ArrayList<Producto> cargarProductos() {
    	ArrayList<Producto> productos = new ArrayList<>();
    	productos.add(new Producto("COD001","HELADERA PHILCO",199.9,OrigenFabricacion.ARGENTINA,Categoria.ELECTRHOGAR,true));
		productos.add(new Producto("COD002","MONITOR LG",59.9,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,true));
		productos.add(new Producto("COD003","DESTORNILLADOR PLANO",14.9,OrigenFabricacion.CHILE,Categoria.HERRAMIENTAS,false));
		productos.add(new Producto("COD004","MATE ROBADO",30.1,OrigenFabricacion.URUGUAY,Categoria.TELEFONIA,true));
		productos.add(new Producto("COD005","COCINA PHILCO",199.9,OrigenFabricacion.ARGENTINA,Categoria.ELECTRHOGAR,true));
		productos.add(new Producto("COD006","TECLADO LG",59.9,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,true));
		productos.add(new Producto("COD007","MARTILLO",14.9,OrigenFabricacion.CHILE,Categoria.HERRAMIENTAS,false));
		productos.add(new Producto("COD008","AURICULARES",35.1,OrigenFabricacion.URUGUAY,Categoria.TELEFONIA,true));
		productos.add(new Producto("COD009","MICROONDAS PHILCO",199.9,OrigenFabricacion.ARGENTINA,Categoria.ELECTRHOGAR,true));
		productos.add(new Producto("COD010","MOUSE LG",59.9,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,true));
		productos.add(new Producto("COD011","MARTILLO",14.9,OrigenFabricacion.CHILE,Categoria.HERRAMIENTAS,false));
		productos.add(new Producto("COD012","PROTECTOR DE PANTALLA",30.1,OrigenFabricacion.URUGUAY,Categoria.TELEFONIA,true));
		productos.add(new Producto("COD013","LAVA BAJILLAS",199.9,OrigenFabricacion.ARGENTINA,Categoria.ELECTRHOGAR,true));
		productos.add(new Producto("COD014","AURICULARES DEL XOCAS",59.9,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,true));
		productos.add(new Producto("COD015","DESARMADOR",14.9,OrigenFabricacion.CHILE,Categoria.HERRAMIENTAS,false));
        return productos;
    }
    
	private static void mostrarMenu() {
		System.out.println("Menú:");
		System.out.println("1 – Mostrar productos disponibles");
		System.out.println("2 – Mostrar productos faltantes");
		System.out.println("3 – Incrementar precios de los productos en un 20%");
		System.out.println("4 – Mostrar productos de la categoría Electrohogar disponibles");
		System.out.println("5 – Ordenar productos por precio de forma descendente");
		System.out.println("6 - Mostrar nombres de productos en mayúsculas");
		System.out.println("7 - Salir");
		System.out.print("Seleccione una opción: ");
	}
	
	private static int leerOpcion(Scanner scanner) {
		return scanner.nextInt();
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
	private static void mostrarProductosDisponibles(ArrayList<Producto> productos) {
		Predicate<Producto> disponibles = Producto::getEstado;
        mostrarProductos(productos.stream().filter(disponibles).collect(Collectors.toCollection(ArrayList::new)));
        }
	
	private static void mostrarProductosFaltantes(ArrayList<Producto> productos) {
		Predicate<Producto> faltantes = p -> !p.getEstado();
		mostrarProductos(productos.stream().filter(faltantes).collect(Collectors.toCollection(ArrayList::new)));
	}
	
	private static ArrayList<Producto> incrementarPrecios(ArrayList<Producto> productos){
		// Function para incrementar precios
		productos.forEach(p -> p.setPrecioUnitario(p.getPrecioUnitario() * 1.20));
		return productos;
	}
	private static void mostrarProductosElectrohogarDisponibles(ArrayList<Producto> productos){
		Predicate<Producto> electrohogarDisponibles = p -> p.getCategoria().equals("Electrohogar") && p.getEstado();
		mostrarProductos(productos.stream().filter(electrohogarDisponibles).collect(Collectors.toCollection(ArrayList::new)));
	}
	
	private static void ordenarProductosPorPrecioDescendente(ArrayList<Producto> productos){
		productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
	}
	
	private static void mostrarNombresEnMayusculas(ArrayList<Producto> productos){
		// Function para convertir nombres a mayúsculas y mostrarlos
		Consumer<Producto> imprimirNombreEnMayusculas = p -> System.out.println(p.getDescripcion().toUpperCase());
	    productos.forEach(imprimirNombreEnMayusculas);
	}	
}