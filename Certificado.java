package co.edu.poli.actividad3.modelo;
public class Certificado {
    private int anio;
    private String pais;
    private String serial;
    private String entidad;
    private String fechaCertificacion;
    private int anterioresDuenos;
    private boolean autenticidad;
    private boolean edicionEspecial;

    public Certificado(int anio, String pais, String serial, String entidad, String fechaCertificacion,
                       int anterioresDuenos, boolean autenticidad, boolean edicionEspecial) {
        this.anio = anio;
        this.pais = pais;
        this.serial = serial;
        this.entidad = entidad;
        this.fechaCertificacion = fechaCertificacion;
        this.anterioresDuenos = anterioresDuenos;
        this.autenticidad = autenticidad;
        this.edicionEspecial = edicionEspecial;
    }

    public Certificado() {}

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getSerial() { return serial; }
    public void setSerial(String serial) { this.serial = serial; }

    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }

    public String getFechaCertificacion() { return fechaCertificacion; }
    public void setFechaCertificacion(String fechaCertificacion) { this.fechaCertificacion = fechaCertificacion; }

    public int getAnterioresDuenos() { return anterioresDuenos; }
    public void setAnterioresDuenos(int anterioresDuenos) { this.anterioresDuenos = anterioresDuenos; }

    public boolean isAutenticidad() { return autenticidad; }
    public void setAutenticidad(boolean autenticidad) { this.autenticidad = autenticidad; }

    public boolean isEdicionEspecial() { return edicionEspecial; }
    public void setEdicionEspecial(boolean edicionEspecial) { this.edicionEspecial = edicionEspecial; }

    @Override
    public String toString() {
        return "Certificado{" +
                "anio=" + anio +
                ", pais='" + pais + '\'' +
                ", serial='" + serial + '\'' +
                ", entidad='" + entidad + '\'' +
                ", fechaCertificacion='" + fechaCertificacion + '\'' +
                ", anterioresDuenos=" + anterioresDuenos +
                ", autenticidad=" + autenticidad +
                ", edicionEspecial=" + edicionEspecial +
                '}';
    }
}
