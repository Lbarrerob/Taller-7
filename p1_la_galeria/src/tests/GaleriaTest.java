package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import central.Galeria;
import inventario.ObraDeArte;
import inventario.Video;
import transacciones.Compra;
import usuarios.Artista;
import usuarios.Cliente;
import usuarios.Empleado;

class Galeria1Test {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
	private Compra compra;
	private ObraDeArte pieza1; 
	private ObraDeArte pieza2;
	private Date fecha;
	private Cliente cliente;
	private Empleado empleado;
	private Galeria galeria;
	private Artista autor;
    private String codigosRegistro;
    private int codigo_registro;
    private HashMap<Integer, ObraDeArte> mapaPiezas;
	
	@BeforeEach
	public void setUp() throws Exception {
		galeria = new Galeria();
		System.setOut(new PrintStream(outContent));
		 
		
		fecha = new Date();
		ArrayList<String> reparto = new ArrayList<String>();
	    reparto.add("Leonardo DiCaprio");
	    reparto.add("Bruce Willis");
	    reparto.add("Ryan Reynolds");
	    reparto.add("Elton Jhon");
	    
	    autor = new Artista("Juan valencia",4654865,310284648,"jm.valencia58@hotmail.com","juanmvalencia26","toby456");
	    
		pieza1 = new Video(001,"Video","Silliness",1988,"Francia",autor,true,"en venta", 30000,false,55903,fecha,fecha,
				"Juan Reyes","Enrique Segoviano",reparto,"Frances",1205); 
		
		pieza2 = new Video(002,"Video","El Chavo del 8",2022,"Nicaragua",autor, true,"en venta", 45000,false, 
				23560,fecha,fecha,"Felipe Maldonado","Calvin Clawtorn",reparto,"Nicaraguense",1230);
		
		mapaPiezas = new HashMap<Integer, ObraDeArte>();
				
		mapaPiezas.put(001, pieza1);
		mapaPiezas.put(002, pieza2);
		
		galeria.IngresarVideoConsignacion(fecha, "Silliness",1988,"Francia",autor,true,"en venta", 30000,false,55903,fecha,
				"Juan Reyes","Enrique Segoviano",reparto,"Frances",1205);
		
		compra = new Compra(fecha, fecha,54952);
				
		galeria.registrarCliente("Luis Rodriguez",54952,31429257,"luis26@gmail.com","le.rodriguez","hollow278",3500,7000	);
		
		galeria.registrarCliente("Andres Ruiz",89945,31148132,"anresr5@gmail.com","af.ruiz","andres2005",4000,10000	);
		
		galeria.registrarEmpleado("Steven Chavez",103215484,315945652,"steven_16@yahoo.com","steven.c","steven1995","Administrador");
	
		cliente = galeria.getClientesMap().get(54952);
		
		empleado = new Empleado("Steven Chavez",103215484,315945652,"steven_16@yahoo.com","steven.c","steven1995","Administrador");
		
		codigosRegistro = "0001,002";
	}
	@AfterEach
	public void clearsetUp() throws Exception{
		
		galeria = null;
		pieza1 = null;
		System.setOut(originalOut);
	}
	
	@Test
	void testCalcularFechaDevolucion() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		
		calendar.add(Calendar.MONTH, 4);
		assertEquals(calendar.getTime(),galeria.calcularFechaDevolucion(fecha));
	}
	
	@Test
	void testObtenerEmpleadoPorIdentificacion() {
		//TODO Revisar funcionamiento, es incorrecto
		assertEquals(empleado,galeria.obtenerEmpleadoPorIdentificacion(103215484));
	}
	
	@Test
	void testObtenerArtistaPorNombre() {
		//TODO Hacer funcion
		assertEquals(autor,galeria.obtenerArtistaPorNombre("Juan valencia"));
	}
	
	@Test
	void testEliminarPiezaConsignacion() {
		//TODO Hacer funcion
		assertEquals(autor,galeria.obtenerArtistaPorNombre("Juan valencia"));
	}
	
	@Test
	void testAccederSistema() {
		galeria.accederSistema("steven.c","steven1995");
		assertEquals("Bienvenido "+ empleado.getNombre() +", ha accedido al sistema." + System.lineSeparator(),outContent.toString());
	}
	
	@Test
	void testComprarPiezas() {
		
		assertEquals("La compra se realizó exitosamente",galeria.comprarPiezas(codigosRegistro,89945,fecha,"efectivo",empleado,galeria, mapaPiezas ));
	}
	
}