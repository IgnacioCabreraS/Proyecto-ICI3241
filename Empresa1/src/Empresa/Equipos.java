/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

public class Equipos
{
    private String modeloEquipo;
    private String marca;
    private int capacBat;
    private int precio;
    
    public Equipos( String modeloEquipo,  String marca,  int capacBat,  int precio) {
        this.modeloEquipo = modeloEquipo;
        this.capacBat = capacBat;
        this.marca = marca;
        this.precio = precio;
    }
    
    public Equipos() {
    }
    
    public void mostrarDetalles( int precio,  String modeloEquipo,  String marca,  int capacBat) {
        System.out.println("|| Precio: " + precio + "|| Modelo: " + modeloEquipo + "|| Marca: " + marca + "|| Capacidad bateria (mAh)" + capacBat);
    }
    
    public void mostrarDetalles( int precio,  String modeloEquipo) {
        System.out.println("Precio del equipo: " + precio + ". Modelo: " + modeloEquipo);
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca( String marca) {
        this.marca = marca;
    }
    
    public int getPrecio() {
        return precio;
    }
    
    public void setPrecio( int precio) {
        this.precio = precio;
    }
    
    public int getCapacBat() {
        return capacBat;
    }
    
    public void setCapacBat( int capacBat) {
        this.capacBat = capacBat;
    }
    
    public String getModeloEquipo() {
        return modeloEquipo;
    }
    
    public void setModeloEquipo( String modeloEquipo) {
        this.modeloEquipo = modeloEquipo;
    }
}

