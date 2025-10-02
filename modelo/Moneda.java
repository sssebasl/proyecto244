package co.edu.poli.actividad3.modelo;
import java.io.Serializable;
/**
 * Clase abstracta que representa una moneda.
 * Contiene atributos básicos y relacionados con la moneda,
 * como país, estado de conservación, propietario, certificado,
 * método de adquisición y un código único.
 * 
 * Esta clase define métodos para obtener descripción y calcular edad,
 * además de un método abstracto que deben implementar las subclases.
 * 
 * @author [Sebastian Ladino Villamil]
 */
public abstract class Moneda implements Serializable{  // <-- Cambiado a abstracta
    private int anio;
    private int valor;
    private double denominacion;
    private String rareza;
    private String material;
    private String serial;
    private double tamano;
    private double peso;
    private String forma;
    private double diametro;

    private Pais pais;
    private Conservacion conservacion;
    private Propietario propietario;
    private Certificado certificado;
    private MetodoAdquisicion metodoAdquisicion;

    // Atributo que no se puede cambiar (final)
    private final String codigoUnico;

    /**
     * Método final que retorna el código único de la moneda.
     * No puede ser sobrescrito por subclases.
     * 
     * @return Código único generado para la moneda.
     */
    public final String obtenerCodigoUnico() {
        return codigoUnico;
    }

    /**
     * Constructor por defecto que asigna un código único por defecto.
     */
    public Moneda() {
        this.codigoUnico = "SIN_CODIGO"; // Valor por defecto
    }

    /**
     * Constructor con parámetros para inicializar todos los atributos.
     * El código único se genera combinando el serial y el año.
     * 
     * @param anio Año de emisión de la moneda.
     * @param valor Valor nominal de la moneda.
     * @param denominacion Denominación monetaria.
     * @param rareza Nivel de rareza.
     * @param material Material con el que está hecha la moneda.
     * @param serial Código serial de la moneda.
     * @param tamano Tamaño físico de la moneda.
     * @param peso Peso de la moneda.
     * @param forma Forma de la moneda.
     * @param diametro Diámetro de la moneda.
     * @param pais País emisor.
     * @param conservacion Estado de conservación.
     * @param propietario Información del propietario.
     * @param certificado Certificado asociado.
     * @param metodoAdquisicion Método por el cual se adquirió la moneda.
     */
    public Moneda(int anio, int valor, double denominacion, String rareza, String material,
                  String serial, double tamano, double peso, String forma, double diametro,
                  Pais pais, Conservacion conservacion, Propietario propietario,
                  Certificado certificado, MetodoAdquisicion metodoAdquisicion) {
        this.anio = anio;
        this.valor = valor;
        this.denominacion = denominacion;
        this.rareza = rareza;
        this.material = material;
        this.serial = serial;
        this.tamano = tamano;
        this.peso = peso;
        this.forma = forma;
        this.diametro = diametro;
        this.pais = pais;
        this.conservacion = conservacion;
        this.propietario = propietario;
        this.certificado = certificado;
        this.metodoAdquisicion = metodoAdquisicion;
        this.codigoUnico = serial + "-" + anio; // Ejemplo de código único
    }

    // Getters y setters
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public int getValor() { return valor; }
    public void setValor(int valor) { this.valor = valor; }

    public double getDenominacion() { return denominacion; }
    public void setDenominacion(double denominacion) { this.denominacion = denominacion; }

    public String getRareza() { return rareza; }
    public void setRareza(String rareza) { this.rareza = rareza; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getSerial() { return serial; }
    public void setSerial(String serial) { this.serial = serial; }

    public double getTamano() { return tamano; }
    public void setTamano(double tamano) { this.tamano = tamano; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getForma() { return forma; }
    public void setForma(String forma) { this.forma = forma; }

    public double getDiametro() { return diametro; }
    public void setDiametro(double diametro) { this.diametro = diametro; }

    public Pais getPais() { return pais; }
    public void setPais(Pais pais) { this.pais = pais; }

    public Conservacion getConservacion() { return conservacion; }
    public void setConservacion(Conservacion conservacion) { this.conservacion = conservacion; }

    public Propietario getPropietario() { return propietario; }
    public void setPropietario(Propietario propietario) { this.propietario = propietario; }

    public Certificado getCertificado() { return certificado; }
    public void setCertificado(Certificado certificado) { this.certificado = certificado; }

    public MetodoAdquisicion getMetodoAdquisicion() { return metodoAdquisicion; }
    public void setMetodoAdquisicion(MetodoAdquisicion metodoAdquisicion) { this.metodoAdquisicion = metodoAdquisicion; }

    /**
     * Calcula la edad actual de la moneda en años con base en el año actual.
     * 
     * @return Edad en años desde el año de emisión.
     */
    public int getEdadActual() {
        return java.time.Year.now().getValue() - this.anio;
    }

    /**+ mostrarInformacion(): void
     * Método que retorna una descripción simple de la moneda.
     * Puede ser sobrescrito por subclases para proporcionar detalles.
     * 
     * @return Descripción simple de la moneda.
     */
    public String obtenerDescripcion() {
        return "Moneda emitida por " + pais;
    }

    /**
     * Método que retorna una descripción de la moneda con detalles adicionales.
     * 
     * @param detalleExtra Información adicional para la descripción.
     * @return Descripción extendida de la moneda.
     */
    public String obtenerDescripcion(String detalleExtra) {
        return obtenerDescripcion() + ". Detalles adicionales: " + detalleExtra;
    }

    /**
     * Representación en texto de todos los atributos de la moneda.
     * 
     * @return Cadena con valores de todos los atributos.
     */
    @Override
    public String toString() {
        return "Moneda{" +
                "anio=" + anio +
                ", valor=" + valor +
                ", denominacion=" + denominacion +
                ", rareza='" + rareza + '\'' +
                ", material='" + material + '\'' +
                ", serial='" + serial + '\'' +
                ", tamano=" + tamano +
                ", peso=" + peso +
                ", forma='" + forma + '\'' +
                ", diametro=" + diametro +
                ", pais=" + pais +
                ", conservacion=" + conservacion +
                ", propietario=" + propietario +
                ", certificado=" + certificado +
                ", metodoAdquisicion=" + metodoAdquisicion +
                ", codigoUnico='" + codigoUnico + '\'' +
                '}';
    }

    /**
     * Método abstracto que deben implementar las subclases para mostrar información específica.
     */
    public abstract void mostrarInformacion();

    // === MÉTODOS EQUALS Y HASHCODE AÑADIDOS ===

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Moneda moneda = (Moneda) obj;

        return codigoUnico != null ? codigoUnico.equals(moneda.codigoUnico) : moneda.codigoUnico == null;
    }

    @Override
    public int hashCode() {
        return codigoUnico != null ? codigoUnico.hashCode() : 0;
    }
}
