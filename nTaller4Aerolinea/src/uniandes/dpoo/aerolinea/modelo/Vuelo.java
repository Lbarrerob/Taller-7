package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.Map;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {

	//atributos
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	private Map<String, Tiquete> tiquetes;
	
	//constructor
	public Vuelo (Ruta ruta, String fecha, Avion avion)
	{
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
	}

	//métodos
	public String getFecha() {
		return fecha;
	}

	public Avion getAvion() {
		return avion;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public Collection<Tiquete> getTiquetes( ) {
		return tiquetes.values();
	}
	
	//TODO implementar venderTiquetes
	public int venderTiquetes (Cliente cliente, CalculadoraTarifas calculadora, int cantidad)
	{
		int tarifa = calculadora.calcularTarifa(this, cliente);
		int total = tarifa * cantidad;
		return total;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		try {
			Vuelo vueloPrueba = (Vuelo) obj;
			if (this.fecha.equals(vueloPrueba.getFecha()) && this.ruta.getCodigoRuta().equals(vueloPrueba.getRuta().getCodigoRuta())) {
				return true;
			
			} else {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
}
