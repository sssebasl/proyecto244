package co.edu.poli.actividad3.modelo;

public class Moneda {
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

     // Método final que no se puede sobreescribir
    public final String obtenerCodigoUnico() {
        return codigoUnico;
    }
      // La clase que no se puede heredar es MetodoAdquisicion
      
    public Moneda() {
        this.codigoUnico = "SIN_CODIGO"; // Valor por defecto
    }

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

    public int getEdadActual() {
        return java.time.Year.now().getValue() - this.anio;
    }

    // Método sobreescrito
    public String obtenerDescripcion() {
        return "Moneda emitida por " + pais;
    }

    public String obtenerDescripcion(String detalleExtra) {
        return obtenerDescripcion() + ". Detalles adicionales: " + detalleExtra;
    }

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

   
}
