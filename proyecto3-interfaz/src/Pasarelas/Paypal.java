package Pasarelas;

import java.util.HashMap;

import transacciones.TarjetaCredito;
import usuarios.Cliente;

public class Paypal extends PasarelaPago{
	
	//heredados
		private HashMap<Integer, TarjetaCredito> tarjetas;
		private Cliente comprador;
		
		
		//constructor
		public Paypal(Cliente cliente) {
			super(cliente);
			this.tarjetas = new HashMap<Integer, TarjetaCredito>();
		}

		
}
