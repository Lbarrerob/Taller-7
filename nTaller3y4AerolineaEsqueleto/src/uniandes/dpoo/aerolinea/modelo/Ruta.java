package uniandes.dpoo.aerolinea.modelo;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
	/**
     * El aeropuerto origen de la ruta
     */
	private Aeropuerto origen;
	
	/**
     * El aeropuerto destino de la ruta
     */
	private Aeropuerto destino;
	
	/**
     * Una cadena con la hora de salida de la ruta de avión
     */
	private String horaSalida;
	
	/**
     * Una cadena con la hora de llegada de la ruta de avión
     */
	private String horaLlegada;
	
	/**
     * Una cadena con el código de la ruta de avión
     */
	private String codigoRuta;
	
	/**
     * Construye un nuevo aeropuerto con un nombre, un código, una ciudad y una latitudo y longitud de acuerdo a su ubicación
     */
    public Ruta(Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada, String codigoRuta)
    {
    	this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.codigoRuta = codigoRuta;
    }
    
    // ************************************************************************************
    //
    // Estos son los métodos que están relacionados con la manipulación básica de los atributos
    // de las rutas que pueden tomar los aviones
    //
    // ************************************************************************************

    /**
     * Retorna el aeropuerto origen de la ruta
     */
    public Aeropuerto getOrigen() {
		return origen;
	}

    /**
     * Retorna el aeropuerto destino de la ruta
     */
	public Aeropuerto getDestino() {
		return destino;
	}

	/**
     * Retorna la hora de salida de la ruta
     */
	public String getHoraSalida() {
		return horaSalida;
	}

	/**
     * Retorna la hora de llegada de la ruta
     */
	public String getHoraLlegada() {
		return horaLlegada;
	}

	/**
     * Retorna el código de la ruta
     */
	public String getCodigoRuta() {
		return codigoRuta;
	}
	
	/**
     * Retorna la duración del vuelo de la ruta
     */
	public int getDuracion() {
		LocalTime salida = LocalTime.parse(horaSalida);
        LocalTime llegada = LocalTime.parse(horaLlegada);
        long duracionMinutos = ChronoUnit.MINUTES.between(salida, llegada);
        if (duracionMinutos < 0) {
            duracionMinutos += 24 * 60; 
        }
        return (int) duracionMinutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

	/**
     * Dada una cadena con una hora y minutos, retorna las horas.
     *     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }
}
