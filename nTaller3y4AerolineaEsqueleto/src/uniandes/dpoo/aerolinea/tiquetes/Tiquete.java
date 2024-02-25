package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

/**
 * Esta clase tiene la información de un tiquete de acuerdo a la información del vuele y el cliente.
 */
public class Tiquete 
{
	
	/**
     * Un objeto con los atributos y métodos de la clase cliente
     */
    private Cliente cliente;
    
    /**
     * Un objeto con los atributos y métodos de la clase vuelo
     */
    private Vuelo vuelo;
    
    /**
     * Una cadena con el código del tiquete
     */
    private String codigo;
    
    /**
     * Un entero con la tarifa del tiquete
     */
    private int tarifa;
    
    /**
     * Un obooleano que indica false si el tiquete no fue usado y true si ya fue usado
     */
    private boolean usado;
    
    /**
     * Construye un nuevo tiquete con su respectivo código, el vuelo para el que se compró, el cliente y la tarifa
     */
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa)
	{
		this.codigo = codigo;
	    this.vuelo = vuelo;
	    this.cliente = clienteComprador;
	    this.tarifa = tarifa;
	    this.usado = false;
	}
	
	// ************************************************************************************
    //
    // Estos son los métodos que están relacionados con la manipulación básica de los atributos
    // de los tiquetes
    //
    // ************************************************************************************

	/**
     * Retorna el nombre del cliente
     */
	public Cliente getCliente()
	{
		return cliente;
	}
	
	/**
     * Retorna el vuelo
     */
	public Vuelo getVuelo()
	{
		return vuelo;
	}
	
	/**
     * Retorna el código del tiquete
     */
	public String getCodigo()
	{
		return codigo;
	}
	
	/**
     * Retorna la tarifa del tiquete
     */
	public int getTarifa()
	{
		return tarifa;
	}
	
	/**
     * Cambia el estado de uso del tiquete
     */
	public void marcarComoUsado()
	{
		usado = true;
	}
	
	/**
     * Indica si el tiquete ya fue usado
     */
	public boolean esUsado()
	{
		return usado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
