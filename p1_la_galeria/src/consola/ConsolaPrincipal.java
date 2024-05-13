package consola;

import central.Galeria;
import usuarios.Empleado;

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
		 
		 System.out.println("El cliente se registró correctamente.");
	 }
	 
	 public void accederSistema()
	 {
		 Galeria galeria = new Galeria();
	 
		 String login = pedirCadenaAlUsuario("Indique su nombre de usuario con el que ingresará al sistema de la galería: ");
		 String password = pedirCadenaAlUsuario("Indique una contraseña con la que ingresará al sistema de la galería, esta debe ser de mínimo 5 dígitos: ");

		 boolean sistema = galeria.accederSistema(login, password);
		 
		 
		 String tipoUsuario = galeria.verificarUsuario(login, password);
		 
		 if (tipoUsuario != null) {
		        switch (tipoUsuario) {
		            case "cliente":
		            	ConsolaCliente consolaCliente = new ConsolaCliente();
		                consolaCliente.mostrarMenuPrincipal();
		                break;
		                
		            case "empleado":
		            	
		            	Empleado empleadoEncontrado = null;
		                for (Empleado empleado : galeria.consultarEmpleados()) {
		                    if (empleado.getLogin().equals(login) && empleado.getPassword().equals(password)) {
		                        empleadoEncontrado = empleado;
		                        break;
		                    }
		                    
		                }
		       
		                if (empleadoEncontrado == null) {
		                        System.out.println("Credenciales incorrectas.");
		                        return;
		                }

		                if (empleadoEncontrado.getTipo().equals("Administrador")) {
		                        
		                        ConsolaAdministrador consolaAdministrador = new ConsolaAdministrador();
				                consolaAdministrador.mostrarMenuPrincipal();
		                }

		                if (empleadoEncontrado.getTipo().equals("Operador")) {
		                        
		                        ConsolaOperador consolaOperador = new ConsolaOperador();
				                consolaOperador.mostrarMenuPrincipal();
				                
		                }

		                if (empleadoEncontrado.getTipo().equals("Cajero")) {
		                        
		                        ConsolaCajero consolaCajero = new ConsolaCajero();
				                consolaCajero.mostrarMenuPrincipal();
		                }
		                    
		                default:
		                    System.out.println("Tipo de usuario no válido.");
		        }
		    } else {
		        System.out.println("Credenciales incorrectas.");
		    }
	}
	 

}
