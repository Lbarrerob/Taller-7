package transacciones;

import java.util.Date;
import java.util.HashMap;
<<<<<<< HEAD

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
	
=======
import java.util.Map;

import inventario.ObraDeArte;
import usuarios.Cliente;
import usuarios.Usuario;

@SuppressWarnings("unused")
public class Compra extends Transaccion
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//heredados

	private Date fechaAprobacion;
	private int comprador;
	private HashMap<Integer, Usuario> Empleados;
	private HashMap<Integer, Usuario> Clientes;
	private HashMap<Integer, ObraDeArte> solicitudCompra;
	private HashMap<Integer, ObraDeArte> obrasCompradas;
		
	
	//constructor
	public Compra(Date fechaAprobacion, int comprador) 
	{
		super(fechaAprobacion);
		// TODO Auto-generated constructor stub
		this.comprador = comprador;
		this.Empleados = new HashMap<Integer, Usuario>( );
		this.Clientes = new HashMap<Integer, Usuario>( );
		this.solicitudCompra = new HashMap<Integer, ObraDeArte>( );
		this.obrasCompradas = new HashMap<>();
	}


	//Métodos getters
	

	@Override
	public Date getFechaAprobacion() {
		// TODO Auto-generated method stub
		return super.getFechaAprobacion();
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

	public HashMap<String, ObraDeArte> getSolicitudCompra() {
		return getSolicitudCompra();
	}

    
	public int getComprador() {
		return comprador;
	}


	public boolean verificarCompra() {
	    double totalCompra = 0.0;
	    for (Map.Entry<Integer, ObraDeArte> entry : solicitudCompra.entrySet()) {
	        totalCompra += entry.getValue().getValor();
	    }
	    Cliente comprador = (Cliente) getClientes().get(getComprador()); // Suponiendo que getComprador() devuelve el ID del comprador
	    return totalCompra <= comprador.getIngreso();
	}
	
    public boolean aprobarCompra() {
        if (!verificarCompra()) {
            return false; // La compra no puede ser aprobada si no se cumple la verificación
        }

        // Mover las obras de arte de la solicitud de compra a la lista de obras compradas
        obrasCompradas.putAll(solicitudCompra);
        solicitudCompra.clear(); // Limpiar la solicitud de compra

        // Actualizar el historial de compras de los clientes
        for (Usuario usuario : Clientes.values()) {
            if (usuario instanceof Cliente) {
                Cliente cliente = (Cliente) usuario;
                cliente.consultarHistorialCompra().putAll(obrasCompradas);
            }
        }
        return true;
        
    }
    public ObraDeArte getPiezaComprada(int codigoRegistro) {
        return obrasCompradas.get(codigoRegistro);
    }
    
     
}
>>>>>>> branch 'main' of https://github.com/DPO-20241-GRUPO-1001/Proyecto_3.git
