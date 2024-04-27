package transacciones;

import java.io.Serializable;

public class Pago implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoPago;
	private int valor;
	private int identificacion_cliente;
	private int codigoRegistro;

	public Pago(String tipoPago, int valor, int identificacion_cliente, int codigoRegistro) {
		super();
		this.tipoPago = tipoPago;
		this.valor = valor;
		this.identificacion_cliente = identificacion_cliente;
		this.codigoRegistro = codigoRegistro;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
}
