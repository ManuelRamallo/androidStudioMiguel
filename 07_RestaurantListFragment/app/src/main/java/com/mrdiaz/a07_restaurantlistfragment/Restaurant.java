package com.mrdiaz.a07_restaurantlistfragment;

/**
 * Created by mrdiaz on 13/02/2018.
 */

public class Restaurant {

    public String nombre;
    public String direccion;
    public String foto;
    public int rate;

    public Restaurant(String nombre, String direccion, String foto, int rate) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.foto = foto;
        this.rate = rate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
