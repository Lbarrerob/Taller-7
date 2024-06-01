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
import transacciones.Subasta;
import central.Artista;
import usuarios.Cliente;

import org.junit.jupiter.api.AfterEach;

class SubastaTest {

	private Subasta subasta;
	private ObraDeArte pieza; 
	private Date fecha;
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

		subasta = new Subasta(fecha,54952,pieza,40000);
		
		galeria = new Galeria();
		
		galeria.registrarCliente("Luis Rodriguez",54952,31429257,"luis26@gmail.com","le.rodriguez",
				"hollow278",3500,7000	);
		
		galeria.registrarCliente("Andres Ruiz",89945,31148132,"anresr5@gmail.com","af.ruiz",
				"andres2005",4000,10000	);
	
		Cliente cliente = galeria.getClientesMap().get(54952);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testVerificarOferta() {
		assertTrue(subasta.verificarOferta(subasta, 456151));
	}

}