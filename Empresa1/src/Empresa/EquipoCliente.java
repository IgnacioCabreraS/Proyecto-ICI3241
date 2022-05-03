/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

public class EquipoCliente
{   
    private String modelo;
    private int numeroTelefonico;
    private int codigoTelefono;
    
    public EquipoCliente( String modelo,  int numeroTelefonico, int codigoTelefono) {
        this.modelo = modelo;
        this.numeroTelefonico = numeroTelefonico;
        this.codigoTelefono = codigoTelefono;
    }

    public int getCodigoTelefono() {
        return codigoTelefono;
    }

    public void setCodigoTelefono(int codigoTelefono) {
        this.codigoTelefono = codigoTelefono;
    }
    
    
    public int getNumeroTelefonico() {
        return numeroTelefonico;
    }
    
    public void setNumeroTelefonico( int numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo( String modelo) {
        this.modelo = modelo;
    }
}

