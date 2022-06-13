package proyectogestion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
/**
 *
 * @author benja
 */

public class ColeccionArrayListComp{
    
     private ArrayList<Compañia> listCompañias;
    
    ColeccionArrayListComp(){
        listCompañias = new ArrayList<>();
    }
    
    public void agregarElemento (Compañia valor){
        listCompañias.add(valor);
    }
    
    public void agregarElemento (Equipos e, String tipoComp){
        for(int i=0; i < listCompañias.size();i++){
            if(tipoComp.equals(listCompañias.get(i).getTipoCompañia())){
                listCompañias.get(i).agregarElemento(e);
                break;
            }
        }
    }
    
    public void agregarElemento(Cliente client, String tipoComp){
        for(int i=0; i < listCompañias.size();i++){
            if(tipoComp.equals(listCompañias.get(i).getTipoCompañia())){
                listCompañias.get(i).agregarElemento(client);
                break;
            }
        }
    }
    
    public void agregarElemento(EquipoCliente eq, String key, String tipoComp){
        for(int i=0; i < listCompañias.size();i++){
            if(tipoComp.equals(listCompañias.get(i).getTipoCompañia())){
                listCompañias.get(i).agregarElemento(eq,key);
                break;
            }
        }
    }
    
    public Compañia obtenerComp(String tipoComp){
        
        for(int i=0; i < listCompañias.size();i++){
            
            if(tipoComp.equals(listCompañias.get(i).getTipoCompañia())){
                return listCompañias.get(i);
            }
        }
        return null;
    }
    
    
    
    public Cliente obtenerCliente(String tipoComp, String rut){
        
        for(int i=0; i < listCompañias.size();i++){
            if(tipoComp.equals(listCompañias.get(i).getTipoCompañia())){
                return listCompañias.get(i).retornarCliente(rut);
            }
        }
        return null;
    }
    
    public Equipos obtenerE(String tipoComp, int numProducto){
        
        for(int i=0; i < listCompañias.size();i++){
            if(tipoComp.equals(listCompañias.get(i).getTipoCompañia())){
                return listCompañias.get(i).retornarE(numProducto);
            }
        }
        return null;
    }
    
    public EquipoCliente obtenerEquipoAsos(String tipoComp, String key, String cod){
        
        for(int i=0; i < listCompañias.size();i++){
            if(tipoComp.equals(listCompañias.get(i).getTipoCompañia())){
                System.out.println("INGRESA");
                return listCompañias.get(i).retornarEquipoAsos(key, cod);
            }
        }
        return null;
    }
    // metodos que eliminan clases
    
    
    
    public int encontrarCompañia(String tipoComp){
        int cont =0;
        for(int i=0; i < listCompañias.size();i++){
            if(tipoComp.equals(listCompañias.get(i).getTipoCompañia())){   
                cont++;
            }
        }
        return cont;
    }
    
    public Compañia eliminarCompañia(String tipoComp){
        
        for(int i=0; i < listCompañias.size();i++){
            if(tipoComp.equals(listCompañias.get(i).getTipoCompañia())){                
                Compañia clase = listCompañias.get(i);
                listCompañias.remove(i);
                return clase;
            }
        }
        return null;
    }
    
    public Cliente eliminarCliente(String tipoComp, String key){
        
        for(int i=0; i < listCompañias.size();i++){
            
            if(tipoComp.equals(listCompañias.get(i).getTipoCompañia())){
                return listCompañias.get(i).eliminarCliente(key);
            }
        }
        return null;
    }
    
    public EquipoCliente eliminarEquipoAsos(String tipoComp, String key, String cod){
        
        for(int i=0; i < listCompañias.size();i++){
            if(tipoComp.equals(listCompañias.get(i).getTipoCompañia())){
                return listCompañias.get(i).eliminarEquipoAsos(key, cod);
            }
        }
        return null;
    }
    
    
    public void mostrarElementos(){
        
        for(int i=0; i < listCompañias.size();i++){
            System.out.println("Elementos: "+listCompañias.get(i).getTipoCompañia());
        }
    }
    
    
    public int numElementos(){
        return this.listCompañias.size();
    }
    
    public void ExportarTXT(Compañia c){
        
        File archivo;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter wr;
        
        try{
            archivo = new File (".//txt//archivoTest.txt");
            fw = new FileWriter (archivo);
            bw = new BufferedWriter (fw);
            wr = new PrintWriter (bw);
            
            wr.write("Lista de compañías: \n");
            wr.append("\n");
            
            for(int i = 0; i < numElementos(); i++){
                wr.append("("+(i+1)+") Nombre de compañía: "+listCompañias.get(i).getTipoCompañia());
                wr.append("\n");
                wr.append("\n");
                wr.write("Lista de equipos telefonicos: \n");
                wr.append("\n");
                
                c.exportarTXTCelulares(wr,listCompañias.get(i).getTipoCompañia());
            }
            
            wr.close();
            bw.close();
            
        }catch(Exception e){
            System.out.println("Ups.. Ocurrio un error");
        }
        
    }
}