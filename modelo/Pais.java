package co.edu.poli.actividad3.modelo;
import java.io.Serializable;
/**
 * Clase que representa un país con sus atributos básicos:
 * nombre, código ISO y ciudad principal.
 * 
 * Proporciona métodos para obtener y modificar estos atributos,
 * además de una representación en texto del país.
 * 
 * @author [Sebastian Ladino Villamil]
 */
public class Pais implements Serializable{
    private String nombre;
    private String codigoISO;
    private String ciudad;

    /**
     * Constructor por defecto.
     */
    public Pais() {}

    /**
     * Constructor con parámetros para inicializar un país.
     * 
     * @param nombre Nombre del país.
     * @param codigoISO Código ISO del país.
     * @param ciudad Ciudad principal o capital del país.
     */
    public Pais(String nombre, String codigoISO, String ciudad) {
        this.nombre = nombre;
        this.codigoISO = codigoISO;
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el nombre del país.
     * 
     * @return Nombre del país.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del país.
     * 
     * @param nombre Nuevo nombre del país.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el código ISO del país.
     * 
     * @return Código ISO.
     */
    public String getCodigoISO() {
        return codigoISO;
    }

    /**
     * Establece el código ISO del país.
     * 
     * @param codigoISO Nuevo código ISO.
     */
    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    /**
     * Obtiene la ciudad principal o capital del país.
     * 
     * @return Ciudad del país.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad principal o capital del país.
     * 
     * @param ciudad Nueva ciudad del país.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Representación en texto del país.
     * 
     * @return Cadena con nombre, código ISO y ciudad.
     */
    @Override
    public String toString() {
        return nombre + " (" + codigoISO + "), " + ciudad;
    }
}
