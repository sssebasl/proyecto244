package co.edu.poli.actividad3.servicios;

import co.edu.poli.actividad3.modelo.Moneda;
import java.util.List;

/**
 * Interfaz que define las operaciones CRUD para gestionar objetos de tipo Moneda.
 * Contiene métodos para crear, actualizar, eliminar, buscar y listar monedas.
 * 
 * @author [Sebastian Ladino Villamil]
 */
public interface OperacionCRUD {

    /**
     * Crea una nueva moneda.
     * 
     * @param moneda La moneda a crear.
     * @return true si la moneda fue creada exitosamente, false si ya existe.
     */
    boolean crear(Moneda moneda);

    /**
     * Actualiza una moneda existente.
     * 
     * @param moneda La moneda con los datos actualizados.
     * @return true si la actualización fue exitosa, false si no se encontró la moneda.
     */
    boolean actualizar(Moneda moneda);

    /**
     * Elimina una moneda identificada por su serial.
     * 
     * @param serial El serial de la moneda a eliminar.
     * @return true si la moneda fue eliminada, false si no se encontró.
     */
    boolean eliminar(String serial);

    /**
     * Busca una moneda por su serial.
     * 
     * @param serial El serial de la moneda buscada.
     * @return La moneda encontrada, o null si no existe.
     */
    Moneda buscar(String serial);

    /**
     * Lista todas las monedas.
     * 
     * @return Lista de todas las monedas almacenadas.
     */
    List<Moneda> listar();
}
