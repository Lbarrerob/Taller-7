package pasarelas;

import java.util.HashMap;

import central.Oferta;
import central.Solicitud;
import transacciones.TarjetaCredito;
import usuarios.Cliente;

public abstract class PasarelaPago 
{
	//atributos
	private HashMap<Integer, TarjetaCredito> tarjetas;
	private Cliente comprador;
	
	//constructor
	public PasarelaPago (Cliente cliente) 
	{
		this.tarjetas = new HashMap<Integer, TarjetaCredito>();
		this.comprador = cliente;
	}
	
	//métodos
	public boolean verificarTarjeta(int numTarjeta) {
		TarjetaCredito tarjeta = tarjetas.get(numTarjeta);
		if (tarjeta.getNumeroTarjeta() == numTarjeta) {
			return true;
		}
		return false;
	}
	
	public boolean verificarCupoCompra(Solicitud solCompra, int numTarjeta) 
	{
		TarjetaCredito tarjeta = tarjetas.get(numTarjeta);
		float valorCompra = solCompra.valorCompra();
		
		if (valorCompra > tarjeta.getCupo()) {
			return false;
		}
		return true;
	}
	
	public boolean verificarReportada(int numTarjeta)
	{
		TarjetaCredito tarjeta = tarjetas.get(numTarjeta);
		if (!tarjeta.isReportada()) {
			return false;
		}
		return true;
	}
}
