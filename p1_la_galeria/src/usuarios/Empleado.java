package usuarios;

import java.util.ArrayList;
import java.util.HashMap;

import inventario.ObraDeArte;
import transacciones.Compra;
import transacciones.Pago;


@SuppressWarnings("unused")
public class Empleado extends Usuario
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//heredados
	private String nombre;
	private int identificacion; // identificador único
	private int telefono;
	private String correo;
	private String login;
	private String password;
	private ArrayList<Pago> pagosRealizados;
	
	//atributos
	private String tipo; //Administrador, Operador, Cajero
	
	
	//constuctor
	public Empleado(String nombre, int identificacion, int telefono, String correo, String login, String password, String tipo) 
	{
		super(nombre, identificacion, telefono, correo, login, password);
		// TODO Auto-generated constructor stub
		this.tipo = tipo;
		this.pagosRealizados = new ArrayList<>();
		
	}

	//metodos
	public String getTipo() {
		return tipo;
	}


	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}


	@Override
	public int getIdentificacion() {
		// TODO Auto-generated method stub
		return super.getIdentificacion();
	}


	@Override
	public int getTelefono() {
		// TODO Auto-generated method stub
		return super.getTelefono();
	}


	@Override
	public String getCorreo() {
		// TODO Auto-generated method stub
		return super.getCorreo();
	}


	@Override
	public String getLogin() {
		// TODO Auto-generated method stub
		return super.getLogin();
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}


	@Override
	public void setNewPassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		super.setNewPassword(oldPassword, newPassword);
	}

	public void registrarPago(Pago pago) {
        pagosRealizados.add(pago);
    }
	
	public String verHistorialPieza(int codigoRegistro, ArrayList<ObraDeArte> obras) 
	{
	    for (ObraDeArte obra : obras) {
	        if (obra.getCodigoRegistro() == codigoRegistro) {
	            StringBuilder sb = new StringBuilder();
	            sb.append("Historial de la pieza con código de registro ").append(codigoRegistro).append(":\n");
	            sb.append("Tipo de pieza: ").append(obra.getTipoPieza()).append("\n");
	            sb.append("Título: ").append(obra.getTitulo()).append("\n");
	            sb.append("Año: ").append(obra.getAnio()).append("\n");
	            sb.append("Lugar: ").append(obra.getLugar()).append("\n");
	            sb.append("Autor: ").append(obra.getAutor().getNombre()).append("\n");
	            sb.append("Exhibición: ").append(obra.isExhibicion() ? "Sí" : "No").append("\n");
	            sb.append("Estado: ").append(obra.getEstado()).append("\n");
	            sb.append("Valor: ").append(obra.getValor()).append("\n");
	            sb.append("Es valor fijo: ").append(obra.isEsValorFijo() ? "Sí" : "No").append("\n");
	            sb.append("Propietario actual: ").append(obra.getPropietarioActual()).append("\n");
	            sb.append("Fecha de venta: ").append(obra.getFechaVenta()).append("\n");
	            sb.append("Fecha de ingreso: ").append(obra.getFechaIngreso()).append("\n");
	            sb.append("Lista de propietarios: ").append(obra.getHistorialPropietarios()).append("\n");
	            
	            return sb.toString();
	        } 
	    }
	    return "No se encontró una obra de arte con el código de registro " + codigoRegistro;
	}
	
	public String buscarHistorialArtista(Artista artista) {
        StringBuilder historial = new StringBuilder();
        historial.append("Historial del artista ").append(artista.getNombre()).append(":\n");

        for (ObraDeArte obra : artista.getPiezasCreadas()) {
            historial.append("Pieza: ").append(obra.getTitulo())
                    .append(", Fecha de creación: ").append(obra.getAnio())
                    .append(", Estado: ").append(obra.getEstado())
                    .append(", Precio de venta: ").append(obra.getValor()).append("\n");
        }

        return historial.toString();
    }

	
	public String verHistorialComprador(Cliente cliente, Empleado empleado) {
	    if (!empleado.getTipo().equals("Administrador")) {
	        return "No tienes permiso para ver el historial de comprador";
	    }

	    StringBuilder historia = new StringBuilder();
	    historia.append("Historia del comprador ").append(cliente.getNombre()).append(":\n");

	    // Obtener todas las compras del comprador
	    HashMap<Integer, ObraDeArte> compras = cliente.consultarHistorialCompra();
	    if (compras.isEmpty()) {
	        historia.append("El comprador no ha realizado compras.\n");
	    } else {
	        historia.append("Compras realizadas:\n");
	        for (Compra compra : compras.values()) {
	            ObraDeArte piezaComprada = compra.getObrasCompradas().get(cliente.getCodigo());

	            historia.append("- Fecha de compra: ").append(compra.getFechaVenta())
	                    .append(", Pieza: ").append(piezaComprada.getTitulo())
	                    .append(", Precio: ").append(piezaComprada.getValor()).append("\n");
	        }
	    }

	    // Obtener todas las piezas de arte que son propiedad del comprador
	    HashMap<Integer, ObraDeArte> piezasPropiedad = cliente.consultarHistorialPropiedad();
	    if (piezasPropiedad.isEmpty()) {
	        historia.append("El comprador no es propietario de ninguna pieza de arte.\n");
	    } else {
	        historia.append("Piezas de arte en su propiedad:\n");
	        for (ObraDeArte piezaPropiedad : piezasPropiedad.values()) {
	            historia.append("- Título: ").append(piezaPropiedad.getTitulo())
	                    .append(", Fecha de compra: ").append(piezaPropiedad.getFechaVenta())
	                    .append(", Precio de compra: ").append(piezaPropiedad.getValor()).append("\n");
	        }
	    }

	    // Calcular el valor total de la colección del comprador
	    int valorTotal = cliente.calcularValorColeccion();
	    historia.append("Valor total de la colección: ").append(valorTotal);

	    return historia.toString();
	}
}

