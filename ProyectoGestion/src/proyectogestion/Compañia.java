
package proyectogestion;

import java.io.PrintWriter;
import java.util.*;

public class Compañia implements describible {
    
    private String tipoCompañia;
    private ColeccionMapCliente coleccion;
    private ColeccionArrayListEquipos listE;

    // ------------------------ CONSTRUCTOR ------------------------------------ 
    
    public Compañia(String valor) {
        this.tipoCompañia = valor;
        this.coleccion = new ColeccionMapCliente();
        this.listE = new ColeccionArrayListEquipos();
    }
    
    public Compañia(){}
    
    //////////////////////////AGREGAR ELEMENTOS////////////////////////////////
    public void agregarElemento(Cliente c){
        coleccion.agregarElemento(c);
    }
    public void agregarElemento(Equipos e){
        listE.agregarElemento(e);
    }
    public void agregarElemento(EquipoCliente eq, String key){
        coleccion.agregarElemento(eq,key);
    }
    ///////////////////////////RETORNAR ELEMENTOS///////////////////////////////
    public Cliente retornarCliente(String rut){
        return coleccion.obtenerCliente(rut);
    }
   
    public Equipos retornarE(int numProducto){
        return listE.obtenerE(numProducto);
    }
    public EquipoCliente retornarEquipoAsos(String key, String cod){
        return coleccion.obtenerEquipoAsos(key,cod);
    }
    ///////////////////////CONTIENE/EXISTE ELEMENTO/////////////////////////////
    public boolean contieneElemento(String key){
        return coleccion.contieneElemento(key);
    }
    public boolean existeE(int numProducto, String compani){
        return listE.existeE(numProducto, tipoCompañia);
    }
    ///////////////////////////ELIMINAR ELEMENTOS///////////////////////////////
    public EquipoCliente eliminarEquipoAsos(String rut, String cod){
        
        return coleccion.eliminarEquipoAsos(rut, cod);
    }
    public Cliente eliminarCliente(String valor){
        
        return coleccion.eliminarCliente(valor);
    }
    public Equipos eliminarEquipo(int numProducto){
        return listE.eliminarEquipo(numProducto);
    }
    ///////////////////////////MOSTRAR ELEMENTOS////////////////////////////////
    public void mostrarElementos(){
        coleccion.mostrarClientes();
    }
    public void mostrarElementosE(){
        listE.mostrarElementosE();
    }
    /////////////////////////CANTIDAD DE ELEMENTOS//////////////////////////////
    public int numElementos(){
        return this.coleccion.numElementos();
    }
    public int numElementosE(){
        return this.listE.numElementosE();
    }
    ///////////////////////////SETTERS & GETTERS////////////////////////////////
    public String getTipoCompañia() {
        return tipoCompañia;
    }
    public void setTipoCompañia(String tipoCompañia) {
        this.tipoCompañia = tipoCompañia;
    }
    //////////////////////////APLICAR INTERFAZ//////////////////////////////////
    @Override
    public void descripcion() {
        System.out.println("");
        System.out.println(" -------------------");
        System.out.println("|  Datos compañía   |");
        System.out.println(" -------------------");
        System.out.println("");
        System.out.println(" Nombre compañía: "+tipoCompañia);
        System.out.println("");
    }
    
        
    //////////////////////////////EXTRAS////////////////////////////////////////
    
    public ArrayList<Equipos> busquedaRango(int[] rangoPrecio, GestionCompañias g, String comp){
        return listE.buscarPorPrecio(rangoPrecio,g,comp);
    }
    
    public void mostrarListaBCP(ArrayList<Equipos> list){
        listE.mostrarListaBCP(list);
    }
    
    public int buscarEconomic(GestionCompañias g, String comp){
        return listE.buscarEquipoEconomico(g,comp);
    }
    
    public void mostrarEconomico(int pos){
        listE.mostrarEconomico(pos);
    }
    
    public Compañia createCompañia(String data) {
        String[] camposC = new String[1];
        camposC = data.split(",");
        Compañia c = new Compañia(camposC[0]);
        return c;
    }
    
    public void exportarTXTClientes(){
        
    }
    public void exportarTXTCelulares(PrintWriter wr, String comp){
        listE.ExportarTXT(wr, comp);
    }
  
    // MOVER A OTRA CLASE
    
    public PlanesCliente createPlanC (String data) {
        String[] camposSc = new String[8];
        camposSc = data.split(",");
        PlanesCliente planesC = new PlanesCliente(camposSc[0], camposSc[1], camposSc[2], Integer.parseInt(camposSc[3]), Integer.parseInt(camposSc[4]), Integer.parseInt(camposSc[5]),Integer.parseInt(camposSc[6]), Integer.parseInt(camposSc[7]));
        return planesC;
    }

}
