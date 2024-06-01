package central;

import java.util.Date;
import java.util.HashMap;

import inventario.ObraDeArte;

public class Solicitud 
{
	//atributos
	private Date fechaSolicitud;
	private String tipoPago; //efectivo o transferencia 
	private int comprador; //identificación del cliente que crea la solicitud
	private HashMap<Integer, ObraDeArte> solicitudPiezas; //K:codRegistroPieza - V:pieza
	
	private HashMap<Integer, ObraDeArte> piezas;
	
	
	//constructor
	public Solicitud (Date fechaSolicitud, String tipoPago, int comprador) 
	{
		this.fechaSolicitud = fechaSolicitud;
		this.tipoPago = tipoPago;
		this.comprador = comprador;
		this.solicitudPiezas = new HashMap<Integer, ObraDeArte>( );
	}


	//metodos
	public String getTipoPago() {
		return tipoPago;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public int getComprador() {
		return comprador;
	}
	
	public HashMap<Integer, ObraDeArte> getPiezas() {
		return piezas;
	}


	public HashMap<Integer, ObraDeArte> crearSolicitudPiezas(String codigosRegistro, int identificacionCliente) {
	    String[] codigos = codigosRegistro.split(", ");
	    for (String codigo : codigos) {
	        int codigoRegistro = Integer.parseInt(codigo);
	        ObraDeArte pieza = piezas.get(codigoRegistro);
	        if (pieza != null) {
	            pieza.setPropietarioActual(identificacionCliente); // Asociar el cliente a la obra de arte
	            solicitudPiezas.put(codigoRegistro, pieza);
	        }
	    }
	    return solicitudPiezas;
	}
	
}
