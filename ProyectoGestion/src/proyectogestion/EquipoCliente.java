/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectogestion;

//import java.util.*;

/**
 * EquiposClientes con cada uno de sus atributos dando un valor y retornando ese valor.
 */
public class EquipoCliente implements describible{   
    
    private String modelo;
    private String numeroTelefonico;
    private String codigoTelefono;
    private String rutCliente;
    private String compani;
    
    public EquipoCliente(){
        
    }
    public EquipoCliente( String modelo,  String numeroTelefonico, String codigoTelefono, String rutCliente, String compani) {
        this.modelo = modelo;
        this.numeroTelefonico = numeroTelefonico;
        this.codigoTelefono = codigoTelefono;
        this.rutCliente = rutCliente;
        this.compani = compani;

    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getCompani() {
        return compani;
    }

    public void setCompani(String compani) {
        this.compani = compani;
    }
 

    public String getCodigoTelefono() {
        return codigoTelefono;
    }

    public void setCodigoTelefono(String codigoTelefono) {
        this.codigoTelefono = codigoTelefono;
    }
    
    
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }
    
    public void setNumeroTelefonico( String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo( String modelo) {
        this.modelo = modelo;
    }
    
    // crear una clase creacion para este metodo y los demas.
    
    public EquipoCliente createEquipC (String data) {
        String[] camposEc = new String[5];
        camposEc = data.split(",");
        EquipoCliente equiposC = new EquipoCliente(camposEc[0], camposEc[1],camposEc[2],camposEc[3],camposEc[4]);
        
        return equiposC;
    }
    
    public void descripcion(){
        System.out.println("");
        System.out.println(" -------------------");
        System.out.println("| Datos del equipo |");
        System.out.println(" -------------------");
        System.out.println("");
        System.out.println(" Modelo : "+modelo);
        System.out.println(" Numero telefonico: "+numeroTelefonico);
        System.out.println(" Codigo unico del movil: "+codigoTelefono);
        System.out.println(" Compañía: "+compani);
    }
}

