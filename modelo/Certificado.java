package co.edu.poli.actividad3.modelo;
import java.io.Serializable;

/**
 * Representa un certificado de autenticidad para una moneda.
 * Contiene información como el año, país, serial, entidad certificadora,
 * fecha de certificación, número de dueños anteriores, y banderas de autenticidad y edición especial.
 * 
 * @author [Sebastian Ladino Villamil]
 * @version 1.0
 */
public class Certificado implements Serializable {

    /**
     * Año en que se emitió el certificado.
     */
    private int anio;

    /**
     * País donde se emitió el certificado.
     */
    private String pais;

    /**
     * Código serial único del certificado.
     */
    private String serial;

    /**
     * Entidad que emitió el certificado.
     */
    private String entidad;

    /**
     * Fecha en formato String en la que se certificó la moneda.
     */
    private String fechaCertificacion;

    /**
     * Número de dueños anteriores que ha tenido la moneda.
     */
    private int anterioresDuenos;

    /**
     * Indica si el certificado garantiza la autenticidad de la moneda.
     */
    private boolean autenticidad;

    /**
     * Indica si el certificado corresponde a una edición especial.
     */
    private boolean edicionEspecial;

    /**
     * Constructor completo para inicializar todos los atributos del certificado.
     * 
     * @param anio Año en que se emitió el certificado.
     * @param pais País donde se emitió el certificado.
     * @param serial Código serial único del certificado.
     * @param entidad Entidad que emitió el certificado.
     * @param fechaCertificacion Fecha en la que se certificó la moneda.
     * @param anterioresDuenos Número de dueños anteriores de la moneda.
     * @param autenticidad Indica si el certificado garantiza autenticidad.
     * @param edicionEspecial Indica si es una edición especial.
     */
    public Certificado(int anio, String pais, String serial, String entidad, String fechaCertificacion,
                       int anterioresDuenos, boolean autenticidad, boolean edicionEspecial) {
        this.anio = anio;
        this.pais = pais;
        this.serial = serial;
        this.entidad = entidad;
        this.fechaCertificacion = fechaCertificacion;
        this.anterioresDuenos = anterioresDuenos;
        this.autenticidad = autenticidad;
        this.edicionEspecial = edicionEspecial;
    }

    /**
     * Constructor vacío por defecto.
     */
    public Certificado() {}

    /**
     * Obtiene el año de emisión del certificado.
     * @return Año del certificado.
     */
    public int getAnio() { return anio; }

    /**
     * Establece el año de emisión del certificado.
     * @param anio Año a establecer.
     */
    public void setAnio(int anio) { this.anio = anio; }

    /**
     * Obtiene el país donde se emitió el certificado.
     * @return País del certificado.
     */
    public String getPais() { return pais; }

    /**
     * Establece el país donde se emitió el certificado.
     * @param pais País a establecer.
     */
    public void setPais(String pais) { this.pais = pais; }

    /**
     * Obtiene el código serial del certificado.
     * @return Serial del certificado.
     */
    public String getSerial() { return serial; }

    /**
     * Establece el código serial del certificado.
     * @param serial Serial a establecer.
     */
    public void setSerial(String serial) { this.serial = serial; }

    /**
     * Obtiene la entidad que emitió el certificado.
     * @return Entidad certificadora.
     */
    public String getEntidad() { return entidad; }

    /**
     * Establece la entidad que emitió el certificado.
     * @param entidad Entidad a establecer.
     */
    public void setEntidad(String entidad) { this.entidad = entidad; }

    /**
     * Obtiene la fecha de certificación de la moneda.
     * @return Fecha de certificación.
     */
    public String getFechaCertificacion() { return fechaCertificacion; }

    /**
     * Establece la fecha de certificación de la moneda.
     * @param fechaCertificacion Fecha a establecer.
     */
    public void setFechaCertificacion(String fechaCertificacion) { this.fechaCertificacion = fechaCertificacion; }

    /**
     * Obtiene la cantidad de dueños anteriores de la moneda.
     * @return Número de dueños anteriores.
     */
    public int getAnterioresDuenos() { return anterioresDuenos; }

    /**
     * Establece la cantidad de dueños anteriores de la moneda.
     * @param anterioresDuenos Número a establecer.
     */
    public void setAnterioresDuenos(int anterioresDuenos) { this.anterioresDuenos = anterioresDuenos; }

    /**
     * Indica si el certificado garantiza la autenticidad de la moneda.
     * @return true si es auténtico, false en caso contrario.
     */
    public boolean isAutenticidad() { return autenticidad; }

    /**
     * Establece si el certificado garantiza la autenticidad.
     * @param autenticidad Valor booleano a establecer.
     */
    public void setAutenticidad(boolean autenticidad) { this.autenticidad = autenticidad; }

    /**
     * Indica si el certificado corresponde a una edición especial.
     * @return true si es edición especial, false en caso contrario.
     */
    public boolean isEdicionEspecial() { return edicionEspecial; }

    /**
     * Establece si el certificado es una edición especial.
     * @param edicionEspecial Valor booleano a establecer.
     */
    public void setEdicionEspecial(boolean edicionEspecial) { this.edicionEspecial = edicionEspecial; }

    /**
     * Retorna una representación en String de todos los atributos del certificado.
     * @return Cadena con la información del certificado.
     */
    @Override
    public String toString() {
        return "Certificado{" +
                "anio=" + anio +
                ", pais='" + pais + '\'' +
                ", serial='" + serial + '\'' +
                ", entidad='" + entidad + '\'' +
                ", fechaCertificacion='" + fechaCertificacion + '\'' +
                ", anterioresDuenos=" + anterioresDuenos +
                ", autenticidad=" + autenticidad +
                ", edicionEspecial=" + edicionEspecial +
                '}';
    }
}
