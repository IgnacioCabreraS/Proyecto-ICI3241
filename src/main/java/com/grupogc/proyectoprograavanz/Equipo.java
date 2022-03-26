
package com.grupogc.proyectoprograavanz;

public class Equipo {

    private String modelo;
    private int año;
    private int precio;

    public Equipo(String modelo, int año, int precio){

        this.modelo = modelo;
        this.año = año;
        this.precio = precio;
    }
    
    Equipo() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}


