package central;

import java.io.Serializable;
import java.util.Date;

public class Oferta implements Serializable 
{

	private static final long serialVersionUID = 1L;
	//atributos
	private int codigoRegistro;
	private Date fechaSolicitud;
	private int ofertante; //identificación del cliente que crea la oferta
	private float valor;
	private String tipoDePago; 
	
	//constructor
	public Oferta (int codigoRegistro, Date fechaSolicitud, int ofertante, float valor, String tipoDePago) {
		this.fechaSolicitud = fechaSolicitud;
		this.ofertante = ofertante;
		this.valor = valor;
		this.tipoDePago = tipoDePago;
	}

	
	//métodos
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public int getOfertante() {
		return ofertante;
	}

	public float getValor() {
		return valor;
	}
	
	public String getTipoDePago() {
		return tipoDePago;
	}
	
	public int getCodigoRegistro() {
		return codigoRegistro;
	}
	
}
