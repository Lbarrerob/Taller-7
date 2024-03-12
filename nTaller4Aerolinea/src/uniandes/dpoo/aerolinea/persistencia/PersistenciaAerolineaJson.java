package uniandes.dpoo.aerolinea.persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

//Ya no es archivo JSON, entendí más serialización :b
public class PersistenciaAerolineaJson implements IPersistenciaAerolinea {

	@Override
	public void cargarAerolinea(String archivo, Aerolinea aerolinea)
			throws IOException, InformacionInconsistenteException {
		// TODO Auto-generated method stub
		try {
            // Reading object from file
            FileInputStream fileIn = new FileInputStream( archivo );
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Aerolinea deserializedObject = ( Aerolinea ) in.readObject();
            aerolinea = deserializedObject;
            
            in.close();
            fileIn.close();
            System.out.println("Aerolinea deserializada");
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {
		// TODO Auto-generated method stub
		try {
            // Writing object to file
            FileOutputStream fileOut = new FileOutputStream( archivo );
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject( aerolinea );
            out.close();
            fileOut.close();
            System.out.println("Aerolinea serializada");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
