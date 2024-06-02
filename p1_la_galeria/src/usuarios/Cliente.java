package usuarios;

<<<<<<< HEAD
import java.util.HashMap;

import inventario.ObraDeArte;

public class Cliente extends Usuario
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
	
	//atributos
	private float ingreso;
	private int limiteCompra;
	private HashMap<Integer, ObraDeArte> historialPropiedad;
	private HashMap<Integer, ObraDeArte> historialCompra;
	
	
	//constuctor
	public Cliente(String nombre, int identificacion, int telefono, String correo, String login, String password,
				float ingreso, int limiteCompra) 
	{
		super(nombre, identificacion, telefono, correo, login, password);
		// TODO Auto-generated constructor stub
		this.ingreso = ingreso;
		this.limiteCompra = limiteCompra;
		this.historialPropiedad = new HashMap<Integer, ObraDeArte>( );
		this.historialCompra = new HashMap<Integer, ObraDeArte>();	
		
	}


	//metodos
	public double getIngreso() {
		return ingreso;
	}

	public void setNuevoIngreso(float ingreso, String password) {
		if (password.equals(this.password)) {
			this.ingreso = ingreso;
		}
	}

	public int getLimiteCompra() {
		return limiteCompra;
	}

	public HashMap<Integer, ObraDeArte> consultarHistorialPropiedad() {
		return historialPropiedad;
	}

	public HashMap<Integer, ObraDeArte> consultarHistorialCompra() {
		return historialCompra;
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

	

	
	
=======
import java.util.ArrayList;
import java.util.HashMap;

import central.Galeria;
import inventario.ObraDeArte;

@SuppressWarnings("unused")
public class Cliente extends Usuario
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
	
	//atributos
	private double ingreso;
	private double limiteCompra;
	private HashMap<Integer, ObraDeArte> historialPropiedad;
	private HashMap<Integer, ObraDeArte> historialCompra;
	
	
	//constuctor
	public Cliente(String nombre, int identificacion, int telefono, String correo, String login, String password,
				double ingreso, double limiteCompra) 
	{
		super(nombre, identificacion, telefono, correo, login, password);
		// TODO Auto-generated constructor stub
		this.ingreso = ingreso;
		this.limiteCompra = limiteCompra;
		this.historialPropiedad = new HashMap<Integer, ObraDeArte>( );
		this.historialCompra = new HashMap<Integer, ObraDeArte>();	
		
	}


	//metodos
	public double getIngreso() {
		return ingreso;
	}

	public void setNuevoIngreso(float ingreso, String password) {
		if (password.equals(this.password)) {
			this.ingreso = ingreso;
		}
	}

	public double getLimiteCompra() {
		return limiteCompra;
	}

	public HashMap<Integer, ObraDeArte> consultarHistorialPropiedad() {
		return historialPropiedad;
	}

	public HashMap<Integer, ObraDeArte> consultarHistorialCompra() {
		return historialCompra;
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
	
    public void setHistorialPropiedad(HashMap<Integer, ObraDeArte> historialPropiedad) {
		this.historialPropiedad = historialPropiedad;
	}


	public void setHistorialCompra(HashMap<Integer, ObraDeArte> historialCompra) {
		this.historialCompra = historialCompra;
	}
	
	public ArrayList<ObraDeArte> consultarHistorialPropiedades(int identificacionCliente) {
	    ArrayList<ObraDeArte> historial = new ArrayList<>();
	    for (Integer codigoRegistro : historialPropiedad.keySet()) {
	        ObraDeArte obra = historialPropiedad.get(codigoRegistro);
	        if (obra.getPropietarioActual() == identificacionCliente) {
	            historial.add(obra);
	        }
	    }
	    return historial;
	}

	public ArrayList<ObraDeArte> consultarHistorialCompras(int identificacionCliente) {
	    ArrayList<ObraDeArte> historial = new ArrayList<>();
	    for (Integer codigoRegistro : historialCompra.keySet()) {
	        ObraDeArte obra = historialCompra.get(codigoRegistro);
	        if (obra.getPropietarioActual() == identificacionCliente) {
	            historial.add(obra);
	        }
	    }
	    return historial;
	}

>>>>>>> branch 'main' of https://github.com/DPO-20241-GRUPO-1001/Proyecto_3.git
}

