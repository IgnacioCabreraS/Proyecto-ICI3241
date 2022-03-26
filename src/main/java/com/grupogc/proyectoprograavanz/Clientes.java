
package com.grupogc.proyectoprograavanz;
//import java.util.ArrayList;
//import java.util.List;

public class Clientes {
    
    private String nombre;
    private int rut;
    private int numeroTelefonico;
    //private final List <Servicios> listServicio;
   
    //Servicios listaServicio (dentro del constructor)
    public Clientes(String nombre, int rut, int numeroTelefonico){
        
        this.nombre = nombre;
        this.rut = rut;
        this.numeroTelefonico = numeroTelefonico;
        //this.listServicio = new ArrayList();
    }
       
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setRut(int rut) {
        this.rut = rut;
    }
    
    public int getRut() {
        return rut;
    }
    public void setNumeroTelefonico(int numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public int getNumeroTelefonico() {
        return numeroTelefonico;
    }

}


