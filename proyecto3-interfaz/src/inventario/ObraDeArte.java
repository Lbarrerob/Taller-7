package inventario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

<<<<<<< HEAD
import central.Artista;
=======
>>>>>>> branch 'main' of https://github.com/DPO-20241-GRUPO-1001/Proyecto_3.git


public abstract class ObraDeArte implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//atributos
	private int codigoRegistro; //único para cada pieza
	private String tipoPieza;
	private String titulo;
	private int anio;
	private String lugar;
	private Artista autor;
	private boolean exhibicion; //exhibida o en bodega
	private String estado; //en venta, en subasta, en revisión, vendida, no adquirida 
	private int valor; 
	private boolean esValorFijo; //true si es fijo, false si es valor inicial de subasta
	private int propietarioActual; //identificador del ususario propietario en ese momento
	private Date fechaVenta;
	private Date fechaIngreso;
	private ArrayList<Integer> historialPropietarios;
	private int valor_inicial;
	private int valor_minimo;

	
	//constructor
	public ObraDeArte (int codigoRegistro, String tipoPieza, String titulo, int anio,
					String lugar, Artista autor, boolean exhibicion, String estado, int valor, 
					boolean esValorFijo, int propietarioActual, Date fechaVenta, Date fechaIngreso)
	{
		this.codigoRegistro = codigoRegistro;
		this.tipoPieza = tipoPieza;
		this.titulo = titulo;
		this.anio = anio;
		this.lugar = lugar;
		this.autor = autor;
		this.exhibicion = exhibicion;
		this.estado = estado;
		this.valor = valor;
		this.esValorFijo = esValorFijo;
		this.propietarioActual = propietarioActual;
		this.fechaVenta = fechaVenta;
		this.fechaIngreso = fechaIngreso;
		this.historialPropietarios = new ArrayList<>();
	}


	//métodos
	public int getCodigoRegistro() {
		return codigoRegistro;
	}

	public String getTipoPieza() {
		return tipoPieza;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAnio() {
		return anio;
	}

	public String getLugar() {
		return lugar;
	}

	public Artista getAutor() {
		return autor;
	}

	public boolean isExhibicion() {
		return exhibicion;
	}

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getValor() {
		return valor;
	}

	public boolean isEsValorFijo() {
		return esValorFijo;
	}

	public int getPropietarioActual() {
		return propietarioActual;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	public Date getFechaVenta() {
		return fechaVenta;
	}
	
	public Date setFechaVenta(Date fecha) {
		return fechaVenta;
	}

	public void setPropietarioActual(int propietarioActual) {
		this.propietarioActual = propietarioActual;
	}

	public ArrayList<Integer> getHistorialPropietarios() {
		return historialPropietarios;
	}

	public int getValor_inicial() {
		return valor_inicial;
	}

	public int getValor_minimo() {
		return valor_minimo;
	}
	
	public int setValor_minimo(int valor) {
		return this.valor_minimo = valor;
	}
	
	public ArrayList<Integer> setHistorialPropietarios() {
		return historialPropietarios;
	}
	
	public void agregarPropietario(int identificacion) {
	    historialPropietarios.add(identificacion);
	}
	

}

