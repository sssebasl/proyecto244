package co.edu.poli.actividad3.modelo;

public class MonedaEuropea extends Moneda {

    private boolean esZonaEuro;

    public MonedaEuropea() {
        super();
    }

    public MonedaEuropea(int anio, int valor, double denominacion, String rareza, String material,
                         String serial, double tamano, double peso, String forma, double diametro,
                         Pais pais, Conservacion conservacion, Propietario propietario,
                         Certificado certificado, MetodoAdquisicion metodoAdquisicion,
                         boolean esZonaEuro) {
        super(anio, valor, denominacion, rareza, material, serial, tamano, peso, forma, diametro,
              pais, conservacion, propietario, certificado, metodoAdquisicion);
        this.esZonaEuro = esZonaEuro;
    }

    @Override
    public String obtenerDescripcion() {
        return "Moneda europea - Zona Euro: " + (esZonaEuro ? "Sí" : "No");
    }

    @Override
    public String toString() {
        return super.toString() +
               ", MonedaEuropea [esZonaEuro=" + esZonaEuro + "]";
    }

    // Getters y Setters
    public boolean isEsZonaEuro() {
        return esZonaEuro;
    }

    public void setEsZonaEuro(boolean esZonaEuro) {
        this.esZonaEuro = esZonaEuro;
    }
}

