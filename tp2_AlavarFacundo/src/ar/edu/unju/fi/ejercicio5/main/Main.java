package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		//Precargar productos
		ArrayList<Producto> productos = new ArrayList<>();
		productos.add(new Producto("COD001","HELADERA",101.1,OrigenFabricacion.ARGENTINA,Categoria.ELECTRHOGAR,true));
		
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			try {
				opcion=scanner.nextInt();
				switch(opcion) {
				case 1:mostrarProductos(productos);
					break;
				case 2:
					break;
				case 3:
					return;
				default:
					System.out.println("");
				}
			}catch(InputMismatchException e) {
				System.out.println("Por favor ingrese un numero valido.");
				scanner.next();//limpia buffer
				opcion=0;
			}
		}while(opcion!=3);

	}
	
	private static void mostrarProductos(ArrayList<Producto>productos) {
		Consumer<Producto> printConsumer = p-> System.out.println(p);
		productos.forEach(printConsumer);
	}

}
