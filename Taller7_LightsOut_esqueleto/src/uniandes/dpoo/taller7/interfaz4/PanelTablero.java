package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.Border;

import uniandes.dpoo.taller7.modelo.Tablero;

public class PanelTablero extends JPanel{
	private Tablero tablero;
	private BotonLight[][] matrizLuces;
	private InterfazVentana ventanaPrincipal;
	
	public PanelTablero(int tamanio, int dificultad)
	{
		crearMatrizTablero(tamanio, dificultad);
		setBackground(Color.white);
	}
	
	public void crearMatrizTablero(int tamanio, int dificultad) 
	{
		tablero = new Tablero(tamanio);
		tablero.desordenar(dificultad);
		removeAll();
		
		boolean[][] matrizTablero = tablero.darTablero();
		matrizLuces = new BotonLight[tamanio][tamanio];
		setLayout(new GridLayout(tamanio, tamanio));
		setVisible(true);
		for (int i = 0; i < matrizTablero.length; i++)
			for (int ii = 0; ii < matrizTablero.length; ii++)
			{
				matrizLuces[i][ii] = new BotonLight(i, ii, tablero, ventanaPrincipal, matrizLuces);
				matrizLuces[i][ii].setBackground(Color.white);
				if(tamanio == 5) {
					matrizLuces[i][ii].setPreferredSize(new Dimension(124,100));
				} else if (tamanio == 6) {
					matrizLuces[i][ii].setPreferredSize(new Dimension(105,100));
				} else if (tamanio == 7) {
					matrizLuces[i][ii].setPreferredSize(new Dimension(90,100));
				}else if (tamanio == 8) {
					matrizLuces[i][ii].setPreferredSize(new Dimension(78,100));
				}
				
				add(matrizLuces[i][ii]);
			}
		
	}

	public Tablero getTablero() {
		return tablero;
	}

	public BotonLight[][] getMatrizLuces() {
		return matrizLuces;
	}
	
}
