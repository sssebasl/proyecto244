package co.edu.poli.actividad3.modelo;

public class Conservacion {
    private boolean circulacion;
    private boolean coleccion;
    private boolean descontinuada;
    private String idRegistro;

    public Conservacion() {}

    public Conservacion(boolean circulacion, boolean coleccion, boolean descontinuada, String idRegistro) {
        this.circulacion = circulacion;
        this.coleccion = coleccion;
        this.descontinuada = descontinuada;
        this.idRegistro = idRegistro;
    }

    public boolean isCirculacion() {
        return circulacion;
    }

    public void setCirculacion(boolean circulacion) {
        this.circulacion = circulacion;
    }

    public boolean isColeccion() {
        return coleccion;
    }

    public void setColeccion(boolean coleccion) {
        this.coleccion = coleccion;
    }

    public boolean isDescontinuada() {
        return descontinuada;
    }

    public void setDescontinuada(boolean descontinuada) {
        this.descontinuada = descontinuada;
    }

    public String getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    @Override
    public String toString() {
        return "Conservacion{" +
                "circulacion=" + circulacion +
                ", coleccion=" + coleccion +
                ", descontinuada=" + descontinuada +
                ", idRegistro='" + idRegistro + '\'' +
                '}';
    }
}