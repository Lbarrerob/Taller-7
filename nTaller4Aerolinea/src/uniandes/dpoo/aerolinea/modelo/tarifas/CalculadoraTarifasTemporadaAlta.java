package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {

	//atributos
	protected static final int COSTO_POR_KM = 1000;
	public static final double IMPUESTO = 0.28;
		
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) 
	{
		// TODO Auto-generated method stub
		int distancia = this.calcularDistanciaVuelo(vuelo.getRuta());
		int costo = distancia*CalculadoraTarifasTemporadaAlta.COSTO_POR_KM;
		return costo;
	}

	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) 
	{
		//No hay descuentos, se retorna 0
		return 0.0;
	}

}
