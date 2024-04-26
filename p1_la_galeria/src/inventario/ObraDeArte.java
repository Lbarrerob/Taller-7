package inventario;

public abstract class ObraDeArte 
{
	//atributos
	private int codigoRegistro; //único para cada pieza
	private String tipoPieza;
	private String titulo;
	private int anio;
	private String lugar;
	private String autor;
	private boolean exhibicion; //exhibida o en bodega
	private String estado; //en venta, en subasta, en revisión, vendida, no adquirida 
	private int valor; 
	private boolean esValorFijo; //true si es fijo, false si es valor inicial de subasta
	private int propietarioActual; //identificador del ususario propietario en ese momento
	
	
	//constructor
	public ObraDeArte (int codigoRegistro, String tipoPieza, String titulo, int anio,
					String lugar, String autor, boolean exhibicion, String estado, int valor, 
					boolean esValorFijo, int propietarioActual)
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

	public String getAutor() {
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

	public void setPropietarioActual(int propietarioActual) {
		this.propietarioActual = propietarioActual;
	}

	
	
				
	
}

