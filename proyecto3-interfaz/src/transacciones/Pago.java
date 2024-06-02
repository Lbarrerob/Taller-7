package transacciones;

import java.io.Serializable;
<<<<<<< HEAD

@SuppressWarnings("unused")
public class Pago implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoPago;
	private double valor;
	private int identificacion_cliente;
	private int codigoRegistro;

	public Pago(String tipoPago, double valor, int identificacion_cliente, int codigoRegistro) {
		super();
		this.tipoPago = tipoPago;
		this.valor = valor;
		this.identificacion_cliente = identificacion_cliente;
		this.codigoRegistro = codigoRegistro;
=======
import java.util.HashMap;

@SuppressWarnings("unused")
public class Pago implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoPago;
	private double valor;
	private int identificacion_cliente;
	private int codigoRegistro;
	private HashMap<Integer, TarjetaCredito> tarjetas;
	
	public Pago(String tipoPago, double valor, int identificacion_cliente, int codigoRegistro) {
		super();
		this.tipoPago = tipoPago;
		this.valor = valor;
		this.identificacion_cliente = identificacion_cliente;
		this.codigoRegistro = codigoRegistro;
		this.tarjetas = new HashMap<Integer, TarjetaCredito>();
>>>>>>> branch 'main' of https://github.com/DPO-20241-GRUPO-1001/Proyecto_3.git
		
	}
	public String getTipoPago() {
		return tipoPago;
	}
	
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public double getValor() {
		return valor;
	}
	
	
}
