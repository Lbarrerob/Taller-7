package transacciones;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import central.Galeria;
import inventario.ObraDeArte;
import usuarios.Cliente;
import usuarios.Usuario;

public abstract class Transaccion implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//atributos
	private Date fechaSolicitud;
	private Date fechaAprobacion;
	private int comprador;
	private HashMap<Integer, Usuario> Empleados;
	private HashMap<Integer, Usuario> Clientes;
	private HashMap<Integer, Cliente> Clientes1;
	private HashMap<String, ObraDeArte> solicitudCompra;
	private HashMap<String, ObraDeArte> solicitudSubasta;
	
	
	//constructor
	public Transaccion (Date fechaSolicitud, Date fechaAprobacion, int comprador)
	{
		this.fechaSolicitud = fechaSolicitud;
		this.fechaAprobacion = fechaAprobacion;
		this.comprador = comprador;
		this.Empleados = new HashMap<Integer, Usuario>( );
		this.Clientes = new HashMap<Integer, Usuario>( );
		this.solicitudCompra = new HashMap<String, ObraDeArte>( );
		this.solicitudSubasta = new HashMap<String, ObraDeArte>( );
	}

	
	//Métodos getters
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public int getComprador() {
		return comprador;
	}

	public HashMap<Integer, Usuario> getEmpleados() {
		return Empleados;
	}

	public HashMap<Integer, Usuario> getClientes() {
		return Clientes;
	}

	public HashMap<String, ObraDeArte> getSolicitudCompra() {
		return solicitudCompra;
	}

	public HashMap<String, ObraDeArte> getSolicitudSubasta() {
		return solicitudSubasta;
	}
	
	
	//Métodos específicos
	
	public boolean verificarEstadoPieza (String tipoSolicitud)
	
	{
		HashMap<String, ObraDeArte> listaSolicitud = tipoSolicitud.equals("venta") ? solicitudCompra : tipoSolicitud.equals("subasta") ? solicitudSubasta : null;

	    if (listaSolicitud == null) 
	    {
	        return false; 
	    }

	    for (ObraDeArte obra : listaSolicitud.values()) {
	        if ((tipoSolicitud.equals("Compra") && !obra.getEstado().equals("En venta")) ||
	            (tipoSolicitud.equals("Subasta") && !obra.getEstado().equals("En subasta"))) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
	public void agregarPiezaMapaPropiedades(int idCliente, Galeria galeria, String codigoRegistro, ObraDeArte pieza) 
	{

		Cliente cliente = galeria.getClientesMap().get(idCliente);
		int idRegistro = Integer.parseInt(codigoRegistro);
		HashMap<Integer, ObraDeArte> mapa = cliente.consultarHistorialPropiedad();
		mapa.put(idRegistro,pieza);
		cliente.setHistorialPropiedad(mapa);
		
	}
	
	public void agregarPiezaMapaCompras(int idCliente, Galeria galeria, String codigoRegistro,ObraDeArte pieza)
	{
		Cliente cliente = galeria.getClientesMap().get(idCliente);
		int idRegistro = Integer.parseInt(codigoRegistro);
		HashMap<Integer, ObraDeArte> mapa = cliente.consultarHistorialCompra();
		mapa.put(idRegistro,pieza);
		cliente.setHistorialPropiedad(mapa);
	}
		
	public void actualizarPropietario(ObraDeArte pieza, int identificacion)
	{
		pieza.setPropietarioActual(identificacion);
	}
	
	public void cambiarEstadoPieza(ObraDeArte pieza)
	{
		pieza.setEstado("Vendida");
	}
	
	public void bloquearPieza (ObraDeArte pieza)
	{
		pieza.setEstado("En revision");
	}
	public void desbloquearPieza (ObraDeArte pieza, String estado)
	{
		pieza.setEstado(estado);
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
	    for (Usuario cliente : Clientes.values()) {
	        if (cliente instanceof Cliente && cliente.getLogin().equals(login)) {
	            return (Cliente) cliente;
	        }
	    }
	    return null;
	}

}