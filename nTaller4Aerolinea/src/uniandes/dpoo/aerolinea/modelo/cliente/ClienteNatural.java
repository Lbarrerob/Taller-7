package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.List;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class ClienteNatural extends Cliente {
	
	//atributos
	public static String NATURAL = "Natural";
	private String nombre;
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	protected String identificador;
	
	//constructor
	public ClienteNatural (String nombre)
	{
		this.nombre = nombre;
	}

	//métodos
	@Override
	public String getTipoCliente() {
		// TODO Auto-generated method stub
		return ClienteNatural.NATURAL;
	}

	@Override
	public String getIdentificador() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

}
