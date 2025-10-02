package co.edu.poli.actividad3.modelo;
import java.io.Serializable;
/**
 * Representa el estado de conservación de una moneda.
 * Contiene información sobre si la moneda está en circulación,
 * si forma parte de una colección, si está descontinuada y su identificador de registro.
 * 
 * @author [Sebastian Ladino Villamil]
 */
public class Conservacion implements Serializable{
    private boolean circulacion;
    private boolean coleccion;
    private boolean descontinuada;
    private String idRegistro;

    /**
     * Constructor por defecto.
     */
    public Conservacion() {}

    /**
     * Constructor con parámetros para inicializar todos los atributos.
     * 
     * @param circulacion Indica si la moneda está en circulación.
     * @param coleccion Indica si la moneda forma parte de una colección.
     * @param descontinuada Indica si la moneda está descontinuada.
     * @param idRegistro Identificador único de registro.
     */
    public Conservacion(boolean circulacion, boolean coleccion, boolean descontinuada, String idRegistro) {
        this.circulacion = circulacion;
        this.coleccion = coleccion;
        this.descontinuada = descontinuada;
        this.idRegistro = idRegistro;
    }

    /**
     * Indica si la moneda está en circulación.
     * @return true si está en circulación, false en caso contrario.
     */
    public boolean isCirculacion() {
        return circulacion;
    }

    /**
     * Establece si la moneda está en circulación.
     * @param circulacion true para indicar que está en circulación.
     */
    public void setCirculacion(boolean circulacion) {
        this.circulacion = circulacion;
    }

    /**
     * Indica si la moneda forma parte de una colección.
     * @return true si es parte de una colección, false en caso contrario.
     */
    public boolean isColeccion() {
        return coleccion;
    }

    /**
     * Establece si la moneda forma parte de una colección.
     * @param coleccion true para indicar que forma parte de una colección.
     */
    public void setColeccion(boolean coleccion) {
        this.coleccion = coleccion;
    }

    /**
     * Indica si la moneda está descontinuada.
     * @return true si está descontinuada, false en caso contrario.
     */
    public boolean isDescontinuada() {
        return descontinuada;
    }

    /**
     * Establece si la moneda está descontinuada.
     * @param descontinuada true para indicar que está descontinuada.
     */
    public void setDescontinuada(boolean descontinuada) {
        this.descontinuada = descontinuada;
    }

    /**
     * Obtiene el identificador único de registro.
     * @return Identificador de registro.
     */
    public String getIdRegistro() {
        return idRegistro;
    }

    /**
     * Establece el identificador único de registro.
     * @param idRegistro Identificador de registro.
     */
    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    /**
     * Representación en texto del estado de conservación.
     * @return Cadena con los valores de los atributos.
     */
    @Override
    public String toString() {
        return "Conservacion{" +
                "circulacion=" + circulacion +
                ", coleccion=" + coleccion +
                ", descontinuada=" + descontinuada +
                ", idRegistro='" + idRegistro + '\'' +
                '}';
    }
}
