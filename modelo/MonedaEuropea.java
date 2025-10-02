package co.edu.poli.actividad3.modelo;
import java.io.Serializable;
/**
 * Clase que representa una moneda europea.
 * Hereda de la clase abstracta Moneda e incluye un atributo específico:
 * si pertenece o no a la zona Euro.
 * 
 * Implementa el método abstracto mostrarInformacion para mostrar detalles específicos.
 * 
 * @author [Sebastian Ladino Villamil]
 */
public class MonedaEuropea extends Moneda implements Serializable{

    private boolean esZonaEuro;

    /**
     * Constructor por defecto.
     */
    public MonedaEuropea() {
        super();
    }

    /**
     * Constructor con parámetros para inicializar todos los atributos de la moneda europea.
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
     * @param esZonaEuro Indica si la moneda pertenece a la zona Euro.
     */
    public MonedaEuropea(int anio, int valor, double denominacion, String rareza, String material,
                         String serial, double tamano, double peso, String forma, double diametro,
                         Pais pais, Conservacion conservacion, Propietario propietario,
                         Certificado certificado, MetodoAdquisicion metodoAdquisicion,
                         boolean esZonaEuro) {
        super(anio, valor, denominacion, rareza, material, serial, tamano, peso, forma, diametro,
              pais, conservacion, propietario, certificado, metodoAdquisicion);
        this.esZonaEuro = esZonaEuro;
    }

    /**
     * Obtiene la descripción específica de la moneda europea, indicando si es zona Euro.
     * 
     * @return Descripción de la moneda europea.
     */
    @Override
    public String obtenerDescripcion() {
        return "Moneda europea - Zona Euro: " + (esZonaEuro ? "Sí" : "No");
    }

    /**
     * Representación en texto de la moneda europea, incluyendo si es zona Euro.
     * 
     * @return Cadena con información completa de la moneda europea.
     */
    @Override
    public String toString() {
        return super.toString() +
               ", MonedaEuropea [esZonaEuro=" + esZonaEuro + "]";
    }

    /**
     * Muestra información detallada de la moneda europea por consola.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Moneda Europea: " + this.toString());
    }

    /**
     * Indica si la moneda pertenece a la zona Euro.
     * 
     * @return true si es zona Euro, false en caso contrario.
     */
    public boolean isEsZonaEuro() {
        return esZonaEuro;
    }

    /**
     * Establece si la moneda pertenece a la zona Euro.
     * 
     * @param esZonaEuro Nuevo valor para la pertenencia a la zona Euro.
     */
    public void setEsZonaEuro(boolean esZonaEuro) {
        this.esZonaEuro = esZonaEuro;
    }
}
