
package proyectogestion;


public class GestionCompañias implements describible{
    
    private String codComp;
    private ColeccionArrayListComp coleccion;

    // ------------------------ CONSTRUCTOR ------------------------------------ 
   

    GestionCompañias() {
        this.coleccion = new ColeccionArrayListComp();
    }
    

    // ------------------------- PROCESOS --------------------------------------
    
    public void agregarElemento(Compañia valor){
        coleccion.agregarElemento(valor);
    }
    
    public void agregarElemento(Equipos e, String tipoComp){
        coleccion.agregarElemento(e,tipoComp);
    }
    
    public void agregarElemento(Cliente valor, String tipoComp){
        coleccion.agregarElemento(valor, tipoComp);
    }
    
    public void agregarElemento(EquipoCliente eq, String key, String tipoComp){
        coleccion.agregarElemento(eq, key, tipoComp);
    }
    
    public int encontrarCompañia(String tipoComp){
        return coleccion.encontrarCompañia(tipoComp);
    }
    
    public Compañia retornarCompañia(String tipoComp){
        return coleccion.obtenerComp(tipoComp);
    }
    
    public Equipos retornarEquipo(String tipoComp, int numProdocuto){
        return coleccion.obtenerE(tipoComp,numProdocuto);
    }
    
    public Cliente retornarCliente(String tipoComp, String key){
        return coleccion.obtenerCliente(tipoComp, key);
    }
    
    public EquipoCliente retornarEquipoAsos(String tipoComp, String key, String cod){
        return coleccion.obtenerEquipoAsos(tipoComp,key,cod);
    }
    
    // eliminado de Clases
    
    public Compañia eliminarComp(String tipoComp){
        Compañia valor = coleccion.eliminarCompañia(tipoComp);        
        return valor;
        
    }
    
    public Cliente eliminarCliente(String tipoComp, String key){
        return coleccion.eliminarCliente(tipoComp, key);
    }
    
    public EquipoCliente eliminarEquipoAsos(String tipoComp, String key, String cod){
        return coleccion.eliminarEquipoAsos(tipoComp, key,cod);
    }
    
    
    public void mostrarElementos(){
        coleccion.mostrarElementos();
    }
    
    public void exportarTXT(Compañia c){
        coleccion.ExportarTXT(c);
    }

    public String getNombreComp() {
        return codComp;
    }

    public void setNombreComp(String codComp) {
        this.codComp = codComp;
    }
    
    @Override
    public void descripcion() {
        System.out.println("Codigo de compañía: "+codComp);
    }

    

    
}
