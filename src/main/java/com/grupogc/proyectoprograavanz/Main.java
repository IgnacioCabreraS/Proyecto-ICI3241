
package com.grupogc.proyectoprograavanz;

import java.io.*;
//import java.util.List;
//import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) throws IOException{
        
        Servicios datosS = new Servicios("Movistar",1,"Marzo");
        Equipo datosE = new Equipo("Samsung S9 PLUS", 2002, 590000);
        Clientes datosC = new Clientes("Rodolfo Ruz",209467002, 27382);
        
        System.out.print("Datos cliente: ");
        System.out.println("|| Nombre cliente: "+datosC.getNombre()+"|| Rut: "+datosC.getRut()+"|| Número telefónico: "+datosC.getNumeroTelefonico()+" ||");
        System.out.print("Datos servicio: ");
        System.out.println("|| Servicio: "+datosS.getPlan()+"|| Dia vencimiento:"+datosS.getDiaV()+"|| Mes vencimiento:"+datosS.getMesV()+" ||");
        System.out.print("Datos móvil: ");
        System.out.println("|| Modelo celular: "+datosE.getModelo()+"|| Año de lanzamiento: "+datosE.getAño()+"|| Precio: "+datosE.getPrecio()+" ||");

    }
}

