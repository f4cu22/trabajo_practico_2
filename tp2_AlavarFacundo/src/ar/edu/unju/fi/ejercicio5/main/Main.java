package ar.edu.unju.fi.ejercicio5.main;
/**
*Clase main que representa el menu de opciones
*para la subida y modificacion de un producto
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

public class Main {

	public static void main(String[] args) {
		//Precargar productos
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
		productos.add(new Producto("COD016","CARCASA DE CELULAR",35.1,OrigenFabricacion.URUGUAY,Categoria.TELEFONIA,true));
		productos.add(new Producto("COD017","HELADERA PHILCO",199.9,OrigenFabricacion.ARGENTINA,Categoria.ELECTRHOGAR,true));
		productos.add(new Producto("COD018","MONITOR LG",59.9,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,true));
		productos.add(new Producto("COD019","DESTORNILLADOR PLANO",14.9,OrigenFabricacion.CHILE,Categoria.HERRAMIENTAS,false));
		productos.add(new Producto("COD020","APOYADOR DE CELULAR",30.1,OrigenFabricacion.URUGUAY,Categoria.TELEFONIA,true));
		productos.add(new Producto("COD021","MINI PIMER PHILCO",199.9,OrigenFabricacion.ARGENTINA,Categoria.ELECTRHOGAR,true));
		productos.add(new Producto("COD022","MOUSE PAD KOI",59.9,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,true));
		productos.add(new Producto("COD023","LLAVE FRANCESA",14.9,OrigenFabricacion.CHILE,Categoria.HERRAMIENTAS,false));
		productos.add(new Producto("COD024","AURICULARES SAMSUNG",35.1,OrigenFabricacion.URUGUAY,Categoria.TELEFONIA,true));
		productos.add(new Producto("COD025","ESTUFA",199.9,OrigenFabricacion.ARGENTINA,Categoria.ELECTRHOGAR,true));
		productos.add(new Producto("COD026","SILLLA GAMER",59.9,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,true));
		productos.add(new Producto("COD027","GANZUA",14.9,OrigenFabricacion.CHILE,Categoria.HERRAMIENTAS,false));
		productos.add(new Producto("COD028","PARLANTE JBL",30.1,OrigenFabricacion.URUGUAY,Categoria.TELEFONIA,true));
		productos.add(new Producto("COD029","TV 32'",199.9,OrigenFabricacion.ARGENTINA,Categoria.ELECTRHOGAR,true));
		productos.add(new Producto("COD030","AURICULARES",59.9,OrigenFabricacion.BRASIL,Categoria.INFORMATICA,true));
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			try {
				opcion=scanner.nextInt();
				switch(opcion) {
				case 1:mostrarProductos(productos);
					break;
				case 2:
					realizarCompra(productos);
					break;
				case 3:
					System.out.println("Saliendo del programa");
					return;
				default:
					System.out.println("Opcion invalida");
				}
			}catch(InputMismatchException e) {
				System.out.println("Por favor ingrese un numero valido.");
				scanner.next();//limpia buffer
				opcion=0;
			}
		}while(opcion!=3);
		scanner.close();
	}
	/*
	 * metodo para mostrar productos
	 *  usando consumer
	 */
	private static void mostrarProductos(ArrayList<Producto>productos) {
		Consumer<Producto> printConsumer = p-> System.out.println(p);
		productos.forEach(printConsumer);
	}
	
	/*
	 * metodfo usado para realizar compra
	 * (en tarjeta o pago efectivo)
	 */
	private static void realizarCompra(ArrayList<Producto>productos) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Producto> productosComprados= new ArrayList<>();
		double total = 0.0;
		mostrarProductos(productos);
		int opcion;
		try {
			do {
				System.out.println("Ingrese numero de producto que desea comprar(0 para finalizar): ");
				opcion = scanner.nextInt();
				if(opcion>=1 && opcion <=productos.size()) {
					Producto producto= productos.get(opcion-1);
					if(producto.getEstado()) {
						productosComprados.add(producto);
						total += producto.getPrecioUnitario();
						producto.setEstado(false);
						System.out.println("Producto agregado al carrito.");
					}else {
						System.out.println("El producto seleccionado no esta disponible. ");
					}
				}else if (opcion!=0){
					System.out.println("Opción inválida. Por favor, seleccione un número de producto válido.");
					return;
				}
			}while (opcion!=0);
			
			if(productosComprados.isEmpty()) {
				System.out.println("No se han seleccionado productos para comprar.");
			}
			
			int opcionPago;
			do {
				System.out.println("Seleccione el metodo de pago: ");
				System.out.println("1 - Pago efectivo.");
				System.out.println("2 - Pago con tarjeta: ");
				System.out.println("Ingrese su opcion: ");
				opcionPago = scanner.nextInt();
				if (opcionPago==1) {
					//pago efectivo
					PagoEfectivo pagoEfectivo = new PagoEfectivo(total, LocalDate.now());
					pagoEfectivo.realizarPago(total);
					pagoEfectivo.imprimirRecibo();
				}else if(opcionPago==2){
					//pago con tarjeta
					scanner.nextLine();//limpia buffer
					System.out.println("Ingrese numero de tarjeta: ");
					String numeroTarjeta = scanner.nextLine();
					PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now(),total ) ;
					pagoTarjeta.realizarPago(total);
					pagoTarjeta.imprimirRecibo();
				}else {
					System.out.println("opcion invalida");
					}
			}while(opcionPago!=1 && opcionPago!=2);
		}catch(InputMismatchException e){
			System.out.println("Error: Ingrese un número válido.");
		}finally {
			scanner.close();
		}
	}

}
