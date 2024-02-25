package uniandes.dpoo.aerolinea.modelo.tarifas;


import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

/**
 * Esta clase abstracta define el contrato para las posibles calculadoras de tarifa e implementa algunos métodos que pueden ser utilizadas en varias implementaciones.
 */
public abstract class CalculadoraTarifas 
{
	
	/**
     * El porcentaje que corresponde al impuesto sobre la costo base
     */
	public static final double IMPUESTO = 0.28;
	
	
	// ************************************************************************************
    //
    // Estos son los métodos que están relacionados con la manipulación básica de los atributos
    // del calculo ed lasas tarifas de loss tiquetes dependiendo del cliente y el vuelo
    //
    // ************************************************************************************
	
	/**
     * Calcula cuál debe ser la tarifa total para un vuelo, dado el vuelo y el cliente. 
     * La tarifa total está constituída por un costo base, un descuento, y un impuesto que se aplica sobre el costo base menos el descuento 
     */
	public int calcularTarifa(Vuelo vuelo, Cliente cliente)
	{
		// TODO implementar
		return 0;
	}
	
	// Métodos abstractos que deben ser implementados por la calculadora de temporada alta y baja
	
	/**
     * Calcula cuál debe ser el costo base dado el vuelo y el cliente
     */
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

	/**
     * Calcula el porcentaje de descuento que se le debería dar a un cliente dado su tipo y/o su historia
     */
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	// Métodos concretos
	
	/**
     * Calcula la distancia aproximada en kilómetros para una ruta
     */
	protected int calcularDistanciaVuelo(Ruta ruta)
	{
		int radioTierra = 6371;
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		
		double latitudO = Math.toRadians(origen.getLatitud());
		double latitudD = Math.toRadians(destino.getLatitud());
		
		double longitudO = Math.toRadians(origen.getLongitud());
		double longitudD = Math.toRadians(destino.getLongitud());
		
		double diferenciaLatitud = latitudD - latitudO;
		double diferenciaLongitud = longitudD - longitudO;
		
		double a1 = Math.pow(Math.sin(diferenciaLatitud/2), 2) + Math.cos(latitudO)* Math.cos(latitudD)* Math.pow(Math.sin(diferenciaLongitud/2), 2);
		double c = Math.atan2(Math.sqrt(a1), Math.sqrt(1-a1));
		
		int distancia = (int)(radioTierra * c);
		
		return distancia;
	}
	
	/**
     * Calcula el valor de los impuestos para un tiquete, dado el costo base
     */
	protected int calcularValorImpuesos(int costoBase)
	{
		// TODO implementar
		return 0;
	}

}
