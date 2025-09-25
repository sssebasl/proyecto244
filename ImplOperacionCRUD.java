package co.edu.poli.actividad3.servicios;

import co.edu.poli.actividad3.modelo.Moneda;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz OperacionCRUD para la gestión de monedas.
 * Proporciona métodos para crear, actualizar, eliminar, buscar y listar monedas.
 * Utiliza una lista interna para almacenar las monedas.
 * 
 * @author [Sebastian Ladino Villamil]
 */
public class ImplOperacionCRUD implements OperacionCRUD {

    private List<Moneda> monedas;

    /**
     * Constructor que inicializa la lista interna de monedas.
     */
    public ImplOperacionCRUD() {
        this.monedas = new ArrayList<>();
    }

    /**
     * Crea una nueva moneda si no existe una con el mismo serial.
     * 
     * @param moneda La moneda a agregar.
     * @return true si la moneda fue agregada, false si ya existía una con ese serial.
     */
    @Override
    public boolean crear(Moneda moneda) {
        // Evitar duplicados por serial
        if (buscar(moneda.getSerial()) == null) {
            monedas.add(moneda);
            return true;
        }
        return false;
    }

    /**
     * Actualiza una moneda existente basada en el serial.
     * 
     * @param moneda La moneda con datos actualizados.
     * @return true si se actualizó exitosamente, false si no se encontró la moneda.
     */
    @Override
    public boolean actualizar(Moneda moneda) {
        Moneda existente = buscar(moneda.getSerial());
        if (existente != null) {
            int index = monedas.indexOf(existente);
            monedas.set(index, moneda);
            return true;
        }
        return false;
    }

    /**
     * Elimina una moneda por su serial.
     * 
     * @param serial El serial de la moneda a eliminar.
     * @return true si se eliminó exitosamente, false si no se encontró la moneda.
     */
    @Override
    public boolean eliminar(String serial) {
        Moneda moneda = buscar(serial);
        if (moneda != null) {
            monedas.remove(moneda);
            return true;
        }
        return false;
    }

    /**
     * Busca una moneda por su serial.
     * 
     * @param serial El serial de la moneda a buscar.
     * @return La moneda encontrada o null si no existe.
     */
    @Override
    public Moneda buscar(String serial) {
        for (Moneda m : monedas) {
            if (m.getSerial().equals(serial)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Lista todas las monedas almacenadas.
     * 
     * @return Una nueva lista con todas las monedas para evitar modificaciones externas.
     */
    @Override
    public List<Moneda> listar() {
        return new ArrayList<>(monedas);
    }
}
