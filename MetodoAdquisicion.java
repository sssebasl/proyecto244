package co.edu.poli.actividad3.modelo;

public final class MetodoAdquisicion {
    private boolean esSubasta;
    private boolean esCompra;
    private boolean esRegalo;
    private String idRegistro;

    public MetodoAdquisicion() {}

    public MetodoAdquisicion(boolean esSubasta, boolean esCompra, boolean esRegalo, String idRegistro) {
        this.esSubasta = esSubasta;
        this.esCompra = esCompra;
        this.esRegalo = esRegalo;
        this.idRegistro = idRegistro;
    }

    @Override
    public String toString() {
        return "MetodoAdquisicion [esSubasta=" + esSubasta
                + ", esCompra=" + esCompra
                + ", esRegalo=" + esRegalo
                + ", idRegistro=" + idRegistro + "]";
    }

    public boolean isEsSubasta() { return esSubasta; }
    public void setEsSubasta(boolean esSubasta) { this.esSubasta = esSubasta; }

    public boolean isEsCompra() { return esCompra; }
    public void setEsCompra(boolean esCompra) { this.esCompra = esCompra; }

    public boolean isEsRegalo() { return esRegalo; }
    public void setEsRegalo(boolean esRegalo) { this.esRegalo = esRegalo; }

    public String getIdRegistro() { return idRegistro; }
    public void setIdRegistro(String idRegistro) { this.idRegistro = idRegistro; }
}
