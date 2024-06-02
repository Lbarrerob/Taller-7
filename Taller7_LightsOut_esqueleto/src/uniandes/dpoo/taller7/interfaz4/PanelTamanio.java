package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelTamanio extends JPanel implements ActionListener {
	private int tam;
	private int dificultad;
	private InterfazVentana ventanaPrincipal;
	
	public PanelTamanio(int dimension) 
	{
		tam = dimension;
		
		JLabel tamanio = new JLabel("Tamaño: ", JLabel.RIGHT);
		tamanio.setFont(new Font("Arial", Font.PLAIN, 14));
		tamanio.setForeground(Color.black);
		add(tamanio);
		
		JComboBox<String> difTamanios = new JComboBox<String>();
		difTamanios.setBackground(Color.white);
		difTamanios.addItem("5 x 5");
		difTamanios.addItem("6 x 6");
		difTamanios.addItem("7 x 7");
		difTamanios.addItem("8 x 8");
		add(difTamanios);
		difTamanios.addActionListener(this);
		
		JLabel LDificultad = new JLabel("Dificultad: ", JLabel.CENTER);
		LDificultad.setFont(new Font("Arial", Font.PLAIN, 14));
		LDificultad.setForeground(Color.black);
		add(LDificultad);
		
		JRadioButton facil = new JRadioButton("Fácil");
		facil.setBackground(Color.white);
		facil.setForeground(Color.black);
		facil.setFont(new Font("Arial", Font.PLAIN, 14));
		add(facil);
		
		JRadioButton medio = new JRadioButton("Medio");
		medio.setBackground(Color.white);
		medio.setForeground(Color.black);
		medio.setFont(new Font("Arial", Font.PLAIN, 14));
		add(medio);
		
		JRadioButton dificil = new JRadioButton("Difícil");
		dificil.setBackground(Color.white);
		dificil.setForeground(Color.black);
		dificil.setFont(new Font("Arial", Font.PLAIN, 14));
		add(dificil);
		
		ButtonGroup unaDificultad = new ButtonGroup();
		unaDificultad.add(facil);
		unaDificultad.add(medio);
		unaDificultad.add(dificil);
		
		//intento de hacer que las dificultades funcionen
		facil.setSelected(true);
		facil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dificultad = 5;
			}
		});
		medio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dificultad = 15;
			}
		});
		dificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dificultad = 25;
			}
		});
	}
	
	//intento de hacer que el comboBox funcione
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox B = (JComboBox) e.getSource();
		String seleccion = (String)B.getSelectedItem();
		
		if (seleccion.equals("5x5")) {
			tam = 5;
		} else if (seleccion.equals("6x6")) {
			tam = 6;
		} else if (seleccion.equals("7x7")){
			tam = 7;
		} else if (seleccion.equals("8x8")){
			tam = 8;
		}
		ventanaPrincipal.getPanelIzquierda().crearMatrizTablero(tam, dificultad);
		ventanaPrincipal.setVisible(true);
	}

	public int getTamanio() {
		return this.tam;
	}
	public int getDificultad() {
		return this.dificultad;
	}
}
