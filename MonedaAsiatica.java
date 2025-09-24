package co.edu.poli.actividad3.modelo;

public class MonedaAsiatica extends Moneda {

    private double nivelInflacion;

    public MonedaAsiatica() {
        super();
    }

    public MonedaAsiatica(int anio, int valor, double denominacion, String rareza, String material,
                          String serial, double tamano, double peso, String forma, double diametro,
                          Pais pais, Conservacion conservacion, Propietario propietario,
                          Certificado certificado, MetodoAdquisicion metodoAdquisicion,
                          double nivelInflacion) {
        super(anio, valor, denominacion, rareza, material, serial, tamano, peso, forma, diametro,
              pais, conservacion, propietario, certificado, metodoAdquisicion);
        this.nivelInflacion = nivelInflacion;
    }

    @Override
    public String obtenerDescripcion() {
        return "Moneda asiática - Nivel de inflación: " + nivelInflacion + "%";
    }

    @Override
    public String toString() {
        return super.toString() +
               ", MonedaAsiatica [nivelInflacion=" + nivelInflacion + "]";
    }

    // Getters y Setters
    public double getNivelInflacion() {
        return nivelInflacion;
    }

    public void setNivelInflacion(double nivelInflacion) {
        this.nivelInflacion = nivelInflacion;
    }
}
