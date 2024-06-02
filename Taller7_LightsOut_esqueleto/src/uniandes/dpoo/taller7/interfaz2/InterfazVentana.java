package uniandes.dpoo.taller7.interfaz2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class InterfazVentana extends JFrame{
	private PanelTamanio panelArriba;
	private PanelBotones panelDerecha;
	private PanelJugadas panelAbajo;

	public InterfazVentana() 
	{
		setTitle("Juego de Lights Out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setSize(800,600);
		setVisible(true);
		
		setLayout(new BorderLayout());
		panelArriba = new PanelTamanio();
		panelArriba.setVisible(true);
		add(panelArriba, BorderLayout.NORTH);
		
		panelDerecha = new PanelBotones();
		panelDerecha.setVisible(true);
		add(panelDerecha, BorderLayout.EAST);
		
		panelAbajo = new PanelJugadas();
		panelAbajo.setVisible(true);
		add(panelAbajo, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(() -> new InterfazVentana());
    }
}
