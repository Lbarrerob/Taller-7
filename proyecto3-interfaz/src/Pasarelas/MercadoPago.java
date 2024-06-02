package Pasarelas;

import java.util.HashMap;

import transacciones.TarjetaCredito;
import usuarios.Cliente;

public class MercadoPago extends PasarelaPago{

	//heredados 
	private HashMap<Integer, TarjetaCredito> tarjetas;
	private Cliente comprador;
	
	//constructor
	public MercadoPago(Cliente cliente) {
		super(cliente);
		this.tarjetas = new HashMap<Integer, TarjetaCredito>();
	}
	

}
