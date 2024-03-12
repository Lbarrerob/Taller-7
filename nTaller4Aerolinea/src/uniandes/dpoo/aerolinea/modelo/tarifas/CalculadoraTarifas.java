package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas {

	//atributos
	public static final double IMPUESTO = 0.28;
	
	//métodos
	//TODO implementar
	public int calcularTarifa (Vuelo vuelo, Cliente cliente) 
	{
		int base = this.calcularCostoBase(vuelo, cliente);
		int impuestos = this.calcularValorImpuestos(base);
		int descuento = (int)(base * this.calcularPorcentajeDescuento(cliente));
		
		int tarifa = base + impuestos - descuento;
		return tarifa;
	}

	protected abstract int calcularCostoBase (Vuelo vuelo, Cliente cliente);
	
	protected abstract double calcularPorcentajeDescuento (Cliente cliente);
	

	//TODO implementar
	protected int calcularDistanciaVuelo (Ruta ruta) 
	{
		int distancia = Aeropuerto.calcularDistancia(ruta.getDestino(), ruta.getOrigen());
		return distancia;
	}
	
	//TODO implementar
	protected int calcularValorImpuestos (int costoBase) 
	{
		double impuestos = costoBase*0.28;
		return (int) Math.ceil(impuestos);
	}
	
}


