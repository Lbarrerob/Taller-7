package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import uniandes.dpoo.taller7.modelo.Top10;

public class InterfazVentana extends JFrame{
	private PanelTablero panelIzquierda;
	private PanelTamanio panelArriba;
	private PanelBotones panelDerecha;
	private PanelJugadas panelAbajo;
	
	private int tamPredeterminado;
	private int jugadas;
	private Top10 top;

	public InterfazVentana() 
	{
		setTitle("Juego de Lights Out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setSize(800,600);
		setVisible(true);
		setResizable(false);
		
		setLayout(new BorderLayout());
		tamPredeterminado = 7;
		panelArriba = new PanelTamanio(tamPredeterminado);
		panelArriba.setVisible(true);
		add(panelArriba, BorderLayout.NORTH);
		
		panelDerecha = new PanelBotones();
		panelDerecha.setVisible(true);
		add(panelDerecha, BorderLayout.EAST);
		
		panelAbajo = new PanelJugadas();
		panelAbajo.setVisible(true);
		add(panelAbajo, BorderLayout.SOUTH);
		
		panelIzquierda = new PanelTablero(tamPredeterminado, 5);
		panelIzquierda.setVisible(true);
		add(panelIzquierda, BorderLayout.WEST);
		
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(() -> new InterfazVentana());
    }
	
	public PanelTablero getPanelIzquierda() {
		return panelIzquierda;
	}

	public PanelTamanio getPanelArriba() {
		return panelArriba;
	}

	public PanelBotones getPanelDerecha() {
		return panelDerecha;
	}

	public PanelJugadas getPanelAbajo() {
		return panelAbajo;
	}

	public int getJugadas() {
		return this.jugadas;
	}

	public Top10 getTop() {
		return top;
	}
	
	
}
