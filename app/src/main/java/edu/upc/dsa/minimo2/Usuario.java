package edu.upc.dsa.minimo2;

import java.util.ArrayList;

public class Usuario {
    private String username;
    private String correo;
    ArrayList<Insignia> listaInsignias =new ArrayList<Insignia>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Insignia> getListaInsignias() {
        return listaInsignias;
    }

    public void setListaInsignias(ArrayList<Insignia> listaInsignias) {
        this.listaInsignias = listaInsignias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario(String username, String correo, ArrayList<Insignia> insignias) {
        this.username = username;
        this.correo= correo;
        this.listaInsignias = insignias;
    }

    public Usuario() {
    }
}
