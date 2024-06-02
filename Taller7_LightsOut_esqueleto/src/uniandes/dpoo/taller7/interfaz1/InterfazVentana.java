package uniandes.dpoo.taller7.interfaz1;

import javax.swing.JFrame;


public class InterfazVentana extends JFrame{

	public InterfazVentana() 
	{
		setTitle("Juego de Lights Out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setSize(800,600);
		setVisible(true);
		
	}
	
	public static void main(String[] args){
        new InterfazVentana();
    }
}
