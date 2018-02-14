package com.mrdiaz.portatileslistfragment;

/**
 * Created by mrdiaz on 14/02/2018.
 */

public class Portatil {

    public String modelo;
    public String marca;
    public int precio;
    public String foto;

    public Portatil(String modelo, String marca, int precio, String foto) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.foto = foto;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
