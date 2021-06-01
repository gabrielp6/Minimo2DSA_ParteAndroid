package edu.upc.dsa.minimo2;

public class Insignia {

    private String nombre;
    private String url_Imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl_Imagen() {
        return url_Imagen;
    }

    public void setUrl_Imagen(String url_Imagen) {
        this.url_Imagen = url_Imagen;
    }

    public Insignia(String nombre, String url_Imagen) {
        this.nombre = nombre;
        this.url_Imagen = url_Imagen;
    }

    public Insignia() {
    }
}
