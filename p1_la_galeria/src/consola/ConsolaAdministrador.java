package consola;

import central.Galeria;

public class ConsolaAdministrador extends ConsolaBasica
{
	//Atributos
	
	 private final String[] opcionesMenuPrincipal = new String[] {"Verificar cliente", "Verificar empleado", "Verificar compra", "Verificar oferta", "Ingresar pieza a consignación","Consultar el historial de una pieza", "Consultar el historial de un artista", "Consultar el historial de un comprador",  "Salir"};
	 private final String[] opcionesMenuIngresoObra = new String[] {"Ceramica", "Escultura", "Fotografía", "Grabado", "Pintura", "Video"};
	 
	 //Métodos
	 
	 public void mostrarMenuPrincipal() 
	 {
	     
		 int opcion = mostrarMenu("Bienvenido a la Galería Administrador", opcionesMenuPrincipal);
	     if(opcion == 1)
	     {
	    	 verificarCliente( );
	     }
	     
	     else if(opcion == 2) 
	     {
	    	 verificarEmpleado();
	     }
	     
	     else if(opcion == 3) 
	     {
	    	 verificarCompra();
	     }
	     
	     else if(opcion == 4) 
	     {
	    	 ingresarPiezaConsignacion();
	     }
	     
	     else if(opcion == 5) 
	     {
	    	 consultarHistorialDeUnaPieza();
	     }
	     
	     else if(opcion == 5) 
	     {
	    	 consultarHistorialDeUnArtista();
	     }
	     
	     else if(opcion == 5) 
	     {
	    	 consultarHistorialDeUnComprador();
	     }
	     
	     else if(opcion == 4)
	     {
	    	 System.out.println("Saliendo...");
	    	 System.exit(0);
	     }
	     
	     mostrarMenuPrincipal();
	 }
	 
	 
	 public void verificarCliente()
	 {
		 Galeria galeria = new Galeria();

		    String login = pedirCadenaAlUsuario("Ingrese su login: ");
		    String password = pedirCadenaAlUsuario("Ingrese su password: ");
		    double limiteCompra = pedirNumeroAlUsuario("Ingrese su límite de compra: ");

		    if (galeria.verificarComprador(login, password, limiteCompra)) {
		        System.out.println("Usted es un comprador válido.");
		    } else {
		        System.out.println("Usted no es un comprador válido.");
		    }
	 }
	 
	 public void verificarEmpleado()
	 {
		 Galeria galeria = new Galeria();

		    String login = pedirCadenaAlUsuario("Ingrese el login del empleado: ");
		    String password = pedirCadenaAlUsuario("Ingrese el password del empleado: ");

		    if (galeria.verificarEmpleado(login, password)) {
		        System.out.println("El empleado con login " + login + " y password " + password + " es válido.");
		    } else {
		        System.out.println("El empleado con login " + login + " y password " + password + " no es válido.");
		    }
	 }
	 
	 public void verificarCompra()
	 {
		 
	 }
	 
	 public void ingresarPiezaConsignacion()
	 {
		 
	 }
	 
	 public void consultarHistorialDeUnaPieza()
	 {
		 
	 }
	 
	 public void consultarHistorialDeUnArtista()
	 {
		 
	 }
	 
	 public void consultarHistorialDeUnComprador()
	 {
		 
	 }
	 
}
