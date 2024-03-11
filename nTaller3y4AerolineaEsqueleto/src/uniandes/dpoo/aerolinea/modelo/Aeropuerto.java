package uniandes.dpoo.aerolinea.modelo;

import java.util.HashSet;
import java.util.Set;

/**
 * Esta clase encapsula la información sobre los aeropuertos e implementa algunas operaciones relacionadas con la ubicación geográfica de los aeropuertos.
 * 
 * No puede haber dos aeropuertos con el mismo código.
 */
public class Aeropuerto
{
	/**
     * Una cadena con el nombre del aeropuerto
     */
	private String nombre;
	
	/**
     * Una cadena con el código del aeropuerto
     */
	private String codigo;
	
	/**
     * Una cadena con el nombre de la ciudad más próxima donde se encuentra el aeropuerto
     */
	private String nombreCiudad;
	
	/**
     * Un número con la latitud del aeropuerto de acuerdo a su ubicación
     */
	private double latitud;
	
	/**
     * Un número con la latitud del aeropuerto de acuerdo a su ubicación
     */
	private double longitud;
	
	/**
     * En este conjunto que es un atributo de clase, se almacenan los códigos de todos los aeropuertos que existen en el sistema en un momento dado
     */
	private static Set<String> codigoUtilizados;
    
	/**
     * Esta constante representa el radio terrestre y se utiliza como parte del cálculo de distancia entre aeropuertos
     */
	private static final int RADIO_TERRESTRE = 6371;
	
	/**
     * Construye un nuevo aeropuerto con un nombre, un código, una ciudad y una latitudo y longitud de acuerdo a su ubicación
     */
    public Aeropuerto(String nombre, String codigo, String nombreCiudad, double latitud, double longitud)
    {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nombreCiudad = nombreCiudad;
        this.latitud = latitud;
        this.longitud = longitud;
        
        if (codigoUtilizados == null) 
        {
        	codigoUtilizados = new HashSet<>();
        }
        codigoUtilizados.add(codigo);
    }
	
	// ************************************************************************************
    //
    // Estos son los métodos que están relacionados con la manipulación básica de los atributos
    // de los aeropuertos
    //
    // ************************************************************************************
	
    /**
     * Retorna el nombre del aeropuerto
     */
    public String getNombre() 
    {
		return nombre;
	}

    /**
     * Retorna el código del aeropuerto
     */
	public String getCodigo() 
	{
		return codigo;
	}
	
	/**
     * Retorna el nombre de la ciudad más cercana al aeropuerto
     */
	public String getNombreCiudad() 
	{
		return nombreCiudad;
	}

	/**
     * Retorna el número de la latitud de la ubicación del aeropuerto
     */
	public double getLatitud() 
	{
		return latitud;
	}

	/**
     * Retorna el número de la longitud de la ubicación del aeropuerto
     */
	public double getLongitud() 
	{
		return longitud;
	}
	
    /**
     * Este método calcula la distancia *aproximada* entre dos aeropuertos. Hay fórmulas más precisas pero esta es suficientemente buena para el caso de la aerolínea.
     * 
     * Este método asume que las coordenadas (latitud y longitud) de los aeropuertos están expresadas en la forma que las hace más cercanas. Si no es así, la distancia entre
     * los dos aeropuertos podría ser la más larga posible.
     * 
     * Por ejemplo, dependiendo de cómo estén expresadas las longitudes, la distancia calculada entre Narita (Tokyo) y El Dorado (Bogotá) podría ser atravesando el Pacífico, o
     * atravesando el Atlántico y Asia (el camino largo)
     * 
     * @param aeropuerto1
     * @param aeropuerto2
     * @return La distancia en kilómetros entre los puntos
     */
    public static int calcularDistancia( Aeropuerto aeropuerto1, Aeropuerto aeropuerto2 )
    {
        double latAeropuerto1 = Math.toRadians( aeropuerto1.getLatitud( ) );
        double lonAeropuerto1 = Math.toRadians( aeropuerto1.getLongitud( ) );
        double latAeropuerto2 = Math.toRadians( aeropuerto2.getLatitud( ) );
        double lonAeropuerto2 = Math.toRadians( aeropuerto2.getLongitud( ) );

        double deltaX = ( lonAeropuerto2 - lonAeropuerto1 ) * Math.cos( ( latAeropuerto1 + latAeropuerto2 ) / 2 );
        double deltaY = ( latAeropuerto2 - latAeropuerto1 );

        double distancia = Math.sqrt( deltaX * deltaX + deltaY * deltaY ) * RADIO_TERRESTRE;

        return ( int )Math.round( distancia );
    }
}
