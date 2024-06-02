package uniandes.dpoo.taller7.interfaz3;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class InterfazVentana extends JFrame{
	private PanelTablero panelIzquierda;
	private PanelTamanio panelArriba;
	private PanelBotones panelDerecha;
	private PanelJugadas panelAbajo;
	private int tamPredeterminado;

	public InterfazVentana() 
	{
		setTitle("Juego de Lights Out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setSize(800,600);
		setVisible(true);
		setResizable(false);
		
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
		
		tamPredeterminado = 7;
		panelIzquierda = new PanelTablero(tamPredeterminado, 5);
		panelIzquierda.setVisible(true);
		add(panelIzquierda, BorderLayout.WEST);
		
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(() -> new InterfazVentana());
    }
	
	public PanelTablero getPanelTablero() {
		return panelIzquierda;
	}
}
