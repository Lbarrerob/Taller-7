package usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import central.Artista;
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
	
	
	public int determinarValorMinimoOferta(ArrayList<ObraDeArte> obras) {
	    int totalValorMinimo = 0;
	    for (ObraDeArte obra : obras) {
	        if (obra.getEstado().equals("En subasta")) {
	            int valorMinimo = calcularValorMinimo(obra);
	            obra.setValor_minimo(valorMinimo);
	            System.out.println("Valor mínimo de oferta establecido para la obra " + obra.getCodigoRegistro() + ": " + valorMinimo);
	            totalValorMinimo += valorMinimo;
	        } else {
	            System.out.println("Acción no permitida para este empleado o estado de la obra incorrecto para la obra " + obra.getCodigoRegistro());
	        }
	    }
	    return totalValorMinimo;
	}
	

	private int calcularValorMinimo(ObraDeArte obra) 
	{
	    return (int)(obra.getValor() * 0.8); // 80% del valor de la obra
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

	
	public void mostrarHistorialPropiedadCliente(Cliente cliente,  Empleado empleado) {
		if (!empleado.getTipo().equals("Administrador")) {
	        System.out.println("No tienes permiso para realizar esta acción.");
	        return;
	    }

	    StringBuilder stringBuilder = new StringBuilder();
	    stringBuilder.append("Historial de propiedad de ").append(cliente.getNombre()).append(":\n");

	    // Mostrar todas las obras que ha comprado el cliente
	    stringBuilder.append("Obras compradas:\n");
	    for (Entry<Integer, ObraDeArte> entry : cliente.consultarHistorialCompra().entrySet()) {
	        ObraDeArte obra = entry.getValue();
	        stringBuilder.append("Obra: ").append(obra.getTitulo()).append(" - Fecha de compra: ").append(obra.getFechaVenta()).append("\n");
	    }

	    // Mostrar las obras que actualmente son de su propiedad
	    stringBuilder.append("Obras actuales del cliente:\n");
	    for (Entry<Integer, ObraDeArte> entry : cliente.consultarHistorialPropiedad().entrySet()) {
	        ObraDeArte obra = entry.getValue();
	        stringBuilder.append("Obra: ").append(obra.getTitulo()).append("\n");
	    }

	    // Calcular y mostrar el valor total de la colección
	    float valorTotalColeccion = 0;
	    for (ObraDeArte obra : cliente.consultarHistorialPropiedad().values()) {
	        valorTotalColeccion += obra.getValor();
	    }
	    stringBuilder.append("Valor total de la colección: ").append(valorTotalColeccion);

	    System.out.println(stringBuilder.toString());
	}
}

