package ar.edu.unju.fi.ejercicio2.main;
/**
*Clase main que representa el menu de opciones
*para la subida y modificacion de las efemerides
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
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
	/*
	 * Metodo para mostrar el menu
	 */
	private static void mostrarMenu() {
		System.out.println("\n");
		System.out.println("1 - Crear efeméride");
		System.out.println("2 - Mostrar efeméride");
		System.out.println("3 - Eliminar efeméride");
		System.out.println("4 - Modificar efeméride");
		System.out.println("5 - Salir");
		System.out.println("Seleccione una opcion: ");
	}
	
	/*
	 * metodo para obtener opcion
	 */
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
	
	/*
	 * metodo para ejecutar opcion
	 */
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
	
	/*
	 * metodo para crear efemeride
	 */
	private static void crearEfemeride() {
		System.out.println("\nCreando nueva efeméride");
		
		//codigo
		System.out.println("Ingrese el codigo de la efeméride: ");
		String codigo = scanner.next();
		
		//mes y dia
		Mes mes = null;
		boolean datosValidos = false;
		int dia = 0;
		while (!datosValidos) {
	    	try {
	    		System.out.print("Ingrese numero del mes(1-12): ");
	    		//mes
	    		int numeroMes = scanner.nextInt();
	    		if (numeroMes < 1 || numeroMes>12) {
	    			throw new IllegalArgumentException("El numero de mes no esta en rango.");
	    		}
	    		mes = Mes.values()[numeroMes -1];
	    		scanner.nextLine();
	    		//dia
	    		System.out.println("Ingrese el numero del dia para" + mes + ": ");
	    		dia = scanner.nextInt();
	    		if (dia < 1 || dia>mes.getMaxDias()) {
	    			throw new IllegalArgumentException("El numero de dia no esta en rango.");
	    		}
	    		datosValidos = true;
	    		
	            }catch(InputMismatchException e) {
	    		System.out.println("Error: Por favor, ingrese un número válido.");
	            }catch(IllegalArgumentException e) {
	    		System.out.println("Error: " + e.getMessage());
	    		scanner.nextLine();
	    	}
		}
		//Detalle
		scanner.nextLine();//se limpia el buffer
		System.out.println("Ingrese el detalle de efeméride: ");
		String detalle = scanner.nextLine();
		
		//Crear la efeméride y agregarla a la lista
		Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
		efemerides.add(efemeride);
		System.out.println("Efeméride agregada con exito.");
		
	}
	
	/*
	 * metodo para mostrar efemerides
	 */
	private static void mostrarEfemerides() {
		//lista de efemerides
		if(efemerides.isEmpty()) {
			System.out.println("No hay efeméride para mostrar.");
			return;
		}
		System.out.println("Lista de efemérides: ");
		for (Efemeride efemeride : efemerides) {
			System.out.println(efemeride);
		}
	}
	
	/*
	 * metodo para eliminar erfemeride
	 */
	private static void eliminarEfemeride() {
		//lista de efemerides
				if(efemerides.isEmpty()) {
					System.out.println("No hay efeméride para mostrar.");
					return;
				}
				System.out.println("Lista de Efeméride: ");
				for (int i = 0;i < efemerides.size();i++) {
					System.out.println((i+1)+". "+efemerides.get(1));
				}
				
				//solicitar el indice de efemeride a eliminar
				System.out.println("Ingrese el numero de la efeméride que desea eliminar");
				int indice;
				try {
					indice = scanner.nextInt();
					if (indice<1|| indice>efemerides.size()) {
						throw new IllegalArgumentException("El número de efeméride no es válido.");
					}
					
				}catch(InputMismatchException e) {
		    		System.out.println("Error: Por favor, ingrese un número válido.");
		    		scanner.nextLine();//limpiar buffer
		    		return;
		        }catch(IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
				return;
		        }
				//Eliminar la efemeride que corresponde al indice
				Efemeride efemerideEliminada = efemerides.remove(indice-1);
				System.out.println("Efeméride eliminada: " + efemerideEliminada);
	}
	/*
	 * metodo para modificar efemeride
	 */
	private static void modificarEfemeride() {
		if(efemerides.isEmpty()) {
			System.out.println("No hay efeméride para mostrar.");
			return;
		}
		System.out.println("Lista de Efeméride: ");
		for (int i = 0;i < efemerides.size();i++) {
			System.out.println((i+1)+". "+efemerides.get(i));
		}
		
		//solicitar el indice de efemeride a eliminar
		System.out.println("Ingrese el numero de la efeméride que desea modificar");
		int indice;
		try {
			indice = scanner.nextInt();
			if (indice<1|| indice>efemerides.size()) {
				throw new IllegalArgumentException("El número de efeméride no es válido.");
			}
		}catch(InputMismatchException e) {
    		System.out.println("Error: Por favor, ingrese un número válido.");
    		scanner.nextLine();//limpiar buffer
    		return;
        }catch(IllegalArgumentException e) {
		System.out.println("Error: " + e.getMessage());
		return;
        }
		
		Efemeride efemerideAModificar = efemerides.get(indice -1);
		
		System.out.println("Detalles de la efeméride a modificar: ");
		System.out.println(efemerideAModificar);
		
		//opciones de modificacion
		System.out.println("Seleccione atributo que desea modificar: ");
		System.out.println("1 - Codigo.");
		System.out.println("2 - mes.");
		System.out.println("3 - dia.");
		System.out.println("4 - detalle.");
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
		
		//switch para la opcion de modificacion
		switch(opcionModificacion){
			case 1:
				//nuevo codigo
				System.out.println("Ingrese el nuevo codigo: ");
				String nuevoCodigo = scanner.nextLine();
				efemerideAModificar.setCodigo(nuevoCodigo);
				break;
			case 2:
				//nuevo mes
				boolean mesValido = false;
				while(!mesValido) {
			    	try {
			    		System.out.print("Ingrese el nuevo mes: ");
			    		int nuevoMesIndex = scanner.nextInt();
			    		scanner.nextLine(); // Limpia el buffer de entrada
			    		if (nuevoMesIndex <= 0 || nuevoMesIndex>12) {
			    		throw new IllegalArgumentException("El mes no esta en rango.");
			            }
			    		
			    		Mes nuevoMes = Mes.values()[nuevoMesIndex-1];
			    		efemerideAModificar.setMes(nuevoMes);
			            mesValido = true;
			    	}catch(InputMismatchException e) {
			    		System.out.println("Error: Por favor, ingrese un número válido.");
			    		scanner.nextLine(); // Limpia el buffer
			    	}catch(IllegalArgumentException e) {
			    		System.out.println("Error: " + e.getMessage());
			    	}
				}
				break;
			case 3:
				//nuevo dia
				Mes mes = efemerideAModificar.getMes();
				boolean diaValido = false;
				while(!diaValido) {
			    	try {
			    		System.out.print("Ingrese el nuevo dia: ");
			    		int nuevoDia = scanner.nextInt();
			    		scanner.nextLine(); // Limpia el buffer de entrada
			    		if (nuevoDia <= 0 || nuevoDia>mes.getMaxDias()) {
			    		throw new IllegalArgumentException("El dia no esta en rango.");
			            }
			    		efemerideAModificar.setDia(nuevoDia);
			            diaValido = true;
			    	}catch(InputMismatchException e) {
			    		System.out.println("Error: Por favor, ingrese un número válido.");
			    		scanner.nextLine(); // Limpia el buffer
			    	}catch(IllegalArgumentException e) {
			    		System.out.println("Error: " + e.getMessage());
			    	}
				}
				break;
			case 4:
				//nuevo detalle
				System.out.println("Ingrese el nuevo detalle: ");
				String nuevoDetalle = scanner.nextLine();
				efemerideAModificar.setDetalle(nuevoDetalle);
				break;
			case 5:
				//se cancela
				System.out.println("Cancelando la modificacion del producto");
				break;
			}
		System.out.println("Efemeride modificada con exito");
	}
	
}
