package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
	/**
     * Una cadena llamada corporativo inicializada con la cadena corporativo
     */
	public static final String CORPORATIVO = "Corporativo";
	
	/**
     * Un entero llamado grande e inicializado en uno
     */
	public int GRANDE = 1;
	
	/**
     * Un entero llamado mediana e inicializado en dos
     */
	public int MEDIANA = 2;
	
	/**
     * Un entero llamado pequeña e inicializada en tres
     */
	public int PEQUEÑA = 3;
	
	/**
     * Una cadena con el nombre de la empresa
     */
	private String nombreEmpresa;
	
	/**
     * Un entero con el tamaño de la empresa
     */
	private int tamanoEmpresa;
	
	/**
     * Construye un nuevo cliente corporativo con un nombre de la empresa y el tamaño de esta
     */
	public ClienteCorporativo(String nombreEmpresa, int tamano)
    {
		super();
		this.nombreEmpresa = nombreEmpresa;
	    this.tamanoEmpresa = tamano;
    }
	
	// ************************************************************************************
    //
    // Estos son los métodos que están relacionados con la manipulación básica de los atributos
    // de los clientes corporativos
    //
    // ************************************************************************************
	
	/**
     * Retorna el nombre de la empresa
     */
	public String getNombreEmpresa()
	{
		return nombreEmpresa;
	}
	
	/**
     * Retorna el nombre de la empresa
     */
	public int getTamanoEmpresa()
	{
		return tamanoEmpresa;
	}
	
	/**
     * Retorna el tipo del cliente
     */
	public String getTipoCliente()
	{
		return CORPORATIVO;
	}
	
	/**
     * Retorna el identificador de la empresa
     */
	public String getIdentificador() 
	{
		return nombreEmpresa;
    }
	
    /**
     * Crea un nuevo objeto de tipo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
    public static ClienteCorporativo cargarDesdeJSON( JSONObject cliente )
    {
        String nombreEmpresa = cliente.getString( "nombreEmpresa" );
        int tam = cliente.getInt( "tamanoEmpresa" );
        return new ClienteCorporativo( nombreEmpresa, tam );
    }

    /**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON( )
    {
        JSONObject jobject = new JSONObject( );
        jobject.put( "nombreEmpresa", this.nombreEmpresa );
        jobject.put( "tamanoEmpresa", this.tamanoEmpresa );
        jobject.put( "tipo", CORPORATIVO );
        return jobject;
    }
}
