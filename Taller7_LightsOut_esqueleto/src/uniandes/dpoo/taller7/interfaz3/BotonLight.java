package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;

public class BotonLight extends JPanel implements MouseListener{
	private int i;
	private int ii;
	private Tablero tablero;
	private InterfazVentana ventanaPrincipal;
	private BotonLight[][] matrizLuces;
	
	public BotonLight(int i, int ii, Tablero tablero, InterfazVentana ventanaPrincipal, BotonLight[][] matrizLuces)
	{
		this.i = i;
		this.ii = ii;
		this.tablero = tablero;
		this.ventanaPrincipal = ventanaPrincipal;
		this.matrizLuces = matrizLuces;
		addMouseListener(this);
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		tablero.jugar(i, ii);
		for (int lf=-1; lf<2; lf++) {
			for (int lc=-1; lc<2; lc++) {
				int f = i+lf;
				int c = ii+lc;
				
				try { Graphics G = matrizLuces[f][c].getGraphics();
					matrizLuces[f][c].paintComponent(G);
				}catch(IndexOutOfBoundsException exep) {}
			}
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void pasaMouse(Graphics g)
	{
		Graphics2D G = (Graphics2D) g;
		GradientPaint sombraAzul = new GradientPaint(50,50, new Color(49,148,228,255), 200,200, Color.white);
		G.setPaint(sombraAzul);
		g.fillRoundRect(i, ii, 100, 70, 25, 25);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		pasaMouse(getGraphics());
		
	}
	
	@Override
	public void paintComponent(Graphics g) 
	{
		Graphics2D G = (Graphics2D) g;
		GradientPaint sombraGris = new GradientPaint(50,50, Color.lightGray, 100,80, Color.white);
		GradientPaint sombraAmarillo = new GradientPaint(50,50, Color.yellow, 100,80, Color.white);

		try {
			if(tablero.darTablero()[i][ii]) {
				G.setPaint(sombraGris);
			}else {
				G.setPaint(sombraAmarillo);
			}
		} catch (IndexOutOfBoundsException exception) {}
		g.fillRoundRect(i, ii, 100, 70, 25, 25);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		paintComponent(getGraphics());
		
	}
	

}

