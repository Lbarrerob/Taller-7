package central;

import java.io.Serializable;
import java.util.ArrayList;

import inventario.ObraDeArte;

public class Artista implements Serializable
{ 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ObraDeArte> piezasCreadas;
	private String nombre;

    public Artista(String nombre) {
    	this.nombre = nombre;
        this.piezasCreadas = new ArrayList<>();
    }

    public String getNombre() {
		return nombre;
	}

	public ArrayList<ObraDeArte> getPiezasCreadas() {
        return piezasCreadas;
    }

    public void agregarPiezaCreada(ObraDeArte pieza) {
        piezasCreadas.add(pieza);
    }

    public void eliminarPiezaCreada(ObraDeArte pieza) {
        piezasCreadas.remove(pieza);
    }
}