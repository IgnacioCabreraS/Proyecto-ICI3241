/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectogestion;
/**
 * Equipo con sus atributos.
 */
public class Equipos implements describible{
    private String modeloEquipo;
    private String marca;
    private int capacBat;
    private int precio;
    private String compani;
    private int numeroProducto;
    
    public Equipos( String modeloEquipo,  String marca,  int capacBat,  int precio, String compani,int numeroProducto) {
        this.modeloEquipo = modeloEquipo;
        this.capacBat = capacBat;
        this.marca = marca;
        this.precio = precio;
        this.compani = compani;
        this.numeroProducto = numeroProducto;
    }
    
    public Equipos() {
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

    public String getCompani() {
        return compani;
    }

    public void setCompani(String compani) {
        this.compani = compani;
    }

    public int getNumeroProducto() {
        return numeroProducto;
    }

    public void setNumeroProducto(int numeroProducto) {
        this.numeroProducto = numeroProducto;
    }
    
    @Override
    public void descripcion() {
        System.out.println("");
        System.out.println(" -------------------");
        System.out.println("|   Datos Equipo   |");
        System.out.println(" -------------------");
        System.out.println("");
        System.out.println("Modelo: "+modeloEquipo);
        System.out.println("");
    }
    
    
    
    //-------------------SOBRE CARGA DE METODOS---------------------------------
    
    public void mostrarDetalles( int precio,  String modeloEquipo,  String marca,  int capacBat) {
        System.out.println("|| Precio: " + precio + "|| Modelo: " + modeloEquipo + "|| Marca: " + marca + "|| Capacidad bateria (mAh)" + capacBat);
    }
    
    public void mostrarDetalles( int precio,  String modeloEquipo) {
        System.out.println("Precio del equipo: " + precio + ". Modelo: " + modeloEquipo);
    }
}

