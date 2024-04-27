package transacciones;

import java.util.Date;
import java.util.HashMap;

import inventario.ObraDeArte;
import usuarios.Usuario;

public class Compra extends Transaccion
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//heredados
	private Date fechaSolicitud;
	private Date fechaAprobacion;
	private int comprador;
	private HashMap<Integer, Usuario> Empleados;
	private HashMap<Integer, Usuario> Clientes;
	private HashMap<Integer, ObraDeArte> solicitudCompra;
	private HashMap<Integer, ObraDeArte> solicitudSubasta;
		
	
	//constructor
	public Compra(Date fechaSolicitud, Date fechaAprobacion, int comprador) 
	{
		super(fechaSolicitud, fechaAprobacion, comprador);
		// TODO Auto-generated constructor stub
		this.Empleados = new HashMap<Integer, Usuario>( );
		this.Clientes = new HashMap<Integer, Usuario>( );
		this.solicitudCompra = new HashMap<Integer, ObraDeArte>( );
		this.solicitudSubasta = new HashMap<Integer, ObraDeArte>( );
	}


	//Métodos getters
	
	@Override
	public Date getFechaSolicitud() {
		// TODO Auto-generated method stub
		return super.getFechaSolicitud();
	}

	@Override
	public Date getFechaAprobacion() {
		// TODO Auto-generated method stub
		return super.getFechaAprobacion();
	}

	@Override
	public int getComprador() {
		// TODO Auto-generated method stub
		return super.getComprador();
	}

	@Override
	public HashMap<Integer, Usuario> getEmpleados() {
		// TODO Auto-generated method stub
		return super.getEmpleados();
	}

	@Override
	public HashMap<Integer, Usuario> getClientes() {
		// TODO Auto-generated method stub
		return super.getClientes();
	}

	@Override
	public HashMap<String, ObraDeArte> getSolicitudCompra() {
		// TODO Auto-generated method stub
		return super.getSolicitudCompra();
	}

	@Override
	public HashMap<String, ObraDeArte> getSolicitudSubasta() {
		// TODO Auto-generated method stub
		return super.getSolicitudSubasta();
	}
	