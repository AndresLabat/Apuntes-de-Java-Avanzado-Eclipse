package apuntes;

import java.util.stream.IntStream;

public class a02_funciones_recursivas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1 + 2 + 3 + 4 + 5 => 15
		System.out.println("suma iterativa: " + suma(5));
			
		//	sumaRecursiva(5) -> 5 
		//		sumaRecursiva(4) -> 5 - 1
		//			sumaRecursiva(3) -> 4 - 1
		//				sumaRecursiva(2) -> 3 - 1
		//					sumaRecursiva(1) -> 2 - 1
		System.out.println("suma recursiva: " + sumaRecursiva(5));
		
		System.out.println("suma funcional: " + sumaFuncional(5));
		
		//	de esta forma podemos ver como iteran las funciones en si mismas, dando esos valores:
		tailRecursion(5);
		headRecursion(5);
		
		//	1 * 2 * 3 * 4 * 5 => 120
		System.out.println("factorial iterativa: " + factorial(5));
		System.out.println("factorial recursivo: " + factorialRecursivo(5));
		System.out.println("factorial funcional: " + factorialFuncional(5));
		
	}

// RECURSIVIDAD 1:
	
	// una funcion es recursiva cuando se llama a si misma
	
	// de forma ITERATIVA:
	
	public static int suma (int max) {
		int resultado = 0;
		
		for (int i = 0; i <= max; i++) {
			resultado = resultado + i;
		}
		
		return resultado;
	}
	
	// de forma RECURSIVA:
	
	public static int sumaRecursiva (int numero) {
		if(numero == 1) {	//	sentencia de control para ponerle fin a la funcion
			return 1;
		}
		return numero + sumaRecursiva(numero - 1);
	}

	// recursion FUNCIONAL:
	
	public static int sumaFuncional(int numero) {
		return IntStream.rangeClosed(1, numero)
				.reduce(0, (a, b) -> a + b);
	}
	
	
	// mismas funciones recursivas, pero distinto orden al imprimirlo:
	
	public static void tailRecursion(int valor) {
		if(valor == 0){
			return;
		}
		
		System.out.println(valor);
		tailRecursion(valor-1);
	}
	
	public static void headRecursion(int valor) {
		if(valor == 0){
			return;
		}
		
		headRecursion(valor-1);
		System.out.println(valor);
	}
		
// RECURSIVIDAD 2:
		
	// de forma ITERATIVA:
	
	public static int factorial(int numero) {
		int resultado = 1;
		
		for(int i = 1; i <= numero; i++) {
			resultado = resultado * i;
		}
		
		return resultado;
	}
		
	// de forma RECURSIVA:
	
	public static int factorialRecursivo(int numero) {
		if (numero == 0) {
			return 1;
		}
		
		return numero * factorialRecursivo(numero-1);
	}
	
	// de forma FUNCIONAL:
	
	public static int factorialFuncional(int numero) {
			return IntStream.rangeClosed(1, numero)
					.reduce(1, (a, b) -> a * b);
	}
		
}
