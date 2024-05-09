package usuarios;

import java.util.ArrayList;

import inventario.ObraDeArte;

public class Artista extends Usuario {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ObraDeArte> piezasCreadas;

    public Artista(String nombre, int identificacion, int telefono, String correo, String login, String password) {
        super(nombre, identificacion, telefono, correo, login, password);
        this.piezasCreadas = new ArrayList<>();
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
