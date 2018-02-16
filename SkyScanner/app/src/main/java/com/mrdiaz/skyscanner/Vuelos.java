package com.mrdiaz.skyscanner;

/**
 * Created by mrdiaz on 15/02/2018.
 */

public class Vuelos {

    private String nombreCompanya;
    private String salida;
    private String llegada;
    private int precio;
    private String foto;

    public Vuelos(String nombreCompanya, String salida, String llegada, int precio, String foto) {
        this.nombreCompanya = nombreCompanya;
        this.salida = salida;
        this.llegada = llegada;
        this.precio = precio;
        this.foto = foto;
    }

    public String getNombreCompanya() {
        return nombreCompanya;
    }

    public void setNombreCompanya(String nombreCompanya) {
        this.nombreCompanya = nombreCompanya;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
