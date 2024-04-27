package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import central.Galeria;

public class CentralPersistencia 

{
	public static final String FOLDER = "./Datos/";
	public static String FILENAME = "galeria";

	public Galeria cargaGaleria(String archivo) throws FileNotFoundException,IOException, ClassNotFoundException
{
	File arch = new File(archivo);
	if(arch.exists())
	{
		ObjectInputStream ois = new ObjectInputStream();
		Galeria galeria = (Galeria) ois.readObject();
		ois.close();
		return galeria;
	}
	else
	{
		return new Galeria();
	}
}


public void salvarGaleria(String archivo, Galeria galeria) throws FileNotFoundException, IOException
{
	File arch = new File(archivo);
	ObjectOutputStream oos = new ObjectOuputStream(new FileOutputStream(arch));
	oos.writeObject(galeria);
	oos.close();
}

public void salvarGaleria( Galeria galeria) throws IOException
{
	CentralPersistencia.salvarGaleria(CentralPersistencia.FOLDER + CentralPersistencia.FILENAME, galeria);
	
	
}

public Galeria cargarGaleria() throws ClassNotFoundException, IOException
{
	Galeria galeria = centralPersistencia.cargarGaleria( CentralPersistencia.FOLDER + centralPersistencia.FILENAME);
	usuarioActual = galeria.usuarioDeLaSesion;
	return galeria;
}


}
