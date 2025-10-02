package co.edu.poli.actividad3.modelo;

import java.io.Serializable;

/**
 * Representa el método de adquisición de una moneda.
 * Indica si la moneda fue adquirida por subasta, compra o regalo,
 * y contiene un identificador único de registro.
 * 
 * Esta clase es final, por lo que no puede ser extendida.
 * 
 * @author [Sebastian Ladino Villamil]
 */
public final class MetodoAdquisicion implements Serializable{
    private boolean esSubasta;
    private boolean esCompra;
    private boolean esRegalo;
    private String idRegistro;

    /**
     * Constructor por defecto.
     */
    public MetodoAdquisicion() {}

    /**
     * Constructor con parámetros para inicializar todos los atributos.
     * 
     * @param esSubasta Indica si la moneda fue adquirida en subasta.
     * @param esCompra Indica si la moneda fue adquirida por compra.
     * @param esRegalo Indica si la moneda fue adquirida como regalo.
     * @param idRegistro Identificador único de registro.
     */
    public MetodoAdquisicion(boolean esSubasta, boolean esCompra, boolean esRegalo, String idRegistro) {
        this.esSubasta = esSubasta;
        this.esCompra = esCompra;
        this.esRegalo = esRegalo;
        this.idRegistro = idRegistro;
    }

    /**
     * Indica si la moneda fue adquirida en subasta.
     * @return true si fue por subasta, false en caso contrario.
     */
    public boolean isEsSubasta() { return esSubasta; }

    /**
     * Establece si la moneda fue adquirida en subasta.
     * @param esSubasta true para indicar adquisición por subasta.
     */
    public void setEsSubasta(boolean esSubasta) { this.esSubasta = esSubasta; }

    /**
     * Indica si la moneda fue adquirida por compra.
     * @return true si fue por compra, false en caso contrario.
     */
    public boolean isEsCompra() { return esCompra; }

    /**
     * Establece si la moneda fue adquirida por compra.
     * @param esCompra true para indicar adquisición por compra.
     */
    public void setEsCompra(boolean esCompra) { this.esCompra = esCompra; }

    /**
     * Indica si la moneda fue adquirida como regalo.
     * @return true si fue regalo, false en caso contrario.
     */
    public boolean isEsRegalo() { return esRegalo; }

    /**
     * Establece si la moneda fue adquirida como regalo.
     * @param esRegalo true para indicar adquisición como regalo.
     */
    public void setEsRegalo(boolean esRegalo) { this.esRegalo = esRegalo; }

    /**
     * Obtiene el identificador único de registro.
     * @return Identificador de registro.
     */
    public String getIdRegistro() { return idRegistro; }

    /**
     * Establece el identificador único de registro.
     * @param idRegistro Identificador de registro.
     */
    public void setIdRegistro(String idRegistro) { this.idRegistro = idRegistro; }

    /**
     * Representación en texto del método de adquisición.
     * @return Cadena con los valores de los atributos.
     */
    @Override
    public String toString() {
        return "MetodoAdquisicion [esSubasta=" + esSubasta
                + ", esCompra=" + esCompra
                + ", esRegalo=" + esRegalo
                + ", idRegistro=" + idRegistro + "]";
    }
}
