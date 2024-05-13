package consola;

import central.Galeria;
import inventario.ObraDeArte;

import java.util.ArrayList;
import java.util.Date;
import usuarios.Cliente;
import usuarios.Empleado;

public class ConsolaCliente extends ConsolaBasica
{

	//Atributos
	
		 private final String[] opcionesMenuPrincipal = new String[] {"Realizar oferta de compra", "Realizar oferta de subasta","Consultar historial de propiedades actuales", "Consultar historial de compras",  "Salir"};
		 
		 //Métodos
		 
		 public void mostrarMenuPrincipal() 
		 {
		     
			 int opcion = mostrarMenu("Bienvenido a la Galería", opcionesMenuPrincipal);
		     if(opcion == 1)
		     {
		    	 comprarPiezas( );
		     }
		     
		     else if(opcion == 2) 
		     {
		    	 ofertarPiezas();
		     }
		     
		     
		     else if(opcion == 3) 
		     {
		    	 consultarHistorialPropiedades();
		     }
		     
		     else if(opcion == 4) 
		     {
		    	 consultarHistorialCompras();
		     }
		     
		     else if(opcion == 5)
		     {
		    	 System.out.println("Saliendo...");
		    	 System.exit(0);
		     }
		     
		     mostrarMenuPrincipal();
		 }

		public void comprarPiezas() 
		 {
			 Galeria galeria = new Galeria();
			 
			 String codigosRegistro = pedirCadenaAlUsuario("Ingrese los códigos de registro de las piezas a comprar separados por coma y espacio: ");
		     int identificacion = pedirEnteroAlUsuario("Ingrese la identificación del cliente: ");
		     Date fecha = new Date(); // Obtener la fecha actual
		     String tipoPago = pedirCadenaAlUsuario("Ingrese el tipo de pago (Efectivo, Tarjeta, Transferencia): ");
		     int identificacionEmpleado = pedirEnteroAlUsuario("Ingrese el identificador del empleado que lo está atendiendo:  ");
		     Empleado empleado = galeria.obtenerEmpleadoPorIdentificacion(identificacionEmpleado);

		     String resultado = galeria.comprarPiezas(codigosRegistro, identificacion, fecha, tipoPago, empleado, galeria);
		     System.out.println(resultado);	 
		 
		 }
		 
		 
		 public void ofertarPiezas() 
		 {
			 Galeria galeria = new Galeria();
			 
			 String codigosRegistro = pedirCadenaAlUsuario("Ingrese los códigos de registro de las piezas a ofertar separados por coma y espacio: ");
		     int oferta = pedirEnteroAlUsuario("Ingrese la oferta por las piezas: ");
		     int identificacion = pedirEnteroAlUsuario("Ingrese la identificación del cliente: ");
		     Date fecha = new Date(); // Obtener la fecha actual
		     String tipoPago = pedirCadenaAlUsuario("Ingrese el tipo de pago (Efectivo, Tarjeta, Transferencia): ");
		     double limiteFecha = pedirNumeroAlUsuario("Ingrese el límite de fecha para la oferta: ");
		     int identificacionEmpleado = pedirEnteroAlUsuario("Ingrese el identificador del empleado que lo está atendiendo:  ");
		     Empleado empleado = galeria.obtenerEmpleadoPorIdentificacion(identificacionEmpleado);
		     ArrayList<ObraDeArte> piezas = galeria.obtenerObrasPorCodigos(codigosRegistro);
		     int valorMinimo = empleado.determinarValorMinimoOferta(piezas);

		     String resultado = galeria.ofertarPiezas(codigosRegistro, oferta, identificacion, fecha, tipoPago, limiteFecha, empleado, galeria, valorMinimo);
		     System.out.println(resultado);
		 }
		
		 
		 public void consultarHistorialPropiedades() 
		 {
			 Galeria galeria = new Galeria();
			 
			 int identificacionCliente = pedirEnteroAlUsuario("Ingrese la identificación del cliente: ");
			 Cliente cliente = galeria.buscarClientePorIdentificacion(identificacionCliente);

			 ArrayList<ObraDeArte> historialPropiedades = cliente.consultarHistorialPropiedades(identificacionCliente);

			 System.out.println("Historial de propiedades del cliente con identificación " + identificacionCliente + ":");
			 for (ObraDeArte obra : historialPropiedades) {
			    System.out.println("Título: " + obra.getTitulo() + ", Autor: " + obra.getAutor().getNombre());
			    }
		 }
		 
		 public void consultarHistorialCompras() 
		 {
			 Galeria galeria = new Galeria();
			 
			 int identificacionCliente = pedirEnteroAlUsuario("Ingrese la identificación del cliente: ");
			 Cliente cliente = galeria.buscarClientePorIdentificacion(identificacionCliente);

			 ArrayList<ObraDeArte> historialCompras = cliente.consultarHistorialCompras(identificacionCliente);

			 System.out.println("Historial de compras del cliente con identificación " + identificacionCliente + ":");
			 for (ObraDeArte obra : historialCompras) {
			    System.out.println("Título: " + obra.getTitulo() + ", Autor: " + obra.getAutor().getNombre());
			    }
		 }
		
}
