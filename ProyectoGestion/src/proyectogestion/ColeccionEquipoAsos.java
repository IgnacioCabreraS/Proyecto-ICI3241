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
public class ColeccionEquipoAsos {
    
    private Map<String,EquipoCliente> mapEq;
    
    ColeccionEquipoAsos(){
        mapEq = new HashMap<>();
    }
    
    public void agregarElemento(EquipoCliente eq){
        mapEq.put(eq.getCodigoTelefono(), eq);
    }
    
    public void agregarElemento(EquipoCliente eq, String key){
        mapEq.put(key, eq);
    }
    
    public EquipoCliente obtenerEquipoAsos(String valor){
        return mapEq.get(valor);
    }
    
    public EquipoCliente eliminarEquipoAsos(String valor){
        if(mapEq.containsKey(valor)){
            System.out.println("Borrado Correcto E");
        }
        return mapEq.remove(valor);
    }
    
    // este metodo lo utilizare para comprobar la cantidad de equipos que tiene
    // el cliente en su posecion
    public int numElementos(){
        return this.mapEq.size();
    }
    public boolean contieneElemento(String cod){
        if(mapEq.containsKey(cod)){
            System.out.println("Elemento encontrado");
            return true;
        }
        return false;
    }
}
