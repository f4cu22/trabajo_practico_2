package ar.edu.unju.fi.ejercicio3.main;
/**
*Clase Main que representa la informacion
*de la provincia
*
*@author Alavar, Facundo Nicolás
*@version 1.0
*
*/
import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		//Guardar los valores de enum Provincia en una array
		Provincia[] provincias = Provincia.values();
		//mostrar cada enum con su informacion
		for(Provincia provincia : provincias) {
			System.out.println("Provincia :"+provincia);
			System.out.println("Poblacion: "+provincia.getPoblacion());
			System.out.println("Superficie: "+provincia.getSuperficie());
			System.out.println("Densidad poblacional: "+provincia.calcularDensidadPoblacional());
			System.out.println();
		}

	}

}
