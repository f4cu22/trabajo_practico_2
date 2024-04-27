package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	private static ArrayList<Efemeride> efemerides = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int opcion = 0 ;
		do {
			mostrarMenu();
			opcion = obtenerOpcion();
			ejecutarOpcion(opcion);
		}while(opcion!=5);

	}
	private static void mostrarMenu() {
		System.out.println("\n");
		System.out.println("1 - Crear Efemeride");
		System.out.println("2 - Mostrar Efemeride");
		System.out.println("3 - Eliminar Efemeride");
		System.out.println("4 - Modificar Efemeride");
		System.out.println("5 - Salir");
		System.out.println("Seleccione una opcion: ");
	}
	
	private static int obtenerOpcion() {
		try {
			return scanner.nextInt();
		}
		catch(InputMismatchException e) {
		System.out.println("Error: Por favor, ingrese un numero valido.");
		scanner.nextLine();//Limpia buffer
		return -1;
		}
	}
	
	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1: crearEfemeride();
		break;
		case 2: mostrarEfemerides();
		break;
		case 3: eliminarEfemeride();
		break;
		case 4: modificarEfemeride();
		break;
		case 5: 
			System.out.println("Saliendo...");
		break;
		default:
			System.out.println("Opcion no valida. Por favor, seleccione una opcion del menu.");
			}
	}
	
	private static void crearEfemeride() {
		
	}
	private static void mostrarEfemerides() {
		
	}
	private static void eliminarEfemeride() {
		
	}
	private static void modificarEfemeride() {
		
	}
	
}
