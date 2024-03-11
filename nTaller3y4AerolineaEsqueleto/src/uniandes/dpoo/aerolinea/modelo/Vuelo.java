package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

/**
 * Esta clase tiene la información de un vuelo con su respectiva información de fecha, ruta y tiquetes.
 */
public class Vuelo 
{
	
	/**
     * Un mapa con los vuelos que cubre la aerolínea.
     * 
     * Las llaves del mapa son el código del tiquete
     */
    private Map<String, Tiquete> tiquetes;
    
    /**
     * Un objeto con los atributos y métodos de la clase avión
     */
    private Avion avion;
    
    /**
     * Un objeto con los atributos y métodos de la calse ruta
     */
    private Ruta ruta;
    
    /**
     * Una cadena con la fecha del vuelo
     */
    private String fecha;
    
    /**
     * Construye un nuevo vuelo de acuerdo a una ruta, fecha y un avión
     */
	public Vuelo(Ruta ruta, String fecha, Avion avion)
    {
		this.fecha = fecha;
	    this.avion = avion;
	    this.ruta = ruta;  
    }
	
	// ************************************************************************************
    //
    // Estos son los métodos que están relacionados con la manipulación básica de los atributos
    // de los vuelos que pueden tomar los aviones
    //
    // ************************************************************************************
	
	/**
     * Retorna un mapa con los tiqutes 
     */
	public Collection<Tiquete> getTiquetes() 
	{
		return tiquetes.values();
	}
	
	/**
     * Retorna el avion del vuelo
     */
	public Avion getAvion() 
	{
		return avion;
	}
	
	/**
     * Retorna la ruta del vuelo
     */
	public Ruta getRuta() 
	{
		return ruta;
	}
	
	/**
     * Retorna la fecha del vuelo
     */
	public String getFecha() 
	{
		return fecha;
	}
	
	/**
     * Retorna la venta de una determinada cantidad de tiquetes para el vuelo y los deja registrados en el mapa de tiquetes
     */
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad)
	{
		int total = calculadora.calcularTarifa(this, cliente);
		int totalFinal = total* cantidad;
		
	    for (int i = 0; i < cantidad; i++) {
	        Tiquete tiquete = new Tiquete(cliente.getIdentificador(), this, cliente, total);
	        tiquetes.put(tiquete.getCodigo(), tiquete);
	    }
	    return totalFinal;
	}
	
	/**
     * Retorna un booleano dependiendo del caso en el que el objeto sea igual o no
     */
	public boolean equals(Object obj)
	{
		if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Vuelo otroVuelo = (Vuelo) obj;
	    return Objects.equals(ruta, otroVuelo.ruta) && Objects.equals(fecha, otroVuelo.fecha) && Objects.equals(avion, otroVuelo.avion);		
	}

}
