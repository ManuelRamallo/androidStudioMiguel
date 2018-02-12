package com.mramallo.mecaroundapp;

/**
 * Created by ridex on 12/02/2018.
 */

public class TallerItem {

    private String foto;
    private String nombre;
    private int telefono;
    private String dirección;

    public TallerItem() {
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }
}
