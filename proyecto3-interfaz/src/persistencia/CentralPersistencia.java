package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import central.Galeria;

public class CentralPersistencia {

    public static final String FOLDER = "./Datos/";
    public static String FILENAME = "galeria";

    public Galeria cargaGaleria(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        File arch = new File(archivo);
        if (arch.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arch))) {
                Galeria galeria = (Galeria) ois.readObject();
                return galeria;
            }
        } else {
            return new Galeria();
        }
    }

    public void salvarGaleria(String archivo, Galeria galeria) throws FileNotFoundException, IOException {
        File arch = new File(archivo);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arch))) {
            oos.writeObject(galeria);
        }
    }

    public void salvarGaleria(Galeria galeria) throws IOException {
        salvarGaleria(FOLDER + FILENAME, galeria);
    }

    public Galeria cargarGaleria() throws ClassNotFoundException, IOException {
        return cargaGaleria(FOLDER + FILENAME);
    }

}