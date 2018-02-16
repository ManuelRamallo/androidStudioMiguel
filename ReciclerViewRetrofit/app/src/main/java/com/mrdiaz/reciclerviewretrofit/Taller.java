package com.mrdiaz.reciclerviewretrofit;

/**
 * Created by mrdiaz on 16/02/2018.
 */

public class Taller {

    private String id;
    private String nombre;
    private String latlng;
    private String direccion;
    private String telefono;

    public Taller() {
    }

    public Taller(String id, String nombre, String latlng, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.latlng = latlng;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
