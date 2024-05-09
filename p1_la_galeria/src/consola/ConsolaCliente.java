package consola;

import central.Galeria;
import java.util.ArrayList;
import java.util.Date;
import usuarios.Artista;
import usuarios.Empleado;

public class ConsolaCliente extends ConsolaBasica
{

	//Atributos
	
		 private final String[] opcionesMenuPrincipal = new String[] {"Realizar oferta de compra", "Realizar oferta de subasta", "Ingresar pieza a consignación", "Salir"};
		 private final String[] opcionesMenuIngresoObra = new String[] {"Ceramica", "Escultura", "Fotografía", "Grabado", "Pintura", "Video"};
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
		    	 ingresarPiezaConsignación();
		     }
		     
		     else if(opcion == 4)
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

		     String resultado = galeria.ofertarPiezas(codigosRegistro, oferta, identificacion, fecha, tipoPago, limiteFecha, empleado, galeria);
		     System.out.println(resultado);
		 }
		 
		 private void ingresarPiezaConsignación() 
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
		 
		
}
