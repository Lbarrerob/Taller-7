package pasarelas;

import java.util.HashMap;

import transacciones.TarjetaCredito;
import usuarios.Cliente;

public class ApplePay extends PasarelaPago{

	//heredados
	private HashMap<Integer, TarjetaCredito> tarjetas;
	private Cliente comprador;
	
	
	//constructor
	public ApplePay(Cliente cliente) {
		super(cliente);
		this.tarjetas = new HashMap<Integer, TarjetaCredito>();
	}

	
}
