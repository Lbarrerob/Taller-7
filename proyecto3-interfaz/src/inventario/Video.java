package inventario;

import java.util.ArrayList;
import java.util.Date;


@SuppressWarnings("unused")
public class Video extends ObraDeArte
{

	private static final long serialVersionUID = 1L;
	//heredados
	private int codigoRegistro; //único para cada pieza
	private String tipoPieza;
	private String titulo;
	private int anio; //se asume el director del vidos como el autor
	private String lugar;
	private String autor;
	private boolean exhibicion; //exhibida o en bodega
	private String estado; //en venta, en subasta, en revisión, vendida, no adquirida 
	private int valor; 
	private boolean esValorFijo; //true si es fijo, false si es valor inicial de subasta
	private int propietarioActual; //identificador del ususario propietario en ese momento
	
	//atributos
	private String productor;
	private String guionista;
	private ArrayList<String> reparto;
	private String idioma;
	private float duracion; //en minutos
	
	
	//constructor
	public Video(int codigoRegistro, String tipoPieza, String titulo, int anio, String lugar, Artista autor,
				boolean exhibicion, String estado, int valor, boolean esValorFijo, int propietarioActual,  Date fechaIngreso, Date fechaVenta,
				String productor, String guionista, ArrayList<String> reparto, String idioma, float duracion) 
	{
		super(codigoRegistro, tipoPieza, titulo, anio, lugar, autor, exhibicion, estado, valor, esValorFijo, propietarioActual, fechaVenta, fechaIngreso);
		// TODO Auto-generated constructor stub
		this.productor = productor;
		this.guionista = guionista;
		this.reparto = new ArrayList<String>( );
		this.idioma = idioma;
		this.duracion = duracion;
	}


	//metodos
	public String getProductor() {
		return productor;
	}

	public String getGuionista() {
		return guionista;
	}

	public ArrayList<String> getReparto() {
		return reparto;
	}

	public String getIdioma() {
		return idioma;
	}

	public float getDuracion() {
		return duracion;
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
	public Artista getAutor() {
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

