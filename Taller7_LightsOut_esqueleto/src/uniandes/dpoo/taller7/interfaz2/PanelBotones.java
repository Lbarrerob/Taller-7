package uniandes.dpoo.taller7.interfaz2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBotones extends JPanel{
	private JButton bNuevo;
	private JButton bReiniciar;
	private JButton bTop;
	private JButton bJugador;
	
	public PanelBotones () 
	{
		
		setLayout(new GridLayout(6,1, 0,25));
		JLabel espacio1 = new JLabel(""); 
		add(espacio1);
		
		bNuevo = new JButton("Nuevo");
		bNuevo.setForeground(Color.black);
		bNuevo.setFont(new Font("Arial", Font.PLAIN, 14));
		bNuevo.setPreferredSize(new Dimension(50,30));
		add(bNuevo);
		
		bReiniciar = new JButton("Reiniciar");
		bReiniciar.setForeground(Color.black);
		bReiniciar.setFont(new Font("Arial", Font.PLAIN, 14));
		add(bReiniciar);
		
		bTop = new JButton("Top 10");
		bTop.setForeground(Color.black);
		bTop.setFont(new Font("Arial", Font.PLAIN, 14));
		add(bTop);
		
		bJugador = new JButton("Cambiar Jugador");
		bJugador.setForeground(Color.black);
		bJugador.setFont(new Font("Arial", Font.PLAIN, 14));
		add(bJugador);
		
		JLabel espacio2 = new JLabel(""); 
		add(espacio2);
		
	}
}
