package consola;

<<<<<<< HEAD
import central.Artista;
=======
import inventario.Artista;
>>>>>>> branch 'main' of https://github.com/DPO-20241-GRUPO-1001/Proyecto_3.git
import central.Galeria;
import usuarios.Empleado;

public class ConsolaOperador extends ConsolaBasica
{
	private final String[] opcionesMenuPrincipal = new String[]{"Registrar nuevas ofertas de subasta", "Consultar el historial de un artista", "Consultar el historial de un comprador", "Salir"};

    public void mostrarMenuPrincipal() {
        int opcion = mostrarMenu("Bienvenido a la Galería Operador", opcionesMenuPrincipal);
        if (opcion == 1) 
        {
            registrarNuevaOferta();
        } 
        else if (opcion == 2) 
        {
            consultarHistorialDeUnaPieza();
        } 
        else if (opcion == 3) 
        {
            consultarHistorialDeUnArtista();
        } 
        else if (opcion == 4) 
        {
            System.out.println("Saliendo...");
            System.exit(0);
        } 
        else 
        {
            System.out.println("Opción no válida");
        }
        mostrarMenuPrincipal();
    }

    public void consultarHistorialDeUnaPieza() 
    {
        Galeria galeria = new Galeria();
        int identificador = pedirEnteroAlUsuario("Ingrese su identificador de administrador: ");
        int codigoRegistro = pedirEnteroAlUsuario("Ingrese el código de registro de la pieza de la que desea ver el historial: ");
        Empleado empleado = galeria.obtenerAdministradorPorIdentificacion(identificador);

        if (empleado != null) {
            String historialPieza = empleado.verHistorialPieza(codigoRegistro);
            System.out.println(historialPieza);
        } else {
            System.out.println("No se encontró un empleado con el identificador " + identificador);
        }
    }

    public void consultarHistorialDeUnArtista() 
    {
        Galeria galeria = new Galeria();
        int identificador = pedirEnteroAlUsuario("Ingrese su identificador de administrador: ");
        Empleado empleado = galeria.obtenerAdministradorPorIdentificacion(identificador);

        if (empleado != null) {
            String nombreArtista = pedirCadenaAlUsuario("Ingrese el nombre del artista que desea consultar: ");
            Artista artista = galeria.obtenerArtistaPorNombre(nombreArtista);

            if (artista != null) {
                String historial = empleado.buscarHistorialArtista(artista);
                System.out.println(historial);
            } else {
                System.out.println("No se encontró un artista con el nombre " + nombreArtista);
            }
        } else {
            System.out.println("No se encontró un empleado con el identificador " + identificador);
        }
    }

    private void registrarNuevaOferta() {
        // Implementación del método para registrar nuevas ofertas de subasta
    }
}
