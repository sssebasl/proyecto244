package co.edu.poli.actividad3.modelo;

import java.io.Serializable;

/**
 * Clase que representa un propietario de una moneda,
 * con atributos como nombre, identificación, país y fecha de adquisición.
 * 
 * Proporciona métodos para obtener y modificar estos atributos,
 * así como una representación en texto del propietario.
 * 
 * @author [Sebastian Ladino Villamil]
 */
public class Propietario implements Serializable{
    private String nombre;
    private String identificacion;
    private String pais;
    private String fechaAdquisicion;

    /**
     * Constructor por defecto.
     */
    public Propietario() {}

    /**
     * Constructor con parámetros para inicializar un propietario.
     * 
     * @param nombre Nombre del propietario.
     * @param identificacion Identificación del propietario.
     * @param pais País de residencia del propietario.
     * @param fechaAdquisicion Fecha en que adquirió la moneda.
     */
    public Propietario(String nombre, String identificacion, String pais, String fechaAdquisicion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.pais = pais;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    /**
     * Obtiene el nombre del propietario.
     * 
     * @return Nombre del propietario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del propietario.
     * 
     * @param nombre Nuevo nombre del propietario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la identificación del propietario.
     * 
     * @return Identificación del propietario.
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Establece la identificación del propietario.
     * 
     * @param identificacion Nueva identificación del propietario.
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Obtiene el país de residencia del propietario.
     * 
     * @return País del propietario.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país de residencia del propietario.
     * 
     * @param pais Nuevo país del propietario.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Obtiene la fecha en que el propietario adquirió la moneda.
     * 
     * @return Fecha de adquisición.
     */
    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    /**
     * Establece la fecha en que el propietario adquirió la moneda.
     * 
     * @param fechaAdquisicion Nueva fecha de adquisición.
     */
    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    /**
     * Representación en texto del propietario.
     * 
     * @return Cadena con nombre, identificación, país y fecha de adquisición.
     */
    @Override
    public String toString() {
        return nombre + " - ID: " + identificacion + " (" + pais + "), adquirido: " + fechaAdquisicion;
    }
}
