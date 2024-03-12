package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifasTemporadaBaja;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {

	//atributos
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	protected String identificador;
	
	//contructor
	public Cliente ()
	{
		tiquetesSinUsar = new ArrayList<Tiquete>();
		tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	//métodos
	public abstract String getTipoCliente ();
	
	public String getIdentificador (){
		return this.identificador;
	}
	
	public void agregarTiquete (Tiquete tiquetes){
		this.tiquetesSinUsar.add(tiquetes);
	}
	
	public int calcularValorTotalTiquetes ()
	{
		int precio = 0;
		for (Tiquete tiquete : tiquetesUsados) {
			precio = precio + tiquete.getTarifa();
		}
		for (Tiquete tiquete : tiquetesSinUsar) {
			precio = precio + tiquete.getTarifa();
		}
		return precio;
	}
	
	public void usarTiquetes (Vuelo vuelo)
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














