package transacciones;

import usuarios.Cliente;

public class TarjetaCredito {
	private Cliente propietrio;
	private int numeroTarjeta; //número de la tarjeta de 10 digitos
	private boolean reportada = false;
	private float cupo;
	
	
	public TarjetaCredito(Cliente cliente, int numTarjeta, float cupoAmount)
	{
		this.propietrio = cliente;
		this.numeroTarjeta = numTarjeta;
		this.cupo = cupoAmount;
	}


	public boolean isReportada() {
		return reportada;
	}


	public void setReportada(boolean reportada) {
		
		this.reportada = reportada;
	}


	public float getCupo() {
		return cupo;
	}


	public void setCupo(float cupo) {
		this.cupo = cupo;
	}


	public Cliente getPropietrio() {
		return propietrio;
	}


	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}
	
	
}
