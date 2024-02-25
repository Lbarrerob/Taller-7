package uniandes.dpoo.aerolinea.persistencia;

import java.io.IOException;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

/**
 * Esta interfaz define las operaciones relacionadas con la persistencia de las aerolíenas (salvar y cargar)
 */
public interface IPersistenciaAerolinea 
{
	/**
     * Carga la información de todos los elementos de una aerolínea, excepto los clientes y tiquetes , y actualiza la estructura de objetos que se encuentra dentro de la aerolínea
     */
	public void cargarAerolinea(String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException;
	
	/**
     * Salva en un archivo la información de todos los elementos de una aerolínea, excepto los clientes y tiquetes
     */
	public void salvarAerolinea(String archivo, Aerolinea aerolinea)throws IOException;
}
	