package uniandes.dpoo.aerolinea.modelo.cliente;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son personas naturales
 */
public class ClienteNatural extends Cliente 
{
	/**
     * Una cadena llamada natural inicializada con la cadena natural
     */
	public static final String NATURAL = "Natural";
	
	/**
     * Una cadena con el nombre de la persona natural
     */
	private String nombre;
	
	/**
     * Construye un nuevo cliente corporativo con un nombre de la empresa y el tamaño de esta
     */
	public ClienteNatural(String nombre)
    {
		super();
		this.nombre = nombre;
    }
	
	// ************************************************************************************
    //
    // Estos son los métodos que están relacionados con la manipulación básica de los atributos
    // de los clientes naturales
    //
    // ************************************************************************************
	
	/**
     * Retorna el identificador de la persona
     */
	public String getIdentificador() 
	{
		return nombre;
	}
	
	/**
     * Retorna el tipo del cliente
     */
	public String getTipoCliente()
	{
		return NATURAL;
	}

}
