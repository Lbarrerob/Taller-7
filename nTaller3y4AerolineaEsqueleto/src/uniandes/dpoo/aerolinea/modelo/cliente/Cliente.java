package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.List;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {

	//atributos
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	
	//contructor
	public Cliente ()
	{
		tiquetesSinUsar = new ArrayList<Tiquete>();
		tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	//métodos
	public String getTipoCliente () 
	{
		return "cliente";
	}
	
	public String getIdentificador ()
	{
		return "identificador";
	}
	
	public void agregarTiquete (Tiquete tiquetes)
	{
		//algo pasa;
	}
	
	public int calcularValorTotalTiquetes ()
	{
		return 0;
	}
	
	public void usarTiquetes ()
	{
		//algo pasa;
	}
	
}














