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

	private Date fechaAprobacion;
	private HashMap<Integer, Usuario> Empleados;
	private HashMap<Integer, Usuario> Clientes;
	
	
	//constructor
	public Transaccion (Date fechaAprobacion)
	{
		this.fechaAprobacion = fechaAprobacion;
		this.Empleados = new HashMap<Integer, Usuario>( );
		this.Clientes = new HashMap<Integer, Usuario>( );

	}
	
	//Métodos getters

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public HashMap<Integer, Usuario> getEmpleados() {
		return Empleados;
	}

	public HashMap<Integer, Usuario> getClientes() {
		return Clientes;
	}
	
	
	//Métodos específicos
	
	
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

}