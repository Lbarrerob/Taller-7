package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;

public class PanelJugadas extends JPanel{
	private Tablero tablero;
	private JLabel contJugadas;
	private JLabel actualJugador;
	
	public PanelJugadas()
	{	
		JLabel jugadas = new JLabel("Jugadas: ", JLabel.LEFT);
		jugadas.setFont(new Font("Arial", Font.BOLD, 14));
		jugadas.setForeground(Color.black);
		add(jugadas);
		
		contJugadas = new JLabel("0");
		contJugadas.setFont(new Font("Arial", Font.PLAIN, 14));
		contJugadas.setForeground(Color.black);
		add(contJugadas);
		
		JLabel jugador = new JLabel("Jugador: ", JLabel.RIGHT);
		jugador.setFont(new Font("Arial", Font.BOLD, 14));
		jugador.setForeground(Color.black);
		add(jugador);
		
		actualJugador = new JLabel("xxxx");
		actualJugador.setFont(new Font("Arial", Font.PLAIN, 14));
		actualJugador.setForeground(Color.black);
		add(actualJugador);
	}
	
	public void sumJugada(int jugadas) 
	{
		
	}
}
