package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

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

	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}
 
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		// TODO Auto-generated method stub
		return 0;
	}

}
