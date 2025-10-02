package co.edu.poli.actividad3.servicios;

import co.edu.poli.actividad3.modelo.Moneda;
import java.util.Arrays;

/**
 * Implementación de OperacionCRUD para Moneda usando arreglos.
 */
public class ImplOperacionCRUD implements OperacionCRUD {

    private static Moneda[] monedas = new Moneda[5];  // Tamaño inicial

    @Override
    public void crear(Moneda moneda) {
        if (buscar(moneda.getSerial()) != null) {
            System.out.println("Ya existe una moneda con el serial: " + moneda.getSerial());
            return;
        }

        boolean insertado = false;

        for (int i = 0; i < monedas.length; i++) {
            if (monedas[i] == null) {
                monedas[i] = moneda;
                insertado = true;
                break;
            }
        }

        if (!insertado) {
            monedas = Arrays.copyOf(monedas, monedas.length + 5);
            monedas[monedas.length - 5] = moneda;
        }

        System.out.println("Moneda agregada: " + moneda.getSerial());
    }

    @Override
    public Moneda buscar(String serial) {
        for (Moneda m : monedas) {
            if (m != null && m.getSerial().equals(serial)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void actualizar(String serial, Moneda nuevaMoneda) {
        for (int i = 0; i < monedas.length; i++) {
            if (monedas[i] != null && monedas[i].getSerial().equals(serial)) {
                monedas[i] = nuevaMoneda;
                System.out.println("Moneda actualizada: " + serial);
                return;
            }
        }
        System.out.println("No se encontró la moneda con serial: " + serial);
    }

    // Cambio en eliminar: ahora devuelve boolean
    @Override
    public boolean eliminar(String serial) {
        for (int i = 0; i < monedas.length; i++) {
            if (monedas[i] != null && monedas[i].getSerial().equals(serial)) {
                monedas[i] = null;
                System.out.println("Moneda eliminada: " + serial);
                return true;
            }
        }
        System.out.println("No se encontró la moneda con serial: " + serial);
        return false;
    }

    @Override
    public Moneda[] listar() {
        return monedas;
    }

    @Override
    public int count() {
        int contador = 0;
        for (Moneda moneda : monedas) {
            if (moneda != null) {
                contador++;
            }
        }
        return contador;
    }

    @Override
    public void clear() {
        for (int i = 0; i < monedas.length; i++) {
            monedas[i] = null;
        }
    }
}
