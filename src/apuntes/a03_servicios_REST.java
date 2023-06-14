package apuntes;

public class a03_servicios_REST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/* SERVICIOS REST (ARQUITECTURA TIPO REST):
	es una aplicacion web que cumple una serie de patrones determinados
	- verbos HTTP
		-> Tipo de peticion que enviamos a un servidor utilizando el protocolo HTTP, los mas utilizados son:
			1) GET -> OBTENER, obtiene informacion (recurso) de un servidor
			2) POST -> CREAR, envia datos a un servidor
			3) PUT -> ACTUALIZAR, se utiliza para actualizar un recurso que ya existe, enviando todos los datos + los datos que han cambiado
			4) PATCH -> se utiliza para actualizar un recurso que ya existe, envia unicamente los datos que han cambiado
			5) DELETE -> ELIMINAR, se utiliza para eliminar un recurso que ya existe
			"CRUD" (Create Replace Update Delete)
			
	EJEMPLO:	
		GET HTTP://WWW.DOMINIO.TLD/BOOTCAMPERS
			-> usuario 1
			-> usuario 2
			-> usuario 3
			
		POST HTTP://WWW.DOMINIO.TLD/BOOTCAMPERS
			"Por favor, crea un nuevo usuario con nombre XXXXX"	
			
		PUT HTTP://WWW.DOMINIO.TLD/BOOTCAMPERS/USUARIO1
					
		DELETE HTTP://WWW.DOMINIO.TLD/BOOTCAMPERS/USUARIO1			
		
		-> como requisito para el REST se usan nombres (no verbos) como recursos, y siempre seran en plural, ejemplos:
		
			http://www.dominio.tld/users
			http://www.dominio.tld/users/paco
			http://www.dominio.tld/users/vroman/friends/paco
			
			http://www.dominio.tld/api/v1/users
				- POST "nombre", "apellidos"
				
			http://www.dominio.tld/api/v2/users
				- POST "nombre completo"				
			
			http://www.dominio.tld/cars
			http://www.dominio.tld/pets
		
		
		*/
		
	}

}
