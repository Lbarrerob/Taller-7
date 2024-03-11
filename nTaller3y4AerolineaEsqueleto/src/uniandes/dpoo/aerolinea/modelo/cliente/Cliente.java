package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.LinkedList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

/**
 * En esta clase se organizan todos los aspectos relacionados con un Cliente
 */
public abstract class Cliente 
{
	/**
     * Una lista con los tiquetes sin usar de los clientes 
     */
	private List<Tiquete> tiquetesSinUsar;
	
	/**
     * Una lista con los tiquetes usados de la aerolínea
     */
	private List<Tiquete> tiquetesUsados;
	
	/**
     * Construye un nuevo cliente con unos tiquetes sin usar y otros usados ambos inicialmente vacios
     */
	public Cliente()
	{
		tiquetesSinUsar = new LinkedList<Tiquete>( );
		tiquetesUsados = new LinkedList<Tiquete>( );
	}
	
	// ************************************************************************************
    //
    // Estos son los métodos que están relacionados con la manipulación básica de los atributos
    // de las clientes
    //
    // ************************************************************************************
	
	// Métodos abstractos que deben ser implementados por clientes naturales o corporativos
	
	/**
     * Retorna el tipo del cliente.
     */
	public abstract String getTipoCliente();

	/**
     * Retorna el identificador del cliente
     */
    public abstract String getIdentificador();
    
    // Métodos concretos
	
    /**
     * Agrega un nuevo tiquete a la lista de tiquetes (sin usar) que ha comprado el cliente
     */
	public void agregarTiquete (Tiquete tiquete) 
	{
		tiquetesSinUsar.add(tiquete);
	}
	
	/**
     * Calcula el valor total de los tiquetes que ha comprado un cliente
     */
	public int calcularValorTotalTiquetes() 
	{
		int valorTotal = 0;
        for (Tiquete tiquete : tiquetesSinUsar) {
            valorTotal += tiquete.getTarifa();
        }
        for (Tiquete tiquete : tiquetesUsados) {
            valorTotal += tiquete.getTarifa();
        }
        return valorTotal;
	}
	
	/**
     * Marca como usados todos los tiquetes del cliente qus se hayan realizado en el vuelo que llega por parámetro
     */
	public void usarTiquetes(Vuelo vuelo) 
	{
		for (Tiquete tiquete : tiquetesSinUsar) {
            if (tiquete.getVuelo().equals(vuelo)) {
                tiquetesUsados.add(tiquete);
                tiquetesSinUsar.remove(tiquete);
                break;
            }
	
		}
		
	}
	
}
