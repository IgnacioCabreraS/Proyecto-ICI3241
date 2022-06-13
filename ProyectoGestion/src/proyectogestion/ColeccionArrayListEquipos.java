package proyectogestion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
class ColeccionArrayListEquipos {
    
    private ArrayList<Equipos> listE;
    
    ColeccionArrayListEquipos(){
        listE = new ArrayList<>();
    }
    
    public void agregarElemento (Equipos e){
        listE.add(e);
    }
    
    public Equipos eliminarEquipo(int numProducto){
        
        for(int i=0; i < numElementosE();i++){
            if(numProducto == listE.get(i).getNumeroProducto()){                
                Equipos e = listE.get(i);
                listE.remove(i);
                return e;
            }
        }
        return null;
    }
     
    public Equipos obtenerE(int numProducto){
        
        for(int i=0; i < numElementosE();i++){

            if(numProducto == listE.get(i).getNumeroProducto()){
                return listE.get(i);
            }
        }
        return null;
    }
    
     public boolean existeE(int numProducto, String compani){
        
        for(int i=0; i < numElementosE();i++){
            
            if(compani.equals(listE.get(i).getCompani())){
                if(numProducto == listE.get(i).getNumeroProducto()){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void mostrarElementosE(){
        for(int i=0; i < numElementosE();i++){
            System.out.println("");
            System.out.println("INFORMACION SOBRE EL DISPOSITVO");
            System.out.println("");
            System.out.println(" Modelo del celular: "+listE.get(i).getModeloEquipo());
            System.out.println(" Marca del celular: "+listE.get(i).getMarca());
            System.out.println(" Capacidad de bateria: "+listE.get(i).getCapacBat());
            System.out.println(" Numero del producto: "+listE.get(i).getNumeroProducto());
            System.out.println(" Precio: $"+listE.get(i).getPrecio());
            System.out.println("");
        }
    }
    
    public int numElementosE(){
       return listE.size();
    }
    
    
    // metodo para filtrar elementos que se encuentren en un rango de precio
    // se creara un arreglo int y se solicitara dos rangos para encapsular 
    // los elementos que se encuentren en ese rango
    // deberemos crear un arrayList aux en el menu para poder guardar este array
    
    // traspasar gc y verificar si existe comp, ademas hay que pasar la comp solicitada
    
    public ArrayList <Equipos> buscarPorPrecio(int[] rangoPrecio, GestionCompañias g, String comp){ // buscarPorPrecio = BCP
        
        ArrayList <Equipos> list = new ArrayList<>();
        boolean error = false;
        
        for(int i = 0; i < numElementosE(); i++){
            if((g.encontrarCompañia(comp) == 1 && (listE.get(i).getCompani().equals(comp)))){
                if((listE.get(i).getPrecio()) >= rangoPrecio[0] && (listE.get(i).getPrecio()) <= rangoPrecio[1]){
                    error = false;
                    list.add(listE.get(i));   
                }else error = true;
            }else error = true;
        }
        if(error == true){
            System.out.println("");
            System.out.println("Fallo por uno de estos errores: 1.- No existe la compañía deseada en la base de datos");
            System.out.println("                                2.- No existe equipo movil con esa compañía asociada");
            System.out.println("                                3.- No existe equipos dentro del rango establecido");
            System.out.println("");
        }else{
            System.out.println("");
            System.out.println("Filtro aplicado de manera exitosa");
        }
        return list;
    }
    
    public void mostrarListaBCP(ArrayList<Equipos> list){
        
        for(int i = 0; i < list.size(); i++){
            System.out.println("");
            System.out.println("INFORMACION SOBRE EL DISPOSITVO N°"+i);
            System.out.println("");
            System.out.println(" Modelo del celular: "+listE.get(i).getModeloEquipo());
            System.out.println(" Marca del celular: "+listE.get(i).getMarca());
            System.out.println(" Capacidad de bateria: "+listE.get(i).getCapacBat());
            System.out.println(" Numero del producto: "+listE.get(i).getNumeroProducto());
            System.out.println(" Precio: $"+listE.get(i).getPrecio());
            System.out.println("");
        }
    }
    
    // metodo para seleccionar el dispositivo mas baraton que hay en la lista
    // con este valor encontramos la posicion en la que se encuentra y despues
    // en el menu imprimimos este.
    
    // traspasar gc y verificar si existe comp, ademas hay que pasar la comp solicitada
    
    public int buscarEquipoEconomico(GestionCompañias g, String comp){
        int minimo = 0;
        int auxiliar = listE.get(0).getPrecio(); // guardamos el primer elemento
        boolean error = false;
        
        for(int i = 0; i < numElementosE(); i++){
            
            if((g.encontrarCompañia(comp) == 1 && (listE.get(i).getCompani().equals(comp)))){
                error = false;
                if(listE.get(i).getPrecio() < auxiliar){
                    auxiliar = listE.get(i).getPrecio();
                    minimo = i;
                    
                } 
            }else error = true;
        }
        
         if(error == true){
            System.out.println("");
            System.out.println("Fallo por uno de estos errores: 1.- No existe la compañía deseada en la base de datos");
            System.out.println("                                2.- No existe equipo movil con esa compañía asociada");
            System.out.println("");
        }else{
             System.out.println("");
             System.out.println("Realizado de manera exitosa");
             System.out.println("");
         }
        
        return minimo;
    }
    
    public void mostrarEconomico(int pos){
        System.out.println("");
        System.out.println("INFORMACION SOBRE EL DISPOSITVO");
        System.out.println("");
        System.out.println(" Modelo del celular: "+listE.get(pos).getModeloEquipo());
        System.out.println(" Marca del celular: "+listE.get(pos).getMarca());
        System.out.println(" Capacidad de bateria: "+listE.get(pos).getCapacBat());
        System.out.println(" Numero del producto: "+listE.get(pos).getNumeroProducto());
        System.out.println(" Precio: $"+listE.get(pos).getPrecio());
        System.out.println("");
    }
    
     public PrintWriter ExportarTXT(PrintWriter wr, String comp){
        
        
        for(int i = 0; i < numElementosE(); i++){
            if(comp.equals(listE.get(i).getCompani())){
                wr.append("| ("+(i+1)+") Modelo del celular: "+listE.get(i).getModeloEquipo()+ "| Marca del celular: "+listE.get(i).getMarca()+ "| Capacidad de bateria: "+listE.get(i).getCapacBat()+ "| Numero del producto: "+listE.get(i).getNumeroProducto() + "| Precio: $"+listE.get(i).getPrecio()+"| Compañía del movil: "+listE.get(i).getCompani()+" |");
                wr.append("\n");
            }    
        }
        return wr;
    }
    
    /*
    public void ExportarTXT(){
        
        File archivo;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter wr;
        
        try{
            archivo = new File (".//txt//archivoConEquipos.txt");
            fw = new FileWriter (archivo);
            bw = new BufferedWriter (fw);
            wr = new PrintWriter (bw);
            
            wr.write("Lista de equipos: \n");
            wr.append("\n");
            
            for(int i = 0; i < numElementosE(); i++){
                wr.append("| ("+(i+1)+") Modelo del celular: "+listE.get(i).getModeloEquipo()+ "| Marca del celular: "+listE.get(i).getMarca()+ "| Capacidad de bateria: "+listE.get(i).getCapacBat()+ "| Numero del producto: "+listE.get(i).getNumeroProducto() + "| Precio: $"+listE.get(i).getPrecio()+"| Compañía del movil: $"+listE.get(i).getCompani()+" |");
                wr.append("\n");
                
            }
            
            wr.close();
            bw.close();
            
        }catch(Exception e){
            System.out.println("Ups.. Ocurrio un error");
        }
    }
    */
}
