package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de un avión
 */
public class Avion 
{
	
	/**
     * El nombre del avión
     */
	private String nombre;
	
	/**
     * Un entero con la capacidad de pasajeros del avión
     */
	private int capacidad;
	
	/**
     * Construye un nuevo aeropuerto con un nombre, un código, una ciudad y una latitudo y longitud de acuerdo a su ubicación
     */
	public Avion(String nombre, int capacidad)
	{
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	
	// ************************************************************************************
    //
    // Estos son los métodos que están relacionados con la manipulación básica de los atributos
    // de los aviones
    //
    // ************************************************************************************

	/**
     * Retorna el nombre del avión
     */
	public String getNombre() {
		return nombre;
	}
	
	/**
     * Retorna la capacidad del avión
     */
	public int getCapacidad() {
		return capacidad;
	}
	
}
