package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

/**
 * Esta clase se utiliza para calcular las tarifas en temporada alta, cuando los vuelos no tienen descuento y se aplica la misma tarifa por kilómetro a todos los clientes.
 */
public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas
{
	/**
     * El costo por kilómetro en temporada alta
     */
	protected final int COSTO_POR_KM = 1000;
	
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
	    double costoBase = COSTO_POR_KM * distancia;

	    return (int) costoBase;
	}
	
	/**
     * Calcula el porcentaje de descuento que se le debería dar a un cliente dado su tipo y/o su historia. 
     */
	protected double calcularPorcentajeDescuento(Cliente cliente) 
	{
		double porcentajeDescuento = 0;
		
		if (cliente.calcularValorTotalTiquetes() > 500000 && cliente.calcularValorTotalTiquetes() < 1999999) {
	        porcentajeDescuento += 0.05; 
	    }
		if (cliente.calcularValorTotalTiquetes() > 2000000 && cliente.calcularValorTotalTiquetes() < 4999999) {
	        porcentajeDescuento += 0.10; 
	    }
		if (cliente.calcularValorTotalTiquetes() > 5000000) {
	        porcentajeDescuento += 0.20; 
	    }

	    return porcentajeDescuento;
	}

}
