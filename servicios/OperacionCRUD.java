package co.edu.poli.actividad3.servicios;

import co.edu.poli.actividad3.modelo.Moneda;

/**
 * Interfaz que define las operaciones CRUD para gestionar objetos de tipo Moneda.
 */
public interface OperacionCRUD {

    /**
     * Agrega una nueva moneda.
     * @param moneda La moneda a agregar.
     */
    void crear(Moneda moneda);

    /**
     * Busca una moneda por su serial.
     * @param serial Serial de la moneda.
     * @return La moneda encontrada o null.
     */
    Moneda buscar(String serial);

    /**
     * Actualiza una moneda existente.
     * @param serial Serial de la moneda a actualizar.
     * @param nuevaMoneda Datos nuevos de la moneda.
     */
    void actualizar(String serial, Moneda nuevaMoneda);

    /**
     * Elimina una moneda por su serial.
     * @param serial Serial de la moneda a eliminar.
     */
    boolean eliminar(String serial);

    /**
     * Lista todas las monedas existentes.
     * @return arreglo de Moneda (puede contener nulls)
     */
    Moneda[] listar();

    /**
     * Devuelve la cantidad de monedas almacenadas.
     * @return Número de monedas almacenadas.
     */
    int count();

    /**
     * Limpia todas las monedas almacenadas.
     */
    void clear();
}
