package co.edu.poli.actividad3.servicios;

import co.edu.poli.actividad3.modelo.Moneda;
import java.io.*;

/**
 * Clase para operaciones de serialización y deserialización
 * de arreglos de Moneda.
 */
public class OperacionArchivo {

    private static final String NOMBRE_ARCHIVO = "monedas.dat";

    /**
     * Serializa el arreglo de monedas a un archivo.
     * @param monedas arreglo de monedas a serializar
     */
    public void serializar(Moneda[] monedas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(monedas);
            System.out.println("Archivo serializado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al serializar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Deserializa el arreglo de monedas desde un archivo.
     * @return arreglo de monedas deserializado, o null si hubo error.
     */
    public Moneda[] deserializar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            Object obj = ois.readObject();
            if (obj instanceof Moneda[]) {
                System.out.println("Archivo deserializado correctamente.");
                return (Moneda[]) obj;
            } else {
                System.out.println("El archivo no contiene un arreglo de Moneda válido.");
                return null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + NOMBRE_ARCHIVO);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
