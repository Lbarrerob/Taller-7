package uniandes.dpoo.aerolinea.persistencia;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

public class PersisitenciaAerolineaJson implements IPersistenciaAerolinea
{
	private static final String tipoCliente = null;
	private static final String identificador = null;
	private static final String nombre = null;
	private static final String capacidad = null;
	private static final String origen = null;
	private static final String destino = null;
	private static final String horaSalida = null;
	private static final String horaLlegada = null;
	private static final String codigoRuta = null;
	private static final String ruta = null;
	private static final String fecha = null;
	private static final String avion = null;

	/**
     * Carga la información de todos los elementos de una aerolínea, excepto los clientes y tiquetes , y actualiza la estructura de objetos que se encuentra dentro de la aerolínea 
     * @param archivo La ruta al archivo que contiene la información que se va a cargar
     * @param aerolinea La aerolínea dentro de la cual debe almacenarse la información
     * @throws IOException Se lanza esta excepción si hay problemas leyendo el archivo
     * @throws InformacionInconsistenteException Se lanza esta excepción si hay información inconsistente dentro del archivo, o entre el archivo y el estado de la aerolínea
     */
	@Override
    public void cargarAerolinea( String archivo, Aerolinea aerolinea ) throws IOException, InformacionInconsistenteException
    {
		String jsonCompleto = new String(Files.readAllBytes(new File(archivo).toPath()));
        JSONObject raiz = new JSONObject(jsonCompleto);

        // Cargar aviones
        JSONArray avionesArray = raiz.getJSONArray("aviones");
        for (int i = 0; i < avionesArray.length(); i++) {
            JSONObject avionJson = avionesArray.getJSONObject(i);
            Avion avion = new Avion(avionJson.getString("nombre"), avionJson.getInt("capacidad"));
            aerolinea.getAviones().add(avion);
        }

        // Cargar rutas
        JSONObject rutasObject = raiz.getJSONObject("rutas");
        for (String key : rutasObject.keySet()) {
            JSONObject rutaJson = rutasObject.getJSONObject(key);
            try {
                Aeropuerto origen = new Aeropuerto(rutaJson.getJSONObject("origen").getString("nombre"),
                        rutaJson.getJSONObject("origen").getString("codigo"),
                        rutaJson.getJSONObject("origen").getString("nombreCiudad"),
                        Double.parseDouble(rutaJson.getJSONObject("origen").getString("latitud")),
                        Double.parseDouble(rutaJson.getJSONObject("origen").getString("longitud")));
                Aeropuerto destino = new Aeropuerto(rutaJson.getJSONObject("destino").getString("nombre"),
                        rutaJson.getJSONObject("destino").getString("codigo"),
                        rutaJson.getJSONObject("destino").getString("nombreCiudad"),
                        Double.parseDouble(rutaJson.getJSONObject("destino").getString("latitud")),
                        Double.parseDouble(rutaJson.getJSONObject("destino").getString("longitud")));

                Ruta ruta = new Ruta(origen, destino, rutaJson.getString("horaSalida"),
                        rutaJson.getString("horaLlegada"), key);
                aerolinea.getRutas().add(ruta);
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir latitud o longitud a números en la ruta " + key);
            }
        }

        // Cargar vuelos
        JSONArray vuelosArray = raiz.getJSONArray("vuelos");
        for (int i = 0; i < vuelosArray.length(); i++) {
            JSONObject vueloJson = vuelosArray.getJSONObject(i);
            Ruta ruta = null;
            for (Ruta r : aerolinea.getRutas()) {
                if (r.getCodigoRuta().equals(vueloJson.getString("ruta"))) {
                    ruta = r;
                    break;
                }
            }
            Avion avion = null;
            for (Avion a : aerolinea.getAviones()) {
                if (a.getNombre().equals(vueloJson.getString("avion"))) {
                    avion = a;
                    break;
                }
            }
            if (ruta != null && avion != null) {
                Vuelo vuelo = new Vuelo(ruta, vueloJson.getString("fecha"), avion);
                aerolinea.getVuelos().add(vuelo);
            }
        }
    }

	/**
     * Salva en un archivo la información de todos los elementos de una aerolínea, excepto los clientes y tiquetes
     * @param archivo La ruta al archivo donde debe quedar almacenada la información
     * @param aerolinea La aerolínea que tiene la información que se quiere almacenar
     * @throws IOException Se lanza esta excepción si hay problemas escribiendo el archivo
     */
    @Override
    public void salvarAerolinea( String archivo, Aerolinea aerolinea )throws IOException
    {
    	JSONObject aerolineaJson = new JSONObject();

        // Convertir los aviones de la aerolínea a JSON
        JSONArray avionesJson = new JSONArray();
        for (Avion avion : aerolinea.getAviones())
        {
            JSONObject avionJson = new JSONObject();
            avionJson.put(nombre, avion.getNombre());
            avionJson.put(capacidad, avion.getCapacidad());

            avionesJson.put(avionJson);
        }
        aerolineaJson.put("aviones", avionesJson);

        // Convertir las rutas de la aerolínea a JSON
        JSONArray rutasJson = new JSONArray();
        for (Ruta ruta : aerolinea.getRutas()) 
        {
            JSONObject rutaJson = new JSONObject();
            rutaJson.put(origen, ruta.getOrigen().getNombre());
            rutaJson.put(destino, ruta.getDestino().getNombre());
            rutaJson.put(horaSalida, ruta.getHoraSalida());
            rutaJson.put(horaLlegada, ruta.getHoraLlegada());
            rutaJson.put(codigoRuta, ruta.getCodigoRuta());
            
            rutasJson.put(rutaJson);
        }
        aerolineaJson.put("rutas", rutasJson);

        // Convertir los vuelos de la aerolínea a JSON
        JSONArray vuelosJson = new JSONArray();
        for (Vuelo vuelo : aerolinea.getVuelos())
        {
            JSONObject vueloJson = new JSONObject();
            vueloJson.put(ruta, vuelo.getRuta().getCodigoRuta());
            vueloJson.put(fecha, vuelo.getFecha());
            vueloJson.put(avion, vuelo.getAvion().getNombre());
            
            vuelosJson.put(vueloJson);
        }
        aerolineaJson.put("vuelos", vuelosJson);
        
     // Convertir los clientes de la aerolínea a JSON
        JSONObject clientesJson = new JSONObject();
        for (Cliente cliente : aerolinea.getClientes()) {
            JSONObject clienteJson = new JSONObject();
            clienteJson.put(tipoCliente, cliente.getTipoCliente());
            clienteJson.put(identificador, cliente.getIdentificador());
            clientesJson.put(cliente.getIdentificador(), clienteJson);
        }
        aerolineaJson.put("clientes", clientesJson);
    	}
    }

 