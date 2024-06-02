package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;

public class PanelBotones extends JPanel{
	private JButton bNuevo;
	private JButton bReiniciar;
	private JButton bTop;
	private JButton bJugador;
	
	private InterfazVentana ventanaPrincipal;
	
	public PanelBotones () 
	{
		
		setLayout(new GridLayout(6,1, 0,25));
		JLabel espacio1 = new JLabel(""); 
		add(espacio1);
		
		bNuevo = new JButton("Nuevo");
		bNuevo.setForeground(Color.black);
		bNuevo.setFont(new Font("Arial", Font.PLAIN, 14));
		bNuevo.setPreferredSize(new Dimension(50,30));
		//intento de que el botón funcione
		bNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int tam = ventanaPrincipal.getPanelArriba().getTamanio();
				int dif = ventanaPrincipal.getPanelArriba().getDificultad();
				ventanaPrincipal.getPanelIzquierda().crearMatrizTablero(tam, dif);
				ventanaPrincipal.setVisible(true);
			}
		});
		add(bNuevo);
		
		bReiniciar = new JButton("Reiniciar");
		bReiniciar.setForeground(Color.black);
		bReiniciar.setFont(new Font("Arial", Font.PLAIN, 14));
		//intento de que el botón funcione
		bReiniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Tablero table = ventanaPrincipal.getPanelIzquierda().getTablero();
				table.reiniciar();
				
				int tamTablero = ventanaPrincipal.getPanelIzquierda().getMatrizLuces().length;
				for (int i=0; i<tamTablero; i++) {
					for (int ii=0; i<tamTablero; ii++) {
						Graphics G = ventanaPrincipal.getPanelIzquierda().getMatrizLuces()[i][ii].getGraphics();
						
						if (table.darTablero()[i][ii]) {
							ventanaPrincipal.getPanelIzquierda().getMatrizLuces()[i][ii].paint(G);
						}
					}
				}
			}
			
		});
		add(bReiniciar);
		
		bTop = new JButton("Top 10");
		bTop.setForeground(Color.black);
		bTop.setFont(new Font("Arial", Font.PLAIN, 14));
		//intento de que funcione el top10
		bTop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JDialog top = new JDialog(ventanaPrincipal);
				top.setTitle("Top 10");
				top.setSize(200,200);
				top.setLocationRelativeTo(ventanaPrincipal);
				
				JLabel nom = new JLabel("#Nombre");
				nom.setFont(new Font("Arial", Font.PLAIN, 14));
				nom.setForeground(Color.black);
				JPanel panelNom = new JPanel();
				panelNom.add(nom);
				
				top.add(panelNom, BorderLayout.NORTH);
				top.setVisible(true);
				
				JList listaTop = new JList();
				Collection<RegistroTop10> registros = ventanaPrincipal.getTop().darRegistros();
				int i=1;
				for (RegistroTop10 jugador: registros) {
					//listaTop.add(Integer.toString(i)+"-"+jugador);
					i++;
				}
				JScrollPane scroll = new JScrollPane();
				scroll.setViewportView(listaTop);
				top.add(scroll, BorderLayout.CENTER);
				top.setVisible(true);
			}
			
		});
		add(bTop);
		
		bJugador = new JButton("Cambiar Jugador");
		bJugador.setForeground(Color.black);
		bJugador.setFont(new Font("Arial", Font.PLAIN, 14));
		//intento de que el botón funcione
		bJugador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JDialog camJugador = new JDialog(ventanaPrincipal);
				camJugador.setTitle("Cambiar Jugador");
				camJugador.setSize(300,200);
				camJugador.setLocationRelativeTo(ventanaPrincipal);
				
				JLabel nomJugador = new JLabel("Nombre jugador: ");
				nomJugador.setFont(new Font("Arial", Font.PLAIN, 14));
				nomJugador.setForeground(Color.black);
				JTextField ingreso = new JTextField();
				ingreso.setSize(100, 16);
				
				JPanel panelCambiar = new JPanel();
				panelCambiar.setLayout(new GridLayout(4,1, 0,15));
				panelCambiar.add(nomJugador);
				panelCambiar.add(ingreso);
				
				camJugador.add(panelCambiar, BorderLayout.CENTER);
				camJugador.setVisible(true);
			}
			
		});
		add(bJugador);
		
		JLabel espacio2 = new JLabel(""); 
		add(espacio2);
		
	}
}
