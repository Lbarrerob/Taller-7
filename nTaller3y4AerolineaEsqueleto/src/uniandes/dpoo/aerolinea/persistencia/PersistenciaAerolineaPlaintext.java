package uniandes.dpoo.aerolinea.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

/**
 * Esta clase no está implementada - y no debería implementarse como parte del taller.
 * Su objetivo es sólo ilustrar que podría haber varias implementaciones de la misma interfaz, y que durante la ejecución alguien podría decidir cuál de estas implementaciones
 * usar.
 */
public class PersistenciaAerolineaPlaintext implements IPersistenciaAerolinea
{
    @Override
    public void cargarAerolinea( String archivo, Aerolinea aerolinea ) throws FileNotFoundException, IOException
    {
    	try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            
            while ((linea = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                String tipoElemento = st.nextToken().trim();
                
                if (tipoElemento.equals("AVION")) {
                    String nombre = st.nextToken().trim();
                    int capacidad = Integer.parseInt(st.nextToken().trim());
                    Avion avion = new Avion(nombre, capacidad);
                    aerolinea.getAviones().add(avion);
                    
                } else if (tipoElemento.equals("RUTA")) {
                	Aeropuerto origen = new Aeropuerto(st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim(), Double.parseDouble(st.nextToken().trim()), Double.parseDouble(st.nextToken().trim()));
                    Aeropuerto destino = new Aeropuerto(st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim(), Double.parseDouble(st.nextToken().trim()), Double.parseDouble(st.nextToken().trim()));
                    String horaSalida = st.nextToken().trim();
                    String horaLlegada = st.nextToken().trim();
                    String codigoRuta = st.nextToken().trim();
                    Ruta ruta = new Ruta(origen, destino, horaSalida, horaLlegada, codigoRuta);
                    aerolinea.getRutas().add(ruta);
                    
                } else if (tipoElemento.equals("VUELO")) {
                    Ruta ruta = aerolinea.getRutas().stream()
                            .filter(r -> r.getCodigoRuta().equals(st.nextToken().trim()))
                            .findFirst().orElse(null);
                    String fecha = st.nextToken().trim();
                    Avion avion = aerolinea.getAviones().stream()
                            .filter(a -> a.getNombre().equals(st.nextToken().trim()))
                            .findFirst().orElse(null);
                    Vuelo vuelo = new Vuelo(ruta, fecha, avion);
                    aerolinea.getVuelos().add(vuelo);
                }
            }
        }
    }

    @Override
    public void salvarAerolinea( String archivo, Aerolinea aerolinea ) throws IOException
    {
    	try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) 
    	{
            // Guardar información de aviones
            for (Avion avion : aerolinea.getAviones()) {
                bw.write("AVION," + avion.getNombre() + "," + avion.getCapacidad());
                bw.newLine();
            }

            // Guardar información de rutas
            for (Ruta ruta : aerolinea.getRutas()) {
                bw.write("RUTA," + ruta.getOrigen().getNombre() + "," + ruta.getDestino().getNombre() + "," + ruta.getHoraSalida() + "," + ruta.getHoraLlegada() + "," + ruta.getCodigoRuta());
                bw.newLine();
            }

            // Guardar información de vuelos
            for (Vuelo vuelo : aerolinea.getVuelos()) {
                bw.write("VUELO," + vuelo.getRuta().getCodigoRuta() + "," + vuelo.getFecha() + "," + vuelo.getAvion().getNombre());
                bw.newLine();
            }
        }
    }

}
