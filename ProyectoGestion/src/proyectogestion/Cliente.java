/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectogestion;


public class Cliente implements describible{
    
    private String nombre;
    private String rut;
    private String direccion;
    private String compania;
    private ColeccionEquipoAsos mapaEquiposAsos;
    //private ColeccionPlanesAsos mapPlanessAsos;
    
    public Cliente(){
        
    }
    public Cliente( String nombre, String rut, String direccion, String compania) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
        this.compania = compania;
        mapaEquiposAsos = new ColeccionEquipoAsos();
        //private ColeccionPlanesAsos mapPlanessAsos;
    }
    
    public EquipoCliente retornarEquipoAsos(String cod){
        return mapaEquiposAsos.obtenerEquipoAsos(cod);
    }
    
    public EquipoCliente eliminarEquipoAsos(String cod){
        return mapaEquiposAsos.eliminarEquipoAsos(cod);
    }
    
    public int numElementos(){
        return this.mapaEquiposAsos.numElementos();
    }
    
    public void agregarElemento(EquipoCliente eq){
        mapaEquiposAsos.agregarElemento(eq);
    }
    
    public boolean contieneElemento(String cod){
        return mapaEquiposAsos.contieneElemento(cod);
    }
  
    public void setNombre( String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
   
    public void setRut( String rut) {
        this.rut = rut;
    }
   
    public String getRut() {
        return rut;
    }

    public String getDireccion() {
        return direccion;
    }
   
    public void setDireccion( String direccion) {
        this.direccion = direccion;
    }
    
   
    public String getCompania() {
        return compania;
    }
    
    
    public void setCompania(String compania) {
        this.compania = compania;
    }
    
    public Cliente createCliente(String data) {
        String[] camposC = new String[4];
        camposC = data.split(",");
        Cliente client = new Cliente(camposC[0],camposC[1], camposC[2], camposC[3]);
        return client;
    }
    
    @Override
    public void descripcion() {
        System.out.println(" -------------------");
        System.out.println("| Datos del cliente |");
        System.out.println(" -------------------");
        System.out.println("");
        System.out.println(" Nombre : "+nombre);
        System.out.println(" Rut: "+rut);
        System.out.println(" Direccion/Domicilio: "+direccion);
        System.out.println(" Compañía asociada: "+compania);
        System.out.println("");
    }
    
}
