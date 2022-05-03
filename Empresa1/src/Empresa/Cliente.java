/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;


import java.util.*;

public class Cliente
{
    private String nombre;
    private String direccion;
    private int rut;
    private ArrayList<EquipoCliente> equipoAsos;
    private ArrayList<ServicioCliente> listServicios;
    
    public Cliente() {
    }
    
    public Cliente( String nombre,  String direccion,  int rut) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
        equipoAsos = new ArrayList<>();
        listServicios = new ArrayList<>();
    }
    
    public void agregarServicioCliente(ServicioCliente sC) {
        this.listServicios.add(sC);
    }
    
    public void agregarEquipoCliente(EquipoCliente E) {
        this.equipoAsos.add(E);
    }
    
    public void setNombre( String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setRut( int rut) {
        this.rut = rut;
    }
    
    public int getRut() {
        return rut;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion( String direccion) {
        this.direccion = direccion;
    }
    
    // getters creados para manipular de las listas en otras clases.
    
    public ArrayList<EquipoCliente> getEquipoAsos() {
        return equipoAsos;
    }

    public ArrayList<ServicioCliente> getListServicios() {
        return listServicios;
    }
   
}
