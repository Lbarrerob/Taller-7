package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class ConsolaBasica 
{
	protected int mostrarMenu( String nombreMenu, String[] opciones )
    {
        System.out.println( "\n---------------------" );
        System.out.println( nombreMenu );
        System.out.println( "---------------------" );

        for( int i = 1; i <= opciones.length; i++ )
        {
            System.out.println( " " + i + ". " + opciones[ i - 1 ] );
        }
        String opcion = pedirCadenaAlUsuario( "Escoja la opción deseada" );
        try
        {
            int opcionSeleccionada = Integer.parseInt( opcion );
            if( opcionSeleccionada > 0 && opcionSeleccionada <= opciones.length )
                return opcionSeleccionada;
            else
            {
                System.out.println( "Esa no es una opción válida. Digite solamente números entre 1 y " + opciones.length );
                return mostrarMenu( nombreMenu, opciones );
            }
        }
        catch( NumberFormatException nfe )
        {
            System.out.println( "Esa no es una opción válida. Digite solamente números." );
            return mostrarMenu( nombreMenu, opciones );
        }
    }
	
	
	protected String pedirCadenaAlUsuario( String mensaje )
    {
        try
        {
            System.out.print( mensaje + ": " );
            BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
            String input = reader.readLine( );
            return input;
        }
        catch( IOException e )
        {
            System.out.println( "Error leyendo de la consola" );
        }
        return "error";
    }
	
	protected int pedirEnteroAlUsuario( String mensaje )
    {
        int valorResultado = Integer.MIN_VALUE;
        while( valorResultado == Integer.MIN_VALUE )
        {
            try
            {
                System.out.print( mensaje + ": " );
                BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
                String input = reader.readLine( );
                int numero = Integer.parseInt( input );
                valorResultado = numero;
            }
            catch( NumberFormatException nfe )
            {
                System.out.println( "El valor digitado no es un entero" );
            }
            catch( IOException e )
            {
                System.out.println( "Error leyendo de la consola" );
            }
        }
        return valorResultado;
    }
	
	protected double pedirNumeroAlUsuario( String mensaje )
    {
        double valorResultado = Integer.MIN_VALUE;
        while( valorResultado == Integer.MIN_VALUE )
        {
            try
            {
                System.out.print( mensaje + ": " );
                BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
                String input = reader.readLine( );
                double numero = Double.parseDouble( input );
                valorResultado = numero;
            }
            catch( NumberFormatException nfe )
            {
                System.out.println( "El valor digitado no es un entero" );
            }
            catch( IOException e )
            {
                System.out.println( "Error leyendo de la consola" );
            }
        }
        return valorResultado;
    }
	
	protected boolean pedirBooleanoAlUsuario(String mensaje) 
	{
	    boolean valorResultado = false;
	    while (true) 
	    {
	        try 
	        {
	            System.out.print(mensaje + " (true/false): ");
	            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	            String input = reader.readLine().trim().toLowerCase();
	            if (input.equals("true")) {
	                valorResultado = true;
	                break;
	            }
	            else if (input.equals("false")) 
	            {
	                valorResultado = false;
	                break;
	            } 
	            else {
	                System.out.println("Por favor, ingrese 'true' o 'false'.");
	            }
	        } 
	        catch (IOException e) 
	        {
	            System.out.println("Error leyendo de la consola");
	        }
	    }
	    return valorResultado;
	}
	
	protected float pedirFloatAlUsuario(String mensaje) 
	{
	    float valorResultado = Float.NaN;
	    while (true)
	    {
	        try
	        {
	            System.out.print(mensaje + ": ");
	            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	            String input = reader.readLine();
	            float numero = Float.parseFloat(input);
	            valorResultado = numero;
	            break;
	        } 
	        catch (NumberFormatException nfe) {
	            System.out.println("El valor digitado no es un número válido");
	        } 
	        catch (IOException e) {
	            System.out.println("Error leyendo de la consola");
	        }
	    }
	    return valorResultado;
	}
	
	
	protected ArrayList<String> pedirListaCadenas(String mensaje) {
	    ArrayList<String> lista = new ArrayList<>();
	    System.out.println(mensaje);
	    try {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        String entrada = reader.readLine();
	        String[] partes = entrada.split(", ");
	        lista.addAll(Arrays.asList(partes));
	    } catch (IOException e) {
	        System.out.println("Error leyendo de la consola");
	    }
	    return lista;
	}
	
	
}
