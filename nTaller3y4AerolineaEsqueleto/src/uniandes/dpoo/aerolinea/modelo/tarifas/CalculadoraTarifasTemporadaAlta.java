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
	
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}
 
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

}
