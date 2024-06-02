package uniandes.dpoo.taller7.interfaz2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelTamanio extends JPanel {
	
	public PanelTamanio() 
	{
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
		
	}


}
