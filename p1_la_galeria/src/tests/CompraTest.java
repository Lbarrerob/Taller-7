package tests;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import central.Galeria;
import inventario.ObraDeArte;
import inventario.Video;
import transacciones.Compra;
import central.Artista;
import usuarios.Cliente;

class CompraTest {
	
	private Compra compra;
	private ObraDeArte pieza; 
	private Date fecha;
	private Cliente cliente;
	private Galeria galeria;
	private Artista autor;
	
	@BeforeEach
	public void setUp() throws Exception {
		fecha = new Date();
		ArrayList<String> reparto = new ArrayList<String>();
	    reparto.add("Leonardo DiCaprio");
	    reparto.add("Bruce Willis");
	    reparto.add("Ryan Reynolds");
	    reparto.add("Elton Jhon");
	    autor = new Artista("Juan valencia");
	    
		pieza = new Video(001,"Video","Silliness",1988,"Francia",autor,true,"en venta", 30000,false,55903,fecha,fecha,"Juan Reyes","Enrique Segoviano",reparto,"Frances",1205); 

		compra = new Compra(fecha, fecha,54952);
		
		galeria = new Galeria();
		
		galeria.registrarCliente("Luis Rodriguez",54952,31429257,"luis26@gmail.com","le.rodriguez",
				"hollow278",3500,7000	);
		
		galeria.registrarCliente("Andres Ruiz",89945,31148132,"anresr5@gmail.com","af.ruiz",
				"andres2005",4000,10000	);
	
		cliente = galeria.getClientesMap().get(54952);
	}
	
	@Test
	void testAgregarPiezaMapaPropiedades() {
		compra.agregarPiezaMapaPropiedades(54952,galeria,"001",pieza);
		assertTrue(cliente.consultarHistorialPropiedad().containsKey(001));
	}
	 
	@Test
	void testAgregarPiezaMapaCompras() {
		compra.agregarPiezaMapaCompras(54952,galeria,"001",pieza);
		assertTrue(cliente.consultarHistorialCompra().containsKey(001));
	}

	@Test
	void testActualizarPropietario() {
		compra.actualizarPropietario(pieza,89945);
		assertEquals(89945,pieza.getPropietarioActual());
	}
	
	@Test
	void testCambiarEstadoPieza() {
		compra.cambiarEstadoPieza(pieza);
		assertEquals("Vendida",pieza.getEstado());
	}
	
	@Test
	void testBloquearPieza() {
		compra.bloquearPieza(pieza);
		assertEquals("En revision",pieza.getEstado());
	}
	
	@Test
	void testDesbloquearPieza() {
		compra.desbloquearPieza(pieza,"no adquirida");
		assertEquals("no adquirida",pieza.getEstado());
	}
	
	//@Test
	//void test7() {
		//compra.verificarEstadoPieza(pieza);
	//	assertEquals("no adquirida",pieza.getEstado());
	//}
	
	
	@Test
	void testVerificarComprador1() {
		assertTrue(galeria.verificarComprador("af.ruiz","andres2005", 5000));
	}
	
	@Test
	void testVerificarComprador2() {
		assertFalse(galeria.verificarComprador("af.ruiz","andres2005", 3000));
	}
	@Test
	void testAprobarCompra() {
		assertTrue(compra.aprobarCompra());
	}
	
	@Test
	void testAprobarCompra2() {
		assertTrue(compra.aprobarCompra());
	}
}