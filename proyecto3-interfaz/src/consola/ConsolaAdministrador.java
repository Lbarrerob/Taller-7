package consola;

import java.util.ArrayList;
import java.util.Date;

<<<<<<< HEAD
import central.Artista;
=======
import inventario.Artista;
>>>>>>> branch 'main' of https://github.com/DPO-20241-GRUPO-1001/Proyecto_3.git
import central.Galeria;
import transacciones.Pago;
import usuarios.Cliente;
import usuarios.Empleado;

public class ConsolaAdministrador extends ConsolaBasica
{
	//Atributos
	
	 private final String[] opcionesMenuPrincipal = new String[] {"Verificar cliente", "Verificar empleado", "Verificar compra", "Verificar oferta", "Ingresar pieza a consignación","Consultar el historial de una pieza", "Consultar el historial de pagos", "Consultar el historial de un artista", "Consultar el historial de un comprador",  "Salir"};
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
	    	 verificarOferta();
	     }
	     
	     else if(opcion == 5) 
	     {
	    	 ingresarPiezaConsignacion();
	     }
	     
	     else if(opcion == 6) 
	     {
	    	 consultarHistorialDeUnaPieza();
	     }
	     
	     else if(opcion == 7) 
	     {
	    	 consultarHistorialDePago();
	     }
	     
	     else if(opcion == 8) 
	     {
	    	 consultarHistorialDeUnArtista();
	     }
	     
	     else if(opcion == 9) 
	     {
	    	 consultarHistorialDeUnComprador();
	     }
	     
	     else if(opcion == 10)
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
		 //Todo 
	 }
	 
	 
	 public void verificarOferta()
	 {
		 //Todo
	 }
	 
	 
	 private void ingresarPiezaConsignacion() 
	 {
		 mostrarMenuIngresoObra();
			
		}
	 
	 public void mostrarMenuIngresoObra() 
	 {
	     
		 int opcion = mostrarMenu("Seleccione el tipo de obra que desea ingresar:", opcionesMenuIngresoObra);
	     if(opcion == 1)
	     {
	    	 ingresarCeramica( );
	     }
	     
	     else if(opcion == 2) 
	     {
	    	 ingresarEscultura();
	     }
	     
	     else if(opcion == 3) 
	     {
	    	 ingresarFotografia();
	     }
	     
	     else if(opcion == 4) 
	     {
	    	 ingresarGrabado();
	     }
	     
	     else if(opcion == 5) 
	     {
	    	 ingresarPintura();
	     }
	     
	     else if(opcion == 6) 
	     {
	    	 ingresarVideo();
	     }
	     
	     else if(opcion == 4)
	     {
	    	 System.out.println("Saliendo...");
	    	 System.exit(0);
	     }
	     
	     mostrarMenuIngresoObra();
	 }
	 
	 
	 public void ingresarCeramica() 
	 {
		 Galeria galeria = new Galeria();
		 
		 Date fechaIngreso = new Date(); // Obtener la fecha actual
		 String titulo = pedirCadenaAlUsuario("Título:");
		 int anio = pedirEnteroAlUsuario("Año:");
		 String lugar = pedirCadenaAlUsuario("Lugar:");
		 String nombreArtista = pedirCadenaAlUsuario("Ingrese el nombre del artista quién hizo la obra:  ");
		 Artista autor = galeria.obtenerArtistaPorNombre(nombreArtista); // Método para obtener el artista de la cerámica
		 boolean exhibicion = pedirBooleanoAlUsuario("¿En exhibición? (true/false):");
		 String estado = pedirCadenaAlUsuario("Estado:");
		 int valor = pedirEnteroAlUsuario("Valor:");
		 boolean esFijo = pedirBooleanoAlUsuario("¿Es fijo? (true/false):");
		 int propietarioActual = pedirEnteroAlUsuario("Propietario actual:");
		 Date fechaVenta = null; // La fecha de venta se ingresa cuando se vende la obra
		 float alto = pedirFloatAlUsuario("Alto:");
		 float ancho = pedirFloatAlUsuario("Ancho:");
		 float profundidad = pedirFloatAlUsuario("Profundidad:");
		 String tecnica = pedirCadenaAlUsuario("Técnica:");

		 String mensaje = galeria.IngresarCeramicaConsignacion(fechaIngreso, titulo, anio, lugar, autor, exhibicion, estado, valor,
		            esFijo, propietarioActual, fechaVenta, alto, ancho, profundidad, tecnica);
		  System.out.println(mensaje);
	 
	 }
	 
	 
	 public void ingresarEscultura() 
	 {
		 Galeria galeria = new Galeria();
		 
		 Date fechaIngreso = new Date(); // Obtener la fecha actual
		 String titulo = pedirCadenaAlUsuario("Título:");
		 int anio = pedirEnteroAlUsuario("Año:");
		 String lugar = pedirCadenaAlUsuario("Lugar:");
		 String nombreArtista = pedirCadenaAlUsuario("Ingrese el nombre del artista quién hizo la obra:  ");
		 Artista autor = galeria.obtenerArtistaPorNombre(nombreArtista);
		 boolean exhibicion = pedirBooleanoAlUsuario("¿En exhibición? (true/false):");
		 String estado = pedirCadenaAlUsuario("Estado:");
		 int valor = pedirEnteroAlUsuario("Valor:");
		 boolean esFijo = pedirBooleanoAlUsuario("¿Es fijo? (true/false):");
		 int propietarioActual = pedirEnteroAlUsuario("Propietario actual:");
		 Date fechaVenta = null; // La fecha de venta se ingresa cuando se vende la obra
		 float alto = pedirFloatAlUsuario("Alto:");
		 float ancho = pedirFloatAlUsuario("Ancho:");
		 float profundidad = pedirFloatAlUsuario("Profundidad:");
		 String material = pedirCadenaAlUsuario("Material:");

		 String mensaje = galeria.IngresarEsculturaConsignacion(fechaIngreso, titulo, anio, lugar, autor, exhibicion, estado, valor,
		            esFijo, propietarioActual, fechaVenta, alto, ancho, profundidad, material);
		 System.out.println(mensaje);
	 
	 }
	 
	 
	 public void ingresarFotografia() 
	 {
		 Galeria galeria = new Galeria();
		 
		 Date fechaIngreso = new Date(); // Obtener la fecha actual
		 String titulo = pedirCadenaAlUsuario("Título:");
		 int anio = pedirEnteroAlUsuario("Año:");
		 String lugar = pedirCadenaAlUsuario("Lugar:");
		 String nombreArtista = pedirCadenaAlUsuario("Ingrese el nombre del artista quién hizo la obra:  ");
		 Artista autor = galeria.obtenerArtistaPorNombre(nombreArtista);
		 boolean exhibicion = pedirBooleanoAlUsuario("¿En exhibición? (true/false):");
		 String estado = pedirCadenaAlUsuario("Estado:");
		 int valor = pedirEnteroAlUsuario("Valor:");
		 boolean esFijo = pedirBooleanoAlUsuario("¿Es fijo? (true/false):");
		 int propietarioActual = pedirEnteroAlUsuario("Propietario actual:");
		 Date fechaVenta = null; // La fecha de venta se ingresa cuando se vende la obra
		 float alto_cm = pedirFloatAlUsuario("Alto en cm:");
		 float ancho_cm = pedirFloatAlUsuario("Ancho en cm:");
		 boolean color = pedirBooleanoAlUsuario("¿Es a color? (true/false):");

		 String mensaje = galeria.IngresarFotografiaConsignacion(fechaIngreso, titulo, anio, lugar, autor, exhibicion, estado, valor,
		            esFijo, propietarioActual, fechaVenta, alto_cm, ancho_cm, color);
		 System.out.println(mensaje);
	 
	 }
	 
	 
	 public void ingresarGrabado() 
	 {
		 Galeria galeria = new Galeria();
		 
		 Date fechaIngreso = new Date(); // Obtener la fecha actual
		 String titulo = pedirCadenaAlUsuario("Título:");
		 int anio = pedirEnteroAlUsuario("Año:");
		 String lugar = pedirCadenaAlUsuario("Lugar:");
		 String nombreArtista = pedirCadenaAlUsuario("Ingrese el nombre del artista quién hizo la obra:  ");
		 Artista autor = galeria.obtenerArtistaPorNombre(nombreArtista);
		 boolean exhibicion = pedirBooleanoAlUsuario("¿En exhibición? (true/false):");
		 String estado = pedirCadenaAlUsuario("Estado:");
		 int valor = pedirEnteroAlUsuario("Valor:");
		 boolean esFijo = pedirBooleanoAlUsuario("¿Es fijo? (true/false):");
		 int propietarioActual = pedirEnteroAlUsuario("Propietario actual:");
		 Date fechaVenta = null; // La fecha de venta se ingresa cuando se vende la obra
		 float alto = pedirFloatAlUsuario("Alto:");
		 float ancho = pedirFloatAlUsuario("Ancho:");
		 float profundidad = pedirFloatAlUsuario("Profundidad:");
		 String categoria = pedirCadenaAlUsuario("Categoría:");
		 String material = pedirCadenaAlUsuario("Material:");
		 String tecnica = pedirCadenaAlUsuario("Técnica:");

		 String mensaje = galeria.IngresarGrabadoConsignacion(fechaIngreso, titulo, anio, lugar, autor, exhibicion, estado, valor,
		            esFijo, propietarioActual, fechaVenta, alto, ancho, profundidad, categoria, material, tecnica);
		 System.out.println(mensaje);			 
	 
	 }
	 
	 
	 public void ingresarPintura() 
	 {
		 Galeria galeria = new Galeria();
		 
		 Date fechaIngreso = new Date(); // Obtener la fecha actual
		 String titulo = pedirCadenaAlUsuario("Título:");
		 int anio = pedirEnteroAlUsuario("Año:");
		 String lugar = pedirCadenaAlUsuario("Lugar:");
		 String nombreArtista = pedirCadenaAlUsuario("Ingrese el nombre del artista quién hizo la obra:  ");
		 Artista autor = galeria.obtenerArtistaPorNombre(nombreArtista);
		 boolean exhibicion = pedirBooleanoAlUsuario("¿En exhibición? (true/false):");
		 String estado = pedirCadenaAlUsuario("Estado:");
		 int valor = pedirEnteroAlUsuario("Valor:");
		 boolean esFijo = pedirBooleanoAlUsuario("¿Es fijo? (true/false):");
		 int propietarioActual = pedirEnteroAlUsuario("Propietario actual:");
		 Date fechaVenta = null; // La fecha de venta se ingresa cuando se vende la obra
		 float alto = pedirFloatAlUsuario("Alto:");
		 float ancho = pedirFloatAlUsuario("Ancho:");
		 String tecnica = pedirCadenaAlUsuario("Técnica:");
		 String periodo = pedirCadenaAlUsuario("Período:");
		 String genero = pedirCadenaAlUsuario("Género:");

		 String mensaje = galeria.IngresarPinturaConsignacion(fechaIngreso, titulo, anio, lugar, autor, exhibicion, estado, valor,
		            esFijo, propietarioActual, fechaVenta, alto, ancho, tecnica, periodo, genero);
		 System.out.println(mensaje);
	 
	 }
	 
	 
	 public void ingresarVideo() 
	 {
		 Galeria galeria = new Galeria();
		 
		 Date fechaIngreso = new Date(); // Obtener la fecha actual
		 String titulo = pedirCadenaAlUsuario("Título:");
		 int anio = pedirEnteroAlUsuario("Año:");
		 String lugar = pedirCadenaAlUsuario("Lugar:");
		 String nombreArtista = pedirCadenaAlUsuario("Ingrese el nombre del artista quién hizo la obra:  ");
		 Artista autor = galeria.obtenerArtistaPorNombre(nombreArtista);
		 boolean exhibicion = pedirBooleanoAlUsuario("¿En exhibición? (true/false):");
		 String estado = pedirCadenaAlUsuario("Estado:");
		 int valor = pedirEnteroAlUsuario("Valor:");
		 boolean esFijo = pedirBooleanoAlUsuario("¿Es fijo? (true/false):");
		 int propietarioActual = pedirEnteroAlUsuario("Propietario actual:");
		 Date fechaVenta = null; // La fecha de venta se ingresa cuando se vende la obra
		 String productor = pedirCadenaAlUsuario("Productor:");
		 String guionista = pedirCadenaAlUsuario("Guionista:");
		 ArrayList<String> reparto = pedirListaCadenas("Reparto (separe los nombres con comas): ");
		 String idioma = pedirCadenaAlUsuario("Idioma:");
		 float duracion = pedirFloatAlUsuario("Duración:");

		 String mensaje = galeria.IngresarVideoConsignacion(fechaIngreso, titulo, anio, lugar, autor, exhibicion, estado, valor,
		            esFijo, propietarioActual, fechaVenta, productor, guionista, reparto, idioma, duracion);
		 System.out.println(mensaje);
		 
		 System.out.println("El empleado se resgistró correctamente.");
	 
	 }
	 
	 
	 public void consultarHistorialDeUnaPieza()
	 {
		 Galeria galeria = new Galeria(); 
		 int identificador = pedirEnteroAlUsuario("Ingrese su identificador de administrador: ");
		 int codigoRegistro = pedirEnteroAlUsuario("Ingrese el código de registro de la pieza de la que dese ver el historial:  ");
		 Empleado empleado = galeria.obtenerAdministradorPorIdentificacion(identificador); 
		 
		 String historialArtista = empleado.verHistorialPieza(codigoRegistro);
	        System.out.println(historialArtista);
	        
	 }
	 
	 
	 public void consultarHistorialDePago()
	 {
		 Galeria galeria = new Galeria(); 
		 int identificador = pedirEnteroAlUsuario("Ingrese su identificador de administrador: ");
		 Empleado empleado = galeria.obtenerAdministradorPorIdentificacion(identificador);
		 
		 ArrayList<Pago> historialPagos = empleado.consultarHistorialPagosRealizados();
		 
		 for (Pago pago : historialPagos) {
	            System.out.println("Tipo de pago: " + pago.getTipoPago() + ", Valor: " + pago.getValor());
	        }
	 }
	 
	 
	 public void consultarHistorialDeUnArtista()
	 {
		 Galeria galeria = new Galeria(); 
		 int identificador = pedirEnteroAlUsuario("Ingrese su identificador de administrador: ");
		 Empleado empleado = galeria.obtenerAdministradorPorIdentificacion(identificador);

	     String nombreArtista = pedirCadenaAlUsuario("Ingrese el nombre del artista que desea consultar: ");
	     Artista artista = galeria.obtenerArtistaPorNombre(nombreArtista); 

	     if (artista != null) {
	         String historial = empleado.buscarHistorialArtista(artista);
	         System.out.println(historial);
	     }
	     else {
	         System.out.println("No se encontró un artista con el nombre " + nombreArtista);
	        }
	 }
	 
	 
	 public void consultarHistorialDeUnComprador()
	 {
		 Galeria galeria = new Galeria(); 
		 int identificadorAdministrador = pedirEnteroAlUsuario("Ingrese su identificador de administrador: ");
		 int identificadorCliente = pedirEnteroAlUsuario("Ingrese el identificador del cliente del que desea consultar el historial: ");
		 Cliente cliente = galeria.buscarClientePorIdentificacion(identificadorCliente);
		 Empleado empleado = galeria.obtenerAdministradorPorIdentificacion(identificadorAdministrador);
		 
		 String historialComprador = empleado.mostrarHistorialPropiedadCliente(cliente, empleado);
		 System.out.println(historialComprador);
	 }
	 
}
