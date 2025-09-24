package co.edu.poli.actividad3.modelo;

public class Pais {
    private String nombre;
    private String codigoISO;
    private String ciudad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Pais() {}

    public Pais(String nombre, String codigoISO, String ciudad) {
        this.nombre = nombre;
        this.codigoISO = codigoISO;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigoISO + "), " + ciudad;
    }
}