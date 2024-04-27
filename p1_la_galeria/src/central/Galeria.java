package central;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import transacciones.Compra;
import transacciones.Subasta;
import inventario.Ceramica;
import inventario.Escultura;
import inventario.Fotografia;
import inventario.Grabado;
import inventario.ObraDeArte;
import inventario.Pintura;
import inventario.Video;
import transacciones.Pago;
import usuarios.Cliente;
import usuarios.Empleado;
import usuarios.Usuario;

public class Galeria implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//atributos
	private HashMap<Integer, ObraDeArte> piezas;
	private ArrayList<Empleado> empleados;
	private ArrayList<Cliente> clientes;
	private ArrayList<Pago> pagosTransferencia;
	private ArrayList<Pago> pagosEfectivo;
	
	
	//constructor
	public Galeria()
	{
		this.piezas = new HashMap<Integer, ObraDeArte>(); 
		this.empleados = new ArrayList<Empleado>();
		this.clientes = new ArrayList<Cliente>();
		this.pagosTransferencia = new ArrayList<Pago>();
		this.pagosEfectivo = new ArrayList<Pago>();
		
	}
	
	
	//métodos
	public ArrayList<Empleado> consultarEmpleados() {
		return empleados;
	}
	
	public ArrayList<Cliente> consultarClientes() {
		return clientes;
	}

	public HashMap<Integer, ObraDeArte> consultarInventarioPieza() {
		return piezas;
	}

	public ArrayList<Pago> consultarHistorialPagosTranferencia() {
		return pagosTransferencia;
	}
	
	public ArrayList<Pago> consultarHistorialPagosEfectivo() {
		return pagosEfectivo;
	}
	
	
	public void registrarEmpleado (String nombre, int identificacion, int telefono, String correo, 
								String login, String password, String tipo) 
	{
		boolean existeEmpleado = false;
		boolean existeUsuario = false;
		
		for (Empleado empleado: empleados) {
			// Verificar si ya existe un empleado con el mismo tipo
			if (empleado.getTipo().equals(tipo)) {
				System.out.println("Ya existe un empleado con el mismo tipo.");
				existeEmpleado = true;
	            break;
			}
			
			// Verificar si el usuario ingresado ya está registrado
			if (empleado.getLogin().equals(login)) {
				System.out.println("El usuario ingresado ya existe.");
				existeUsuario = true;
	            break;
			}
		}
			
			
		//Para crear el nuevo empleado
		if (!existeEmpleado && !existeUsuario) {
				//Verificar longittud de la contraseña de 8 caracteres
				if (password.length() == 8) {
					System.out.println("La contraseña debe tener 8 caracteres.");
		 		        
				} else {
					//crear nuevo empleado y agregar a la lista de empleados
					Empleado nEmpleado = new Empleado (nombre, identificacion, telefono, correo, login, password, tipo);
					empleados.add(nEmpleado);
				}
	 		}
		
	}
	
	
	public void registrarCliente (String nombre, int identificacion, int telefono, String correo, 
								String login, String password, float ingreso, int limiteCompra) 
	{
		boolean existeUsuario = false;
		
		for (Cliente cliente : clientes) {
			//Verificar si el usuario ingresado ya está registrado
			if (cliente.getLogin().equals(login)) {
				System.out.println("El usuario ingresado ya existe.");
				existeUsuario = true;
	            break;
			}
		}
		
		
		//Para crear el nuevo cliente
		if (!existeUsuario) {
				//Verificar longittud de la contraseña de 8 caracteres
				if (password.length() == 8) {
					System.out.println("La contraseña debe tener 8 caracteres.");
				 		        
				} else {
					//crear nuevo empleado y agregar a la lista de empleados
					Cliente nCliente = new Cliente (nombre, identificacion, telefono, correo, login, password, ingreso, limiteCompra);
					clientes.add(nCliente);
				}
			 }
		
	}
	
	
	public Date calcularFechaDevolucion (Date fechaIngreso) 
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaIngreso);
		
		calendar.add(Calendar.MONTH, 4);
		Date fechaDevolucion = calendar.getTime();
		
		return fechaDevolucion;
	}
	

	public String IngresarPinturaConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, String autor, boolean exhibicion, String estado, int valor, 
										boolean esFijo, int propietarioActual, float alto, float ancho, String tecnica, String periodo, String genero) 
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
		
		//crear y agregar la nueva pieza al mapa de piezas
		Pintura nPintura = new Pintura(codigoRegistro, "Pintura", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
										alto, ancho, tecnica, periodo, genero);
		piezas.put(codigoRegistro, nPintura);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
	}
	
	
	public String IngresarEsculturaConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, String autor, boolean exhibicion, String estado, int valor, 
										boolean esFijo, int propietarioActual, float alto, float ancho, float profundidad, String material)
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
				
		//crear y agregar la nueva pieza al mapa de piezas
		Escultura nEscultura = new Escultura (codigoRegistro, "Escultura", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
											alto, ancho, profundidad, material);
		piezas.put(codigoRegistro, nEscultura);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
	}
	
	
	public String IngresarCeramicaConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, String autor, boolean exhibicion, String estado, int valor, 
										boolean esFijo, int propietarioActual, float alto, float ancho, float profundidad, String tecnica) 
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
						
		//crear y agregar la nueva pieza al mapa de piezas
		Ceramica nCeramica = new Ceramica (codigoRegistro, "Cerámica", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
										alto, ancho, profundidad, tecnica);
		piezas.put(codigoRegistro, nCeramica);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
	}
	
	
	public String IngresarGrabadoConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, String autor, boolean exhibicion, String estado, int valor, 
										boolean esFijo, int propietarioActual, float alto, float ancho, float profundidad, String categoria, String material, String tecnica)
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
								
		//crear y agregar la nueva pieza al mapa de piezas
		Grabado nGrabado = new Grabado (codigoRegistro, "Grabado", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
										alto, ancho, profundidad, categoria, material, tecnica);
		piezas.put(codigoRegistro, nGrabado);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
		
	}
	
	
	public String IngresarFotografiaConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, String autor, boolean exhibicion, String estado, int valor, 
											boolean esFijo, int propietarioActual, float alto_cm, float ancho_cm, boolean color) 
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
										
		//crear y agregar la nueva pieza al mapa de piezas
		Fotografia nFotografia = new Fotografia (codigoRegistro, "Fotografia", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
												alto_cm, ancho_cm, color);
		piezas.put(codigoRegistro, nFotografia);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
		
	}
	
	
	public String IngresarVideoConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, String autor, boolean exhibicion, String estado, int valor, 
										boolean esFijo, int propietarioActual, String productor, String guionista, ArrayList<String> reparto, String idioma, float duracion) 
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
												
		//crear y agregar la nueva pieza al mapa de piezas
		Video nVideo = new Video (codigoRegistro, "Video", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
								productor, guionista, reparto, idioma, duracion);
		piezas.put(codigoRegistro, nVideo);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
						
	}
	
	
	public void eliminarPiezaConsignacion (ObraDeArte pieza)
	{
		//TODO eliminar pieza del inventario pasada la fecha límite
		//Tener en cuenta el código de registro de cada pieza y la fecha de ingreso de la pieza
	}
	
	
	private Usuario buscarUsuario(String login, String password) 
	{
		for (Usuario usuario : empleados) {
            if (usuario.getLogin().equals(login) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
		
        for (Usuario usuario : clientes) {
            if (usuario.getLogin().equals(login) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null; 
	}
	
	
	public void accederSistema (String login, String password)
	{
		Usuario usuario = buscarUsuario(login, password);
		if(usuario != null){
			System.out.println("Bienvenido " + usuario.getNombre() + ", ha accedido al sistema.");
			
		} else {
			System.out.println("Usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
		}
	}
	
	public String comprarPiezas (String codigosRegistro, int identificacion, Date fecha, String tipoPago )
	{

		String ans = "";
		String[] codigos = codigosRegistro.split(", ");
		String tipoSolicitud = "Compra";

		for (String codigo : codigos) {

			ObraDeArte pieza = obras.get(codigo);

			Compra compra = new Compra(fecha,fecha,identificacion);
			
			String estado_inicial = pieza.getEstado();

			if (compra.verificarEstadoPieza(tipoSolicitud)) {

				compra.bloquearPieza(pieza);
				if (compra.verificarCompra()) {
					//compra.aprobarCompra();?
					compra.agregarPiezaMapaPropiedades(identificacion,codigosRegistro,pieza);
					compra.actualizarPropietario(pieza,identificacion);
					compra.agregarPiezaMapaCompras(identificacion,codigosRegistro,pieza);
					compra.cambiarEstadoPieza(pieza);
					compra.eliminarPiezaMapaPropiedad(identificacion,codigosRegistro,pieza);
					Pago pago = new Pago(tipoPago,pieza.getValor(),identificacion,Integer.parseInt(codigo));
					Empleado.registrar_pago(pagos, pago);
					ans = "La compra se realizó exitosamente";

				}else {
					compra.desbloquearPieza(pieza, estado_inicial);
					ans = "La compra no se pudo realizar correctamente";
				}
			}else {

				ans = "La pieza no se encuentra disponible para la venta";
			}
		}	

		return ans;
	}
	
	public String ofertarPiezas (String codigosRegistro, int oferta, int identificacion, Date fecha, String tipoPago)
	{

		String ans = "";
		String[] codigos = codigosRegistro.split(", ");
		String tipoSolicitud = "Subasta";
		for (String codigo : codigos) {
			ObraDeArte pieza = obras.get(codigo);
			Subasta subasta = new Subasta(fecha,fecha,identificacion);
			if (subasta.verificarEstadoPieza(tipoSolicitud)) {
				if (subasta.verificarComprador()) {
					//TODO funcion verificarComprador	
					if (verificarOferta(subasta, oferta))  {
						Pago pago = new Pago(tipoPago,pieza.getValor(),identificacion,Integer.parseInt(codigo));
						Empleado.registrar_pago(pagos, pago);
						subasta.actualizarPropietario(pieza,identificacion);
						subasta.agregarPiezaMapaPropiedades(identificacion,codigosRegistro,pieza);
						subasta.agregarPiezaMapaCompras(identificacion,codigosRegistro,pieza);
						subasta.cambiarEstadoPieza(pieza);
						subasta.eliminarPiezaMapaPropiedad(identificacion,codigosRegistro,pieza);
					} else {
						ans="Oferta inválida";
					}
				}else {
					ans = "El comprador no fué aprobado";
				}
			}else {
				ans = "La pieza no se encuentra disponible para la venta";
			}
		}	
		return ans; 
	}
	
}
