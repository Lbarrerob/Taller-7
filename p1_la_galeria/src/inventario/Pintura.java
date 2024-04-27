package inventario;

public class Pintura extends ObraDeArte
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//heredados
	private int codigoRegistro;
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
	
	//atributos
	private float alto;
	private float ancho;
	private String tecnica;
	private String periodo;
	private String genero;
	
	
	//constructor
	public Pintura(int codigoRegistro, String tipoPieza, String titulo, int anio, String lugar, String autor,
				boolean exhibicion, String estado, int valor, boolean esValorFijo, int propietarioActual, float alto,
				float ancho, String tecnica, String periodo, String genero) 
	{
		super(codigoRegistro, tipoPieza, titulo, anio, lugar, autor, exhibicion, estado, valor, esValorFijo, propietarioActual);
		// TODO Auto-generated constructor stub
		this.alto = alto;
		this.ancho = ancho;
		this.tecnica = tecnica;
		this.periodo = periodo;
		this.genero = genero;
	}


	//métodos
	public float getAlto() {
		return alto;
	}

	public float getAncho() {
		return ancho;
	}

	public String getTecnica() {
		return tecnica;
	}

	public String getPeriodo() {
		return periodo;
	}

	public String getGenero() {
		return genero;
	}
	
	
	@Override
	public int getCodigoRegistro() {
		// TODO Auto-generated method stub
		return super.getCodigoRegistro();
	}

	
	@Override
	public String getTipoPieza() {
		// TODO Auto-generated method stub
		return super.getTipoPieza();
	}


	@Override
	public String getTitulo() {
		// TODO Auto-generated method stub
		return super.getTitulo();
	}


	@Override
	public int getAnio() {
		// TODO Auto-generated method stub
		return super.getAnio();
	}


	@Override
	public String getLugar() {
		// TODO Auto-generated method stub
		return super.getLugar();
	}


	@Override
	public String getAutor() {
		// TODO Auto-generated method stub
		return super.getAutor();
	}


	@Override
	public boolean isExhibicion() {
		// TODO Auto-generated method stub
		return super.isExhibicion();
	}


	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return super.getEstado();
	}


	@Override
	public int getValor() {
		// TODO Auto-generated method stub
		return super.getValor();
	}


	@Override
	public boolean isEsValorFijo() {
		// TODO Auto-generated method stub
		return super.isEsValorFijo();
	}


	@Override
	public int getPropietarioActual() {
		// TODO Auto-generated method stub
		return super.getPropietarioActual();
	}

	
	
}
