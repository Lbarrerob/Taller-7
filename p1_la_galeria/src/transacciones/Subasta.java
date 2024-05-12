package transacciones;

import java.util.Date;
import java.util.HashMap;

import inventario.ObraDeArte;
import usuarios.Usuario;

@SuppressWarnings("unused")
public class Subasta extends Transaccion 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//heredados
	private Date fechaSolicitud;
	private Date fechaAprobacion;
	private int comprador;
	private ObraDeArte pieza;
	private int valor_minimo;
	private HashMap<Integer, Usuario> Empleados;
	private HashMap<Integer, Usuario> Clientes;
	private HashMap<Integer, ObraDeArte> solicitudCompra;
	private HashMap<Integer, ObraDeArte> solicitudSubasta;
	
		
	//constructor
	

	public Subasta(Date fechaSolicitud, Date fechaAprobacion, int comprador, ObraDeArte pieza, int valor_minimo) {
		super(fechaSolicitud, fechaAprobacion, comprador);
		this.pieza = pieza;
		this.valor_minimo = valor_minimo;
		this.Empleados = new HashMap<Integer, Usuario>( );
		this.Clientes = new HashMap<Integer, Usuario>( );
		this.solicitudCompra = new HashMap<Integer, ObraDeArte>( );
		this.solicitudSubasta = new HashMap<Integer, ObraDeArte>( );
	}

	//metodos
	
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
	
	public void setPieza(ObraDeArte pieza) {
		this.pieza = pieza;
	}


	public int getValor_minimo() {
		return valor_minimo;
	}


	public void setValor_minimo(int valor_minimo) {
		this.valor_minimo = valor_minimo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}


	public void setComprador(int comprador) {
		this.comprador = comprador;
	}


	public void setEmpleados(HashMap<Integer, Usuario> empleados) {
		Empleados = empleados;
	}


	public void setClientes(HashMap<Integer, Usuario> clientes) {
		Clientes = clientes;
	}


	public void setSolicitudCompra(HashMap<Integer, ObraDeArte> solicitudCompra) {
		this.solicitudCompra = solicitudCompra;
	}


	public void setSolicitudSubasta(HashMap<Integer, ObraDeArte> solicitudSubasta) {
		this.solicitudSubasta = solicitudSubasta;
	}
	
	public ObraDeArte getPieza() {
		return pieza;
	}
	
	public boolean  verificarOferta(Subasta subasta, int oferta) {
		 return subasta.getPieza().getValor_inicial()<oferta && oferta>subasta.getValor_minimo();
	 }
}