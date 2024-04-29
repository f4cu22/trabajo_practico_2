package ar.edu.unju.fi.ejercicio4.main;
/**
*Clase main que representa el menu de opciones
*para la subida y modificacion de un jugador
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		int opcion=0;
		do {
			try {
			opcion=mostrarMenu(scanner);
			
			switch (opcion){
				case 1:
					altaJugador(jugadores, scanner);
					break;
				case 2:
					mostrarJugadores(jugadores);
					break;
				case 3:
					modificarJugador(jugadores, scanner);
					break;
				case 4:
					eliminarJugador(jugadores, scanner);
					break;
				case 5:
					System.out.println("Saliendo..");
					break;
				default:
					System.out.println("opcion invalida.");
				}
			}catch(DateTimeParseException e) {
				System.out.println("Error: Formato de fecha incorrecto. Use el formato YYYY-MM-DD.");
			} catch (IllegalArgumentException e) {
				System.out.println("Error: Posición inválida.");
			}catch(InputMismatchException e) {
				System.out.println("Error: por favor, ingrese numero entero.");
				scanner.nextLine();//limpia buffer de entrada
				opcion=0;
			}catch(ConcurrentModificationException e) {
				System.out.println("Error: Modificación concurrente de la lista de jugadores.");
			}
		}while(opcion!=5);
	}
	
	//metodo menu
	private static int mostrarMenu(Scanner scanner) {
		System.out.println("\nMenu de opciones:");
		System.out.println("1 - Alta de jugador");
		System.out.println("2 - Mostrar todos los jugadores");
		System.out.println("3 - Modificar la posicion del jugador");
		System.out.println("4 - Eliminar jugador");
		System.out.println("5 - Salir");
		System.out.println("Ingrese opcion: ");
		return scanner.nextInt();
		
	}
	
	/*
	 * Metodo para el alta al Jugador
	 */
	private static void altaJugador(ArrayList<Jugador>jugadores , Scanner scanner) {
		System.out.println("Alta al jugador...");
		scanner.nextLine(); // Limpiar el buffer de entrada
		
		try {
		//Solicita datos del jugador
		System.out.println("Ingrese nombre del jugador");
		String nombre = scanner.nextLine();
		
		
		System.out.print("Ingrese el apellido del jugador: ");
		String apellido = scanner.nextLine();
		
		System.out.print("Ingrese la fecha de nacimiento del jugador (YYYY-MM-DD): ");
		String fechaNacimientoStr = scanner.nextLine();
		LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
		
		System.out.print("Ingrese la nacionalidad del jugador: ");
		String nacionalidad = scanner.nextLine();
		
		System.out.print("Ingrese la estatura del jugador: ");
		double estatura = scanner.nextDouble();
		
		System.out.print("Ingrese el peso del jugador: ");
		double peso = scanner.nextDouble();
		scanner.nextLine(); // Limpiar el buffer de entrada
		
		System.out.println("Ingrese la posición del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
		String posicionStr = scanner.nextLine();
		Posicion posicion = Posicion.valueOf(posicionStr.toUpperCase());
		
		//Crea el objeto Jugador y se agrega a la lista
		Jugador nuevoJugador= new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
		jugadores.add(nuevoJugador);
		
		System.out.println("Jugador agregado con exito!");
		}catch(DateTimeParseException e) {
			System.out.println("Error: formato de fecha de nacimiento incorrecto. Utilice el formato YYYY-MM-DD.");
		}
		
	}
	/*
	 * metodo para mostrar jugadores
	 */
	private static void mostrarJugadores(ArrayList<Jugador>jugadores) {
		System.out.println("Lista de jugadores: ");
		
		//verifica si hay jugadores
		if (jugadores.isEmpty()) {
			System.out.println("No hay jugadores registrados");
		}else {
			for(Jugador jugador : jugadores) {
				System.out.println("Nombre: "+jugador.getNombre());
				System.out.println("Apellido: "+jugador.getApellido());
				System.out.println("Fecha de nacimiento: "+jugador.getFechaNacimiento());
				System.out.println("Nacionalidad: "+jugador.getNacionalidad());
				System.out.println("Estatura: "+jugador.getEstatura());
				System.out.println("Peso: "+jugador.getPeso());
				System.out.println("Posicion: "+jugador.getPosicion());
				System.out.println("-------------");
				}
		}
	}
	
	/*
	 * metodo para modificar jugador
	 */
	private static void modificarJugador(ArrayList<Jugador>jugadores , Scanner scanner) {
		System.out.println("Modificar jugador..");
		
		try {
			// Solicitar al usuario que ingrese el nombre y apellido del jugador a modificar
			System.out.print("Ingrese el nombre del jugador a modificar: ");
			String nombre = scanner.nextLine();
			
			System.out.print("Ingrese el apellido del jugador a modificar: ");
			String apellido = scanner.nextLine();
			
			//buscar el jugador en la lista
			Jugador jugadorModificado = null;
			for(Jugador jugador : jugadores) {
				if(jugador.getNombre().equals(nombre)&&jugador.getApellido().equals(apellido)) {
					jugadorModificado=jugador;
					break;
				}
			}
			
			//verificar si se encontro el jugador
			if(jugadorModificado!=null) {
				//permitir al usuario la modificacion del jugador
				System.out.println("Ingrese los nuevos datos del jugador: ");
				
				System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
				String fechaNacimientoStr = scanner.nextLine();
				LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
				jugadorModificado.setFechaNacimiento(fechaNacimiento);
				
				System.out.print("Nacionalidad: ");
				jugadorModificado.setNacionalidad(scanner.nextLine());
				
				System.out.print("Estatura: ");
				double estatura = scanner.nextDouble();
				jugadorModificado.setEstatura(estatura);
				
				System.out.print("Peso: ");
				double peso = scanner.nextDouble();
				jugadorModificado.setPeso(peso);
				
				scanner.nextLine(); // Limpiar el buffer de entrada
				
				System.out.println("Posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
				String posicionStr = scanner.nextLine();
				Posicion posicion = Posicion.valueOf(posicionStr.toUpperCase());
				jugadorModificado.setPosicion(posicion);
				
				System.out.println("¡Jugador modificado con éxito!");
			}
		}catch(Exception e) {
			System.out.println("Error al modificar el jugador: "+ e.getMessage());
		}
	}
	/*
	 * metodo para eliminar jugador
	 */
	private static void eliminarJugador(ArrayList<Jugador>jugadores , Scanner scanner) {
		System.out.println("Eliminar jugador...");
		
		try {
			//Solicitar al usuario que ingrese el nombre y el apellido para eliminar jugador
			System.out.print("Ingrese el nombre del jugador a eliminar: ");
			String nombre = scanner.nextLine();
			
			System.out.print("Ingrese el apellido del jugador a eliminar: ");
			String apellido = scanner.nextLine();
			
			// Buscar el jugador en la lista
			Iterator<Jugador> iterator = jugadores.iterator();
			boolean encontrado = false;
			while (iterator.hasNext()) {
				Jugador jugador = iterator.next();
				if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
					iterator.remove();
					encontrado = true;
					break;
				}
			}
			if(encontrado) {
				System.out.println("Jugador eliminado con exito!");
			}else {
				System.out.println("No se encontró un jugador con ese nombre y apellido.");
			}
		}catch(Exception e) {
			System.out.println("Error al eliminar el jugador: " + e.getMessage());
		}
	}
}