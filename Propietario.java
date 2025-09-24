package co.edu.poli.actividad3.modelo;

public class Propietario {
    private String nombre;
    private String identificacion;
    private String pais;
    private String fechaAdquisicion;

    public Propietario() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Propietario(String nombre, String identificacion, String pais, String fechaAdquisicion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.pais = pais;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    @Override
    public String toString() {
        return nombre + " - ID: " + identificacion + " (" + pais + "), adquirido: " + fechaAdquisicion;
    }
}