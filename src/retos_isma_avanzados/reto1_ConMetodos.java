package retos_isma_avanzados;

import java.util.Scanner;

public class reto1_ConMetodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce los 8 primeros numeros de tu CCC y despues dale al INTRO");	
		String CCC = sc.nextLine();
		
		System.out.println("Introduce los 8 siguientes numeros de tu CCC y despues dale al INTRO");	
		String CCC2= sc.nextLine();
		
		System.out.println("Introduce los 4 ultimos numeros de tu CCC y despues dale al INTRO");	
		String CCC3= sc.nextLine();
	
	//	1)	COMPROBACION DE QUE EL CCC INTRODUCIDO TIENE 20 NUMEROS:
		
		//	Comprobacion de que la longitud total de los String es de 20 (8 + 8 + 4), si no lo es, salta un aviso
		
		boolean LongitudtotalCCC;
						
		if (CCC.length() + CCC2.length() + CCC3.length() != 20) {
			LongitudtotalCCC = false;
			System.out.println("este CCC es incorrecto, no tiene 20 digitos");
		} else {
			LongitudtotalCCC = true;
			System.out.println("tiene la longitud correcta, 20 digitos");
		}
				
		
	//	2)	COMPROBACION DE QUE TODOS LOS DATOS SEAN NUMEROS:
		
		//	Aviso de excepcion cuando algun dato introducido no es un numero (int)
		
		boolean StringToIntCCC;
		boolean StringToIntCCC2;
		boolean StringToIntCCC3;
				
		try {
			int CCCnum = StringToInt(CCC);
			StringToIntCCC = true;
			
		} catch(NumberFormatException e) {
			StringToIntCCC = false;
			System.out.println("se han introducido digitos que no son numeros, EXCEPTION tipo: " + e.getMessage());
		}
		

		try {
			int CCCnum2 = StringToInt(CCC2);
			StringToIntCCC2 = true;
			
		} catch(NumberFormatException e) {
			StringToIntCCC2 = false;
			System.out.println("se han introducido digitos que no son numeros, EXCEPTION tipo: " + e.getMessage());
		}
		
		
		try {
			int CCCnum3 = StringToInt(CCC3);
			StringToIntCCC3 = true;
			
		} catch(NumberFormatException e) {
			StringToIntCCC3 = false;
			System.out.println("se han introducido digitos que no son numeros, EXCEPTION tipo: " + e.getMessage());
		}
		
			if(StringToIntCCC == true && StringToIntCCC2 == true && StringToIntCCC3 == true) {
				System.out.println("todos los digitos introducidos son numeros");
			}
				
	// 	3)	COMPROBACION QUE LOS DIGITOS DE CONTROL SON CORRECTOS:
			
			//	NUM DE CONTROL 1:
			
			//	LOS 8 NUMEROS DE LA PRIMERA PARTE DEL CCC (CCC) PARA PODER OPERAR CON ELLOS:
			
			try {
				
				posicion0(CCC);
				posicion1(CCC);
				posicion2(CCC);
				posicion3(CCC);
				posicion4(CCC);
				posicion5(CCC);
				posicion6(CCC);
				posicion7(CCC);
				
			} catch(NumberFormatException e) {			
			} catch(StringIndexOutOfBoundsException e) {}
			
			
			
		/*	DE LAS 4 PRIMERAS CIFRAS, LA PRIMERA POR 4, LA SEGUNDA POR 8, LA TERCERA POR 5 Y LA CUARTA POR 10, LO SUMAMOS TODO
			Y A LA SUMA LA LLAMAMOS A.
			DE LAS SIGUIENTES 4 CIFRAS, LA PRIMERA POR 9, LA SEGUNDA POR 7, LA TERCERA POR 3 Y LA CUARTA POR 6, LO SUMAMOS TODO
			Y LLAMAMOS A LA SUMA B.
			SUMAMOS A Y B Y CALCULAMOS CUANTO VALE A+B MODULO 11, ES DECIR, DIVIDIMOS A+B ENTRE 11 Y NOS QUEDAMOS CON EL RESTO,
			A ESTE RESTO LE LLAMAMOS C.
			RESTAMOS 11 MENOS C Y ESE ES EL PRIMER DIGITO DE CONTROL.	*/
			
			int NumControl1 = 0;
			
			try {
				
			int A = (posicion0(CCC)*4) + (posicion1(CCC)*8) + (posicion2(CCC)*5) + (posicion3(CCC)*10);
			int B = (posicion4(CCC)*9) + (posicion5(CCC)*7) + (posicion6(CCC)*3) + (posicion7(CCC)*6);
			int C = (A + B)%11;
			NumControl1 = 11 - C;	// este es el que debe de ser
			
			
			if(NumControl1 == 10) {
				NumControl1 = 1;
			}
			if(NumControl1 == 11) {
				NumControl1 = 0;
			}	
			
			} catch(NumberFormatException e) {			
			} catch(StringIndexOutOfBoundsException e) {}
			
			
			//	NUM DE CONTROL 2:			
		
			try {
				
				posicion2(CCC2);
				posicion3(CCC2);
				posicion4(CCC2);
				posicion5(CCC2);
				posicion6(CCC2);
				posicion7(CCC2);
				
				posicion0(CCC3);
				posicion1(CCC3);
				posicion2(CCC3);
				posicion3(CCC3);
				
			} catch(NumberFormatException e) {			
			} catch(StringIndexOutOfBoundsException e) {}
		
			
		/*	MULTIPLICAMOS EN ORDEN CADA UNA DE LAS 10 CIFRAS DEL NUMERO DE CUENTA (SON LAS 10 ULTIMAS DEL CCC COMPLETO) POR
			1, 2, 4, 8, 5, 10, 9, 7, 3, 6 Y LOS SUMAMOS TODOS, LO LLAMAREMOS D.
			CALCULAMOS CUANTO VALE D MODULO 11, QUEDANDONOS CON EL RESTO DE DIVIDIR D ENTRE 11, LLAMAMOS A ESE RESTO E.
			AHORA SOLO QUEDA CALCULA 11 MENOS E, SI SALES 10 PONEMOS UN 1, SI NOS SALE 11 PONEMOS UN 0	*/
			
			int NumControl2 = 0;
			
			try {
				
			int D = (posicion2(CCC2)*1) + (posicion3(CCC2)*2) + (posicion4(CCC2)*4)+ (posicion5(CCC2)*8)
					+ (posicion6(CCC2)*5) + (posicion7(CCC2)*10) + (posicion0(CCC3)*9)+ (posicion1(CCC3)*7)
					+ (posicion2(CCC3)*3)+ (posicion3(CCC3)*6);	
			int E = D%11;
						
			NumControl2 = 11-E;
			
			if(NumControl2 == 10) {
				NumControl2 = 1;
			}
			if(NumControl2 == 11) {
				NumControl2 = 0;
			}
			
			} catch(NumberFormatException e) {			
			} catch(StringIndexOutOfBoundsException e) {}
		
			
			//	COMPROBAR SI LOS NUMEROS DE CONTROL SON CORRECTOS:
						
			//	LOS 2 PRIMEROS NUMEROS DE LA SEGUNDA PARTE DEL CCC (CCC2) PARA PODER OPERAR CON ELLOS (LOS DIGITOS DE CONTROL):	

			boolean NumControl1Boolean=true;
			boolean NumControl2Boolean=true;
			
			try {
				
			if(posicion0(CCC2) == NumControl1) {
				NumControl1Boolean = true;
				System.out.println("el primer digito de control es correcto");
			}else {
				NumControl1Boolean = false;
				System.out.println("el primer digito de control es incorrecto, deberia de ser un " + NumControl1);
			}
			
			if(posicion1(CCC2) == NumControl2) {
				NumControl2Boolean = true;
				System.out.println("el segundo digito de control es correcto");
			}else {
				NumControl2Boolean = false;
				System.out.println("el segundo digito de control es incorrecto, deberia de ser un " + NumControl2);
			}
			
			}	catch(NumberFormatException e) {
			}	catch(StringIndexOutOfBoundsException e) {}
			
			
	// 	4)	MENSAJE FINAL:
			
			if(LongitudtotalCCC == true && StringToIntCCC == true && StringToIntCCC2 == true && StringToIntCCC3 == true
				&& NumControl1Boolean == true && NumControl2Boolean == true) {
				System.out.println("\npor todo esto, esta cuenta ES CORRECTA");
			} else {
				System.out.println("\npor todo esto, esta cuenta NO ES CORRECTA");
			}
								
	}
	
	public static String CharToString (char a) {
		return String.valueOf(a);
	}
	
	public static int StringToInt (String nombre) {
		return Integer. parseInt(nombre);
	}
	
	public static int posicion0 (String string) {
						
		String StringPosicion = CharToString(string.charAt(0));		
		int NumPosicion = StringToInt(StringPosicion);
		return NumPosicion;	
	}
	
	public static int posicion1 (String string) {
				
		String StringPosicion = CharToString(string.charAt(1));		
		int NumPosicion = StringToInt(StringPosicion);
		return NumPosicion;	
	}
	
	
	public static int posicion2 (String string) {
						
		String StringPosicion = CharToString(string.charAt(2));		
		int NumPosicion = StringToInt(StringPosicion);
		return NumPosicion;	
	}
	
	public static int posicion3 (String string) {
				
		String StringPosicion = CharToString(string.charAt(3));		
		int NumPosicion = StringToInt(StringPosicion);
		return NumPosicion;	
	}	
	
	public static int posicion4 (String string) {
		
		String StringPosicion = CharToString(string.charAt(4));		
		int NumPosicion = StringToInt(StringPosicion);
		return NumPosicion;	
	}
	
	public static int posicion5 (String string) {
				
		String StringPosicion = CharToString(string.charAt(5));		
		int NumPosicion = StringToInt(StringPosicion);
		return NumPosicion;	
	}
	
	
	public static int posicion6 (String string) {
						
		String StringPosicion = CharToString(string.charAt(6));		
		int NumPosicion = StringToInt(StringPosicion);
		return NumPosicion;	
	}
	
	public static int posicion7 (String string) {
				
		String StringPosicion = CharToString(string.charAt(7));		
		int NumPosicion = StringToInt(StringPosicion);
		return NumPosicion;	
	}		
	
}
