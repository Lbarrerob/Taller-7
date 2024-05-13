package central;

import inventario.Ceramica;
import inventario.Escultura;
import inventario.Fotografia;
import inventario.Grabado;
import inventario.ObraDeArte;
import inventario.Pintura;
import inventario.Video;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import transacciones.Compra;
import transacciones.Pago;
import transacciones.Subasta;
import central.Artista;
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
	private HashMap<Integer,Cliente> clientesMap;
	private HashMap<Integer,Empleado> empleadosMap;
	private ArrayList<Artista> artistas;
	private ArrayList<Pago> pagosTransferencia;
	private ArrayList<Pago> pagosEfectivo;
	
	
	//constructor
	public Galeria()
	{
		this.piezas = new HashMap<Integer, ObraDeArte>(); 
		this.empleados = new ArrayList<Empleado>();
		this.clientes = new ArrayList<Cliente>();
		this.artistas = new ArrayList<Artista>();
		this.clientesMap = new HashMap<Integer,Cliente>();
		this.empleadosMap = new HashMap<Integer,Empleado>();
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

	public ArrayList<Artista> getArtistas() {
		return artistas;
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

	public HashMap<Integer,Cliente> getClientesMap() {
		return clientesMap;
	}


	public void setClientesMap(HashMap<Integer,Cliente> clientesMap) {
		this.clientesMap = clientesMap;
	}
	
	public HashMap<Integer,Empleado> getEmpleadosMap() {
		return empleadosMap;
	}


	public void setEmpleadosMap(HashMap<Integer,Empleado> empleadosMap) {
		this.empleadosMap = empleadosMap;
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
					empleadosMap.put(identificacion, nEmpleado);
				}
	 		}
		
	}
	
	
	public void registrarCliente (String nombre, int identificacion, int telefono, String correo, 
								String login, String password, double ingreso, double limiteCompra) 
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
					clientesMap.put(identificacion, nCliente);
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
	
	
	public Empleado obtenerEmpleadoPorIdentificacion(int identificacion) {
	    for (Empleado empleado : empleados) {
	        if (empleado.getIdentificacion() == identificacion) {
	            return empleado;
	        }
	    }
	    return null; // Retornar null si no se encuentra ningún empleado con esa identificación
	}
	
	
	public Artista obtenerArtistaPorNombre(String nombre) {
	    for (Artista artista : artistas) {
	        if (artista.getNombre() == nombre) {
	            return artista;
	        }
	    }
	    return null; // Retornar null si no se encuentra ningún empleado con esa identificación
	}
	
	public ArrayList<ObraDeArte> obtenerObrasPorCodigos(String codigos) {
        ArrayList<ObraDeArte> obras = new ArrayList<>();
        String[] codigoArray = codigos.split(",");
        for (String codigo : codigoArray) {
            try {
                Integer codigoInt = Integer.parseInt(codigo.trim());
                ObraDeArte obra = piezas.get(codigoInt);
                if (obra != null) {
                    obras.add(obra);
                }
            } catch (NumberFormatException e) {
                // Código no válido, ignorar o manejar el error según sea necesario
                System.out.println("Código no válido: " + codigo);
            }
        }
        return obras;
    }
	
	
	public Cliente buscarClientePorIdentificacion(int identificacion) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdentificacion() == identificacion) {
                return cliente;
            }
        }
        return null; // Retorna null si no se encuentra el cliente
    }
	
	
	public String IngresarPinturaConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, Artista autor, boolean exhibicion, String estado, int valor, 
										boolean esFijo, int propietarioActual, Date fechaVenta, float alto, float ancho, String tecnica, String periodo, String genero) 
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
		
		//crear y agregar la nueva pieza al mapa de piezas
		Pintura nPintura = new Pintura(codigoRegistro, "Pintura", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
										fechaVenta, fechaIngreso, alto, ancho, tecnica, periodo, genero);
		piezas.put(codigoRegistro, nPintura);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
	}
	
	
	public String IngresarEsculturaConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, Artista autor, boolean exhibicion, String estado, int valor, 
										boolean esFijo, int propietarioActual,Date fechaVenta, float alto, float ancho, float profundidad, String material)
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
				
		//crear y agregar la nueva pieza al mapa de piezas
		Escultura nEscultura = new Escultura (codigoRegistro, "Escultura", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
											fechaIngreso, fechaVenta, alto, ancho, profundidad, material);
		piezas.put(codigoRegistro, nEscultura);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
	}
	
	
	public String IngresarCeramicaConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, Artista autor, boolean exhibicion, String estado, int valor, 
										boolean esFijo, int propietarioActual, Date fechaVenta, float alto, float ancho, float profundidad, String tecnica) 
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
						
		//crear y agregar la nueva pieza al mapa de piezas
		Ceramica nCeramica = new Ceramica (codigoRegistro, "Cerámica", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
										fechaIngreso, fechaVenta, alto, ancho, profundidad, tecnica);
		piezas.put(codigoRegistro, nCeramica);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
	}
	
	
	public String IngresarGrabadoConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, Artista autor, boolean exhibicion, String estado, int valor, 
										boolean esFijo, int propietarioActual, Date fechaVenta, float alto, float ancho, float profundidad, String categoria, String material, String tecnica)
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
								
		//crear y agregar la nueva pieza al mapa de piezas
		Grabado nGrabado = new Grabado (codigoRegistro, "Grabado", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
										fechaIngreso, fechaVenta, alto, ancho, profundidad, categoria, material, tecnica);
		piezas.put(codigoRegistro, nGrabado);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
		
	}
	
	
	public String IngresarFotografiaConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, Artista autor, boolean exhibicion, String estado, int valor, 
											boolean esFijo, int propietarioActual, Date fechaVenta, float alto_cm, float ancho_cm, boolean color) 
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
										
		//crear y agregar la nueva pieza al mapa de piezas
		Fotografia nFotografia = new Fotografia (codigoRegistro, "Fotografia", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
												fechaIngreso, fechaVenta, alto_cm, ancho_cm, color);
		piezas.put(codigoRegistro, nFotografia);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
		
	}
	
	
	public String IngresarVideoConsignacion (Date fechaIngreso, String titulo, int anio, String lugar, Artista autor, boolean exhibicion, String estado, int valor, 
										boolean esFijo, int propietarioActual, Date fechaVenta, String productor, String guionista, ArrayList<String> reparto, String idioma, float duracion) 
	{
		//generar el nuevo codigo de registro de la pieza
		int codigoRegistro = piezas.keySet().size();
												
		//crear y agregar la nueva pieza al mapa de piezas
		Video nVideo = new Video (codigoRegistro, "Video", titulo, anio, lugar, autor, exhibicion, estado, valor, esFijo, propietarioActual,
								fechaIngreso, fechaVenta, productor, guionista, reparto, idioma, duracion);
		piezas.put(codigoRegistro, nVideo);
		
		//calcular fecha de devolucion de la pieza pasado el tiempo límite de consignacion
		Date fechaDevolucion = calcularFechaDevolucion(fechaIngreso);
		return "La pieza estará en consignación por 4 meses. En caso que no cambie su estado, se hará la devolución en la fecha: " 
				+ fechaDevolucion + ". Pasado este tiempo ya no hará parte del inventario de la galeria";
						
	}
	
	
	public void eliminarPiezaConsignacion(ObraDeArte pieza) 
	{
        Date fechaLimite = calcularFechaDevolucion(pieza.getFechaIngreso()); // Calcula la fecha límite
        Iterator<Map.Entry<Integer, ObraDeArte>> iterator = piezas.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, ObraDeArte> entry = iterator.next();
            ObraDeArte obra = entry.getValue();
            if (obra.equals(pieza) && obra.getFechaIngreso().before(fechaLimite)) {
                iterator.remove();
            }
        }
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
	
	public boolean verificarComprador(String login, String password, double limiteCompra) {
	    Cliente cliente = buscarClientePorLogin(login);
	    if (cliente != null && cliente.verificarLogin(login, password)) {
	        if (limiteCompra >= cliente.getIngreso()) {
	            return true;
	        }
	    }
	    return false;
	}
	
	
	private Cliente buscarClientePorLogin(String login) {
	    for (Usuario cliente : clientes) {
	        if (cliente instanceof Cliente && cliente.getLogin().equals(login)) {
	            return (Cliente) cliente;
	        }
	    }
	    return null;
	}
	
	public boolean verificarEmpleado(String login, String password) {
	    Empleado empleado = buscarEmpleadoPorLogin(login);
	    return empleado != null && empleado.verificarLogin(login, password);
	}

	private Empleado buscarEmpleadoPorLogin(String login) {
	    for (Usuario empleado : empleados) {
	        if (empleado instanceof Empleado && empleado.getLogin().equals(login)) {
	            return (Empleado) empleado;
	        }
	    }
	    return null;
	}
	
	
	public String comprarPiezas(String codigosRegistro, int identificacion, Date fecha, String tipoPago, Empleado empleado, Galeria galeria) {
	    String ans = "";
	    String[] codigos = codigosRegistro.split(", ");
	    String tipoSolicitud = "Compra";

	    // Crear una solicitud para el cliente
	    Solicitud solicitud = new Solicitud(fecha, tipoSolicitud, tipoPago, identificacion);
	    // Asociar las piezas solicitadas con la solicitud y el cliente
	    solicitud.crearSolicitudPiezas(codigosRegistro, identificacion);

	    for (String codigo : codigos) {
	        ObraDeArte pieza = piezas.get(Integer.parseInt(codigo));
	        Compra compra = new Compra(fecha, fecha, identificacion);
	        String estado_inicial = pieza.getEstado();

	        if (compra.verificarEstadoPieza(tipoSolicitud)) {
	            compra.bloquearPieza(pieza);
	            if (compra.verificarCompra()) {
	                compra.aprobarCompra();
	                compra.agregarPiezaMapaPropiedades(identificacion, galeria, codigosRegistro, pieza);
	                compra.actualizarPropietario(pieza, identificacion);
	                compra.agregarPiezaMapaCompras(identificacion, galeria, codigosRegistro, pieza);
	                compra.cambiarEstadoPieza(pieza);
	                Pago pago = new Pago(tipoPago, pieza.getValor(), identificacion, Integer.parseInt(codigo));
	                empleado.registrarPago(pago);
	                pieza.agregarPropietario(identificacion);
	                pieza.setFechaVenta(fecha);
	                ans = "La compra se realizó exitosamente";
	            } else {
	                compra.desbloquearPieza(pieza, estado_inicial);
	                ans = "La compra no se pudo realizar correctamente";
	            }
	        } else {
	            ans = "La pieza no se encuentra disponible para la venta";
	        }
	    }

	    return ans;
	}
	
	
	public String ofertarPiezas(String codigosRegistro, int oferta, int identificacion, Date fecha, String tipoPago, double limiteFecha, Empleado empleado, Galeria galeria, int valor_minimo) 
	{
	    String ans = "";
	    String[] codigos = codigosRegistro.split(", ");
	    String tipoSolicitud = "Subasta";

	    // Crear una solicitud para el cliente
	    Solicitud solicitud = new Solicitud(fecha, tipoSolicitud, tipoPago, identificacion);
	    // Asociar las piezas ofertadas con la solicitud y el cliente
	    solicitud.crearSolicitudPiezas(codigosRegistro, identificacion);

	    for (String codigo : codigos) {
	        ObraDeArte pieza = piezas.get(Integer.parseInt(codigo));
	        Subasta subasta = new Subasta(fecha, fecha, identificacion,pieza,valor_minimo);

	        if (subasta.verificarEstadoPieza(tipoSolicitud)) {
	            Cliente clienteBuscado = clientes.get(identificacion);
	            String login = clienteBuscado.getLogin();
	            String password = clienteBuscado.getPassword();
	            if (verificarComprador(login, password, limiteFecha)) {
	                if (subasta.verificarOferta(subasta, oferta)) {
	                    Pago pago = new Pago(tipoPago, pieza.getValor(), identificacion, Integer.parseInt(codigo));
	                    empleado.registrarPago(pago);
	                    subasta.actualizarPropietario(pieza, identificacion);
	                    subasta.agregarPiezaMapaPropiedades(identificacion, galeria, codigosRegistro, pieza);
	                    subasta.agregarPiezaMapaCompras(identificacion, galeria, codigosRegistro, pieza);
	                    subasta.cambiarEstadoPieza(pieza);
	                    pieza.agregarPropietario(identificacion);
	                    pieza.setFechaVenta(fecha);
	                } else {
	                    ans = "Oferta inválida";
	                }
	            } else {
	                ans = "El comprador no fue aprobado";
	            }
	        } else {
	            ans = "La pieza no se encuentra disponible para la venta";
	        }
	    }

	    return ans;
	}
}
	