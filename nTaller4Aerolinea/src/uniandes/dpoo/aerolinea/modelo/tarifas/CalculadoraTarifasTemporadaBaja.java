package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas{

	//atributos
	protected static final int COSTO_POR_KM_NATURAL = 600;
	protected static final int COSTO_POR_KM_CORPORATIVO = 900;
	protected static final double DESCUENTO_PEQ = 0.02;
	protected static final double DESCUENTO_MEDIANAS = 0.1;
	protected static final double DESCUENTO_GRANDES = 0.2;
	public static final double IMPUESTO = 0.28;
	
	//métodos
	@Override
	protected int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		int distancia = this.calcularDistanciaVuelo(vuelo.getRuta());
		if (cliente.getTipoCliente().equals("Corporativo")) {
			int costo = distancia*CalculadoraTarifasTemporadaBaja.COSTO_POR_KM_CORPORATIVO;
			return costo;
		}else {
			int costo = distancia*CalculadoraTarifasTemporadaBaja.COSTO_POR_KM_NATURAL;
			return costo;
		}
	}
	
	@Override
	protected double calcularPorcentajeDescuento(Cliente cliente) {
		if (cliente.getTipoCliente().equals("Corporativo")) {
			ClienteCorporativo castCliente = (ClienteCorporativo) cliente;
			if (castCliente.getTamanoEmpresa()==3) {
				double descuento = CalculadoraTarifasTemporadaBaja.DESCUENTO_GRANDES;
				return descuento;
			}else if (castCliente.getTamanoEmpresa()==2) {
				double descuento = CalculadoraTarifasTemporadaBaja.DESCUENTO_MEDIANAS;
				return descuento;
			}else {
				double descuento = CalculadoraTarifasTemporadaBaja.DESCUENTO_PEQ;
				return descuento;
			}	
		}else {
			return 0;
		}
	}
	
	
	
	
	
}
