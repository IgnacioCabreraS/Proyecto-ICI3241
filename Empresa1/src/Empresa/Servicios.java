/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;


public class Servicios {
    
    private int tipoServicio;
    private int totalGb;
    private int totalMensajes;
    private int totalMinutosLlamada;
    private int precioServicio;

    public Servicios(int tipoServicio, int totalGb, int totalMensajes, int totalMinutosLlamada, int precioServicio) {
        this.tipoServicio = tipoServicio;
        this.totalGb = totalGb;
        this.totalMensajes = totalMensajes;
        this.totalMinutosLlamada = totalMinutosLlamada;
        this.precioServicio = precioServicio;
    }
    
    public Servicios(){}

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getTotalGb() {
        return totalGb;
    }

    public void setTotalGb(int totalGb) {
        this.totalGb = totalGb;
    }

    public int getTotalMensajes() {
        return totalMensajes;
    }

    public void setTotalMensajes(int totalMensajes) {
        this.totalMensajes = totalMensajes;
    }

    public int getTotalMinutosLlamada() {
        return totalMinutosLlamada;
    }

    public void setTotalMinutosLlamada(int totalMinutosLlamada) {
        this.totalMinutosLlamada = totalMinutosLlamada;
    }

    public int getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(int precioServicio) {
        this.precioServicio = precioServicio;
    }
    
}
