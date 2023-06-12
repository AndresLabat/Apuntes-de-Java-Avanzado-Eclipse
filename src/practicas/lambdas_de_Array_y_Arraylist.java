package practicas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class lambdas_de_Array_y_Arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	LAMBDAS SOBRE UN ARRAYLIST:
		
		List<String> nombres = new ArrayList ();
		
		nombres.add("Jose");
		nombres.add("Andres");
		nombres.add("Jaime");
		nombres.add("juan");
		
		nombres.stream().map(x -> x.toUpperCase()).filter(x -> x.startsWith("J")).forEach(x -> System.out.println(x));
		// pasa todos los nombres a mayusculas, luego filtra por todos los que empiezan por J mayuscula y luego me 
		// recorre el arraylist mostrandome todos los que cumplen todo eso
		
		nombres.stream().filter(x -> x.startsWith("J")).forEach(x -> System.out.println(x));
		// filtra por todos los que empiezan por J mayuscula y luego me 
		// recorre el arraylist mostrandome todos los que cumplen todo eso
		
		nombres.stream()				//	OTRA MANERA DE ESCRIBIRLO Y QUE SE VEA MAS CLARO
		.map(x -> x.toLowerCase())
		.filter(x -> x.endsWith("e"))
		.filter(x -> x.startsWith("j"))
		.forEach(System.out::println);	//	la forma corta de hacer el (x -> System.out.println(x))
		// pasa todos los nombres a minusculas, luego filtra por los que acaben en e y empiecen por j, y luego me recorre el array mostrandome el resultado
		
		
		//	LAMBDAS SOBRE UN ARRAY:
		
		int[] numeros = {2, 3, 4, 6, 9, 10};
		
		var streamNumeros = Arrays.stream(numeros);
		var resultado = streamNumeros
				.filter(x -> x%2 != 0)			//	me filtra solo a los impares
				.reduce(1, (x, y) -> x * y);	//	multiplica todos los numeros del array, comenzando por el 1
		
		System.out.println("La multiplicacion de sus elementos impares es: " + resultado); 	// el resultado es 1 * 3 * 9
		
		
		
		int [] numeros2 = {1,2,3,4,5,6,7,8,9,10};
		
		var streamNumeros2 = Arrays.stream(numeros2);
		var resultado2 = streamNumeros2
			.filter(x -> x%2 == 0)
			.reduce(0, (x, y) -> x + y);
		
		System.out.println("La suma de sus numeros pares es: " + resultado2); 	// el resultado es 0 + 2 + 4 + 6 + 8 + 10
		
		
	}

}
