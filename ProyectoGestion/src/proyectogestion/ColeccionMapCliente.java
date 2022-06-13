/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectogestion;

import java.util.*;
/**
 *
 * @author benja
 */

public class ColeccionMapCliente {
    
    private Map<String, Cliente> mapaClientes;
    
    ColeccionMapCliente(){
        mapaClientes = new HashMap<>();
    }

    public void agregarElemento(Cliente valor){
        mapaClientes.put(valor.getRut(), valor);
    }
    
    public void agregarElemento(Cliente valor, String key){
        mapaClientes.put(key, valor);
    }
    public void agregarElemento(EquipoCliente eq, String rut){
        if(mapaClientes.containsKey(rut)){
            mapaClientes.get(rut).agregarElemento(eq);
        }
    }
    public Cliente obtenerCliente(String rut){
        return mapaClientes.get(rut);
    }
    public EquipoCliente obtenerEquipoAsos(String rut , String cod){
        if(mapaClientes.containsKey(rut)){
            return mapaClientes.get(rut).retornarEquipoAsos(cod);
        }
        return null;
    }
    
    public Cliente eliminarCliente(String rut){
        if(mapaClientes.containsKey(rut)){
            System.out.println("Borrado Correcto");
        }
        return mapaClientes.remove(rut);
    }
    
    public EquipoCliente eliminarEquipoAsos(String rut, String cod){
        return mapaClientes.get(rut).eliminarEquipoAsos(cod);
    }
    
    public boolean contieneElemento(String valor){
        if(mapaClientes.containsKey(valor)){
            System.out.println("Valor encontrado");
            return true;
        }
        return false;
    }
    
    public void mostrarClientes(){
        
        Iterator it = mapaClientes.entrySet().iterator();
        
        while(it.hasNext()){
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
    /*
    public void exportarTXT(){
        
        while(mapaClientes != null){
            
        }
    }
    */
    
    public int numElementos(){
        return this.mapaClientes.size();
    }
}
