package consola;

import central.Galeria;

public class ConsolaPrincipal extends ConsolaBasica 
{

	//Atributos
	
	 private final String[] opcionesMenuPrincipal = new String[] {"Registrar nuevo empleado", "Registrar nuevo cliente", "Acceder al sistema de la galería", "Salir"};
	 
	 
	 //Métodos
	 
	    
	 public void mostrarMenuPrincipal() 
	 {
	     
		 int opcion = mostrarMenu("Bienvenido al Menú Principal", opcionesMenuPrincipal);
	     if(opcion == 1)
	     {
	    	 registrarEmpleado( );
	     }
	     
	     else if(opcion == 2) 
	     {
	    	 registrarCliente();
	     }
	     
	     else if(opcion == 3) 
	     {
	    	 accederSistema();
	     }
	     
	     else if(opcion == 4)
	     {
	    	 System.out.println("Saliendo...");
	    	 System.exit(0);
	     }
	     
	     mostrarMenuPrincipal();
	 }
	 
	 
	 public void registrarEmpleado() 
	 {
		 Galeria galeria = new Galeria();
		 
		 String nombre = pedirCadenaAlUsuario("Indique su nombre completo: ");
		 int identificacion = pedirEnteroAlUsuario("Indique su número de identificación sin carácteres especiales o espacios: ");
		 int telefono = pedirEnteroAlUsuario("Indique su número de telefono sin carácteres especiales o espacios: ");
		 String correo = pedirCadenaAlUsuario("Indique su dirección de correo: ");
		 String login = pedirCadenaAlUsuario("Indique su nombre de usuario con el que ingresará al sistema de la galería: ");
		 String password = pedirCadenaAlUsuario("Indique una contraseña con la que ingresará al sistema de la galería, esta debe ser de mínimo 5 dígitos: ");
		 String tipo = pedirCadenaAlUsuario("Indique el tipo de empleado que desea registrar, este puede ser administrador, operador o cajero: ");
		 
		 galeria.registrarEmpleado(nombre, identificacion, telefono, correo, login, password, tipo);
		 
		 System.out.println("El empleado se resgistró correctamente.");
	 }
	 
	 public void registrarCliente() 
	 {
		 Galeria galeria = new Galeria();
		 
		 String nombre = pedirCadenaAlUsuario("Indique su nombre completo: ");
		 int identificacion = pedirEnteroAlUsuario("Indique su número de identificación sin carácteres especiales o espacios: ");
		 int telefono = pedirEnteroAlUsuario("Indique su número de telefono sin carácteres especiales o espacios: ");
		 String correo = pedirCadenaAlUsuario("Indique su dirección de correo: ");
		 String login = pedirCadenaAlUsuario("Indique su nombre de usuario con el que ingresará al sistema de la galería: ");
		 String password = pedirCadenaAlUsuario("Indique una contraseña con la que ingresará al sistema de la galería, esta debe ser de mínimo 5 dígitos: ");
		 double ingreso = pedirNumeroAlUsuario("Indique el tipo de empleado que desea registrar, este puede ser administrador, operador o cajero: ");
		 double limiteCompra = ingreso * 2 - (ingreso / 2);
		 
		 galeria.registrarCliente(nombre, identificacion, telefono, correo, login, password, ingreso, limiteCompra);
		 
		 System.out.println("El cliente se resgistró correctamente.");
	 }
	 
	 public void accederSistema()
	 {
		 Galeria galeria = new Galeria();
	 
		 String login = pedirCadenaAlUsuario("Indique su nombre de usuario con el que ingresará al sistema de la galería: ");
		 String password = pedirCadenaAlUsuario("Indique una contraseña con la que ingresará al sistema de la galería, esta debe ser de mínimo 5 dígitos: ");

		 galeria.accederSistema(login, password);
	}
	 

}
