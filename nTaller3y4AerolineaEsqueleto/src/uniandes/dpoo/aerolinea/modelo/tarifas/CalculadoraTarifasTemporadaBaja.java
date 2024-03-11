package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas 
{
	
	/**
     * El costo por kilómetro en temporada baja para personas naturales
     */
	protected final int COSTO_POR_KM_NATURAL = 600;
	
	/**
     * El costo por kilómetro en temporada baja para clientes corporativos
     */
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
	
	/**
     * El descuento que se le puede aplicar a empresas pequeñas
     */
	protected final double DESCUENTO_PEQ = 0.02;
	
	/**
     * El descuento que se le puede aplicar a empresas medianas
     */
	protected final double DESCUENTO_MEDIANAS = 0.1;
	
	/**
     * El descuento que se le puede aplicar a empresas grandes
     */
	protected final double DESCUENTO_GRANDES = 0.2;
	
	// ************************************************************************************
    //
    // Estos son los métodos que están relacionados con la manipulación básica de los atributos
    // del calculo de la tarifa en temporada baja de acuerdo al cliente y el vuelo
    //
    // ************************************************************************************

	/**
     * Calcula el costo base como COSTO_POR_KM x distancia.
     */
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) 
	{
		double distancia = super.calcularDistanciaVuelo(vuelo.getRuta());
		
		double costoBase = 0;
		
		if (cliente.getTipoCliente()== "Natural") {
			costoBase = COSTO_POR_KM_NATURAL * distancia;
		}
		
		if (cliente.getTipoCliente()== "Corporativo") {
			costoBase = COSTO_POR_KM_CORPORATIVO * distancia;
		}

	    return (int) costoBase;
	}
	
	/**
     * Calcula el porcentaje de descuento que se le debería dar a un cliente dado su tipo y/o su historia. 
     */
	protected double calcularPorcentajeDescuento(Cliente cliente) 
	{
		double porcentajeDescuento = 0;
	    
	    if (cliente instanceof ClienteCorporativo) {
	        ClienteCorporativo clienteCorporativo = (ClienteCorporativo) cliente;
	        switch (clienteCorporativo.getTamanoEmpresa()) {
	            case 1:
	                porcentajeDescuento = DESCUENTO_PEQ;
	                break;
	            case 2:
	                porcentajeDescuento = DESCUENTO_MEDIANAS;
	                break;
	            case 3:
	                porcentajeDescuento = DESCUENTO_GRANDES;
	                break;
	            default:
	                porcentajeDescuento = 0; 
	                break;
	        }
	    }
	    
	    return porcentajeDescuento;
	}
}
