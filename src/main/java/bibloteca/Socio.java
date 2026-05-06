package biblioteca;

public class Socio {

    private String nombre;
    private String idSocio;

    public Socio(String nombre, String idSocio) {
        this.nombre  = nombre;
        this.idSocio = idSocio;
    }

    public String getNombre()  { return nombre; }
    public String getIdSocio() { return idSocio; }

    public void setNombre(String nombre)   { this.nombre  = nombre; }
    public void setIdSocio(String idSocio) { this.idSocio = idSocio; }

    @Override
    public String toString() {
        return "[SOCIO] " + nombre + " | ID: " + idSocio;
    }
}