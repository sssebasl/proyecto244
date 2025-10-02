package co.edu.poli.actividad3.modelo;
import java.io.Serializable;

/**
 * Clase que representa una moneda asiática.
 * Hereda de la clase abstracta Moneda e incluye un atributo específico:
 * el nivel de inflación asociado a la moneda.
 * 
 * Implementa el método abstracto mostrarInformacion para mostrar detalles específicos.
 * 
 * @author [Sebastian Ladino Villamil]
 */
public class MonedaAsiatica extends Moneda implements Serializable{

    private double nivelInflacion;

    /**
     * Constructor por defecto.
     */
    public MonedaAsiatica() {
        super();
    }

    /**
     * Constructor con parámetros para inicializar todos los atributos de la moneda asiática.
     * 
     * @param anio Año de emisión.
     * @param valor Valor nominal.
     * @param denominacion Denominación.
     * @param rareza Nivel de rareza.
     * @param material Material de la moneda.
     * @param serial Código serial.
     * @param tamano Tamaño físico.
     * @param peso Peso de la moneda.
     * @param forma Forma de la moneda.
     * @param diametro Diámetro.
     * @param pais País emisor.
     * @param conservacion Estado de conservación.
     * @param propietario Propietario actual.
     * @param certificado Certificado de autenticidad.
     * @param metodoAdquisicion Método de adquisición.
     * @param nivelInflacion Nivel de inflación asociado.
     */
    public MonedaAsiatica(int anio, int valor, double denominacion, String rareza, String material,
                          String serial, double tamano, double peso, String forma, double diametro,
                          Pais pais, Conservacion conservacion, Propietario propietario,
                          Certificado certificado, MetodoAdquisicion metodoAdquisicion,
                          double nivelInflacion) {
        super(anio, valor, denominacion, rareza, material, serial, tamano, peso, forma, diametro,
              pais, conservacion, propietario, certificado, metodoAdquisicion);
        this.nivelInflacion = nivelInflacion;
    }

    /**
     * Obtiene la descripción específica de la moneda asiática, incluyendo nivel de inflación.
     * 
     * @return Descripción de la moneda asiática.
     */
    @Override
    public String obtenerDescripcion() {
        return "Moneda asiática - Nivel de inflación: " + nivelInflacion + "%";
    }

    /**
     * Representación en texto de la moneda asiática, incluyendo el nivel de inflación.
     * 
     * @return Cadena con información completa de la moneda asiática.
     */
    @Override
    public String toString() {
        return super.toString() +
               ", MonedaAsiatica [nivelInflacion=" + nivelInflacion + "]";
    }

    /**
     * Muestra información detallada de la moneda asiática por consola.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Moneda Asiática: " + this.toString());
    }

    /**
     * Obtiene el nivel de inflación asociado a la moneda.
     * 
     * @return Nivel de inflación.
     */
    public double getNivelInflacion() {
        return nivelInflacion;
    }

    /**
     * Establece el nivel de inflación de la moneda.
     * 
     * @param nivelInflacion Nuevo nivel de inflación.
     */
    public void setNivelInflacion(double nivelInflacion) {
        this.nivelInflacion = nivelInflacion;
    }
}
