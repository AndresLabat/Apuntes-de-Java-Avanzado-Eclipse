package apuntes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class a01_lambdas_y_funciones_alto_nivel {

	private static int contador = 0;	//	variable creada para la funcion impura
	
	//	crear una funcion que es como una variable:
	
	private Function <String, String> toMayus = x -> x.toUpperCase();
			// el primer String indica que acepta un String como parametro de entrada 
			// el segundo String indica que acepta un parametro de tipo String como parametro de salida
	
	private Function <Integer, Integer> sumador = x -> x.sum(x, x);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// usa una funcion PURA:
		
		int result = suma(1, 2);
		int result2 = suma(1, 2);
		System.out.println(result + " " + result2);		
		
		// usa una funcion IMPURA:
		
		int result3 = sumaConContador(1, 2);
		int result4 = sumaConContador(1, 2);
		System.out.println(result3 + " " + result4);
		System.out.println(contador);
	
		// usa el metodo normal que he creado:	
		
		String nombre = "andres";
		System.out.println(toMayuscula (nombre));	
		
		a01_lambdas_y_funciones_alto_nivel f = new a01_lambdas_y_funciones_alto_nivel();	//	crea un objeto
		f.pruebas();
		
		//	FUNCIONES COMPLEJAS EN UN ARRAYLIST:
		
		List<String> nombres = new ArrayList();
		nombres.add("Paco");
		nombres.add("Pepe");
		nombres.add("Juan");
		
		// con esta funcion tambien podemos recorrer el Arraylist como haciamos con el bucle for:
		
		nombres.stream().forEach(x -> System.out.println(x));
		// .Stream es de un solo uso, me va a dar los valores del Arraylist
		// .forEach recorre el ArrayList, y en este caso nos imprime el resultado
		
		Stream<String> valores = nombres.stream().map(x -> "Hola, " + x.toUpperCase());
		// en este tipo de nomenclatura, la x siempre indica el parametro de entrada, en este caso "Paco", "Pepe"...
		// .map (significa, sobre cada valor que yo tengo, aplicale esa funcion)
		// .Stream es de un solo uso, me va a dar los valores del Arraylist, no puedo iterar con ella mas de una vez con la siguiente funcion:
		
		valores.forEach(x -> System.out.println(x));
		
		// MAS COMPLEJO AUN:
		
		Stream<String> valores2 = nombres.stream().map(x -> x.toUpperCase()).filter(x -> x.startsWith("P"));
		// .Stream es de un solo uso, me va a dar los valores del Arraylist, no puedo iterar con ella mas de una vez con la siguiente funcion:
		// .map (significa, sobre cada valor que yo tengo, aplicale esa funcion) para transformar todos los Strings a mayusculas
		// .filter lo limita, y le dice que me de solo los que empiezan con P
		
		valores2.forEach(x -> System.out.println(x));
		// la forma corta es: valores2.forEach(System.out::println);
		
		// AHORA CON UN ARRAY:
			
		int [] numeros = {1,2,3,4,5,6,7,8,9,10};
		
		// manera nueva de hacerlo (declarativa):
		var stNumeros = Arrays.stream(numeros);
		var resultado = stNumeros
			.filter(x -> x%2 == 0)
			.reduce(0, (x, y) -> x + y);	// el 0 indica el valor inicial de la x

		
		//manera antigua de hacerlo (imperativa):
		int sumatotal = 0;
		for (int numero : numeros) {
			if(numero % 2 != 0) {
				continue;
			}
			sumatotal += numero;
		}
		
		System.out.println("Mi suma de pares es: " + resultado + " y con for: " + sumatotal);
		
		
		
	}		
		
		//	PROGRAMACION FUNCIONAL:
		
		//	FUNCION PURA:
		
		//	es toda aquella que dados unos mismos parametros de entrada, siempre produce el mismo resultado de salida
		//	ademas tiene que hacer lo que dice (su nombre)
		//	ejemplo:
			
		public static int suma(int a, int b) {
			return a + b;
		}
		
		//	FUNCION IMPURA:
		
		//	es toda aquella que dados unos mismos parametros de entrada, no siempre produce el mismo resultado de salida
		//	si una funcion contiene una funcion impura, tambien se considera impura en si misma
		
		//	ejemplo1(no siempre da el mismo resultado, modifica una variable ajena a la funcion):
				
		public static int sumaConContador(int a, int b) {
			contador +=1;
			return a + b;
		}		
		
		// ejemplo2(no hace lo que dice):
		
		public static int multiplica(int a, int b) {
			return a + b;
		}
		
		// ejemplo3(contiene una funcion impura):
		
		public static int sumatorio(int a, int b) {
			multiplica(a, b);
			return a + b;
		}
		
		/* FUNCION DE ALTO ORDEN O DE ALTO NIVEL:
		 significa que una funcion puede llamar a otra funcion y/o debe devolver finalmente una funcion
		 1) es una funcion que recibe un parametro obligatoriamente que es otra funcion, la funcion tiene entre sus argumentos 
		 un nombre, y ese nombre tiene que ser el nombre de otra funcion que ya exista
		 
		 2) es una funcion que devuelve como resultado otra funcion	*/

		
		public void pruebas() {
			Saluda(toMayus, "Victor");

		}
		
		public void Saluda(Function <String, String> mifuncion, String nombre) {
			mifuncion.apply(nombre);
	
		}
		
		// FUNCION NORMAL Y CORRIENTE:
		
		public static String toMayuscula (String nombre) {
			return nombre.toUpperCase();
		}

}
