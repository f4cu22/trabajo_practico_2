package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		//crea objeto felino domestico
		FelinoDomestico garfield = new FelinoDomestico("Garfield",(byte)45,120f);
		
		//definición de expresión lambda que define el convertidor de FelinoDomestico a 
		//FelinoSalvaje.
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> 
		new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
		
		//se realiza la conversión
		FelinoSalvaje felino1 = converter.convert(garfield);
		
		//mostramos los datos del objeto felino salvaje felino1
		converter.mostrarObjeto(felino1);
		
		//conversion inversa
		FelinoSalvaje tanner = new FelinoSalvaje("Tanner",(byte)20,186f);
		Converter<FelinoSalvaje, FelinoDomestico> converter2 = x ->
		new FelinoDomestico(x.getNombre(),x.getEdad(),x.getPeso());
			
		//verificar si el objeto a convertir  no es nulo
		if (Converter.isNotNull(tanner)) {
			FelinoDomestico felinoDomestico = converter2.convert(tanner);
			//mostrar datos del felino domestico
			converter2.mostrarObjeto(felinoDomestico);
		}else {
			System.out.println("El objeto a convertir es nulo.");
		}
		
	}

}
