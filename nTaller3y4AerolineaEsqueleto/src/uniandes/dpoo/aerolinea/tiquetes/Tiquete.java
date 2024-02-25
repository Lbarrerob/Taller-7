package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete {

	//atributos
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	private Cliente cliente;
	
	//constructor
	public Tiquete (String codigo, Vuelo vuelo, Cliente clineteComprador, int tarifa)
	{
		this.codigo = codigo;
		this.vuelo = vuelo;
		this.cliente = clineteComprador;
		this.tarifa = tarifa;
	}

	//métodos
	public String getCodigo() {
		return codigo;
	}

	public int getTarifa() {
		return tarifa;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void marcarComoUsado() 
	{
		if (!this.usado == true) {
			this.usado = true;
		}
	}
	
	public boolean esUsado()
	{
		boolean siUsa = false;
		if (this.usado == true) {
			siUsa = true;
		}
		return siUsa;
	}
	
}
