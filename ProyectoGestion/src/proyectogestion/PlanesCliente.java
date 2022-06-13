package proyectogestion;

//import java.util.*;
/**
 * Representa el serivicio cliente con sus respectivos Setters y Getters.
 */
public class PlanesCliente
{
    
    private String tipoServicio;
    private String fechaVen;
    private String fechaPag;
    private int precioFactura;
    private int totalGb;
    private int totalMinutos;
    private int totalMensajes;
    private int rutCliente;
    //private ArrayList<Servicios> serviciosDeseados;
    
    public PlanesCliente(){
        
    }
    public PlanesCliente(String tipoServicio, String fechaVen, String fechaPag, int precioFactura, int totalGb, int totalMinutos, int totalMensajes, int rutCliente) {
        this.tipoServicio = tipoServicio;
        this.fechaVen = fechaVen;
        this.fechaPag = fechaPag;
        this.precioFactura = precioFactura;
        this.totalGb = totalGb;
        this.totalMinutos = totalMinutos;
        this.totalMensajes = totalMensajes;
        this.rutCliente = rutCliente;
        //serviciosDeseados = new ArrayList<>();
    }
    

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
    }
    
    
    public String getTipoServicio() {
        return tipoServicio;
    }
    
    public void setTipoServicio( String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    
    public int getTotalMensajes() {
        return this.totalMensajes;
    }
    
    public void setTotalMensajes( int totalMensajes) {
        this.totalMensajes = totalMensajes;
    }
    
    public int getTotalMinutos() {
        return totalMinutos;
    }
    
    public void setTotalMinutos( int totalMinutos) {
        this.totalMinutos = totalMinutos;
    }
    
    public int getTotalGb() {
        return totalGb;
    }
    
    public void setTotalGb(int totalGb) {
        this.totalGb = totalGb;
    }
    
    public int getPrecioFactura() {
        return precioFactura;
    }
    
    public void setPrecioFactura(int precioFactura) {
        this.precioFactura = precioFactura;
    }
    
    public String getFechaPag() {
        return fechaPag;
    }
    
    public void setFechaPag(String fechaPag) {
        this.fechaPag = fechaPag;
    }
    
    public String getFechaVen() {
        return fechaVen;
    }
    
    public void setFechaVen(String fechaVen) {
        this.fechaVen = fechaVen;
    }
    
    //-------------------SOBRE CARGA DE METODOS---------------------------------
    
     public void revisarFecha( String fechaVen,  String fechaPag) {
        System.out.println("Servicio pagado en: " + fechaPag + ". Servicio vence en: " + fechaVen);
    }
    
    public void revisarFecha( String fechaVen,  int precioFactura) {
        System.out.println("El servicio caduco en: " + fechaVen + ". El pago para renovar es de: $" + precioFactura);
    }
    
    //--------------------------METODO COLECCION--------------------------------
    
    /*
    public ArrayList<Servicios> getServiciosDeseados() {
        return serviciosDeseados;
    }
    */
    
}
