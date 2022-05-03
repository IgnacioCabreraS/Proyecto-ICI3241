/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Menu
{
    private BufferedReader lector;
    private String eleccion;
    private Empresa empresa;
    public Menu() {
        lector = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void mostrarMenu() {
        System.out.println("\nOpciones");
        System.out.println("[1] Agregar cliente");// listo
        System.out.println("[2] Agregar equipo a cliente");
        System.out.println("[3] Agregar servicio a equipo");
        System.out.println("[4] Eliminar cliente"); // listo
        System.out.println("[5] Eliminar equipo a cliente");
        System.out.println("[6] Eliminar servicio a equipo");
        System.out.println("[7] Buscar cliente"); // listo
        System.out.println("[8] Buscar equipo"); // listo
        System.out.println("[9] Buscar servicio"); // listo
        System.out.println("[10] Mostrar clientes"); // listo
        System.out.println("[11] Mostrar Equipos"); // listo
        System.out.println("[12] Mostrar Servicios"); // listo
        System.out.println("[13] Modificar datos cliente"); // listo
        
        /*  estos ultimos son para que el administrador disminuya o aumente 
            el precio de los equipos y/o servicios
        */
        System.out.println("[14] Modificar datos equipo"); // errores.
        System.out.println("[15] Modificar datos servicio"); // errores.
        System.out.println("");
    }
    
    public void menuGeneral() throws IOException {
        mostrarMenu();
        eleccion = lector.readLine();
        eleccionMenu(eleccion);
    }
    
    
    public void eleccionMenu(String eleccion) throws IOException{
        
        boolean bucle = true;
        
        BufferedReader lec = new BufferedReader(new InputStreamReader(System.in));
        
        do{
            switch(eleccion){
                
                case "1":
                    System.out.println("Ingrese datos del cliente separados por coma, los datos son: ");
                    System.out.println("[1] Nombre y apellido (separados por un espacio");
                    System.out.println("[2] Rut (sin puntos y sin guion)");
                    System.out.println("[3] Direccion");
                    
                    String datos = lec.readLine();
                    empresa.ingresoPorConsola(datos);
                    break;
                case "2":
                    System.out.println("Sin completar");
                    break;
                case "3":
                    System.out.println("Sin completar");
                    break;
                case "4":
                    empresa.eliminarCliente(solicitarRut());
                    break;
                case "5":
                    //con errores
                    System.out.println("[1] Ingrese el codigo del dispositivo");
                    String cod = lec.readLine();
                    empresa.eliminarEquipoCliente(solicitarRut(),Integer.valueOf(cod));
                    break;
                case "6":
                    //con errores
                    System.out.println("[1] Ingrese el codigo del dispositivo");
                    String service = lec.readLine();
                    empresa.eliminarServicioCliente(solicitarRut(),Integer.valueOf(service));
                    break;
                    
                case "7":
                    empresa.buscarCliente(solicitarRut());
                    break;
                case "8":
                    System.out.println("[1] Ingrese nombre del equipo a buscar");
                    String equip = lec.readLine();
                    empresa.buscarEquipos(equip);
                    break;
                case "9":
                    System.out.println("[1] Ingrese nombre del Servicio a buscar");
                    // llamar a un menu que contenga los servicios del programa
                    String Serv = lec.readLine();
                    empresa.buscarServicio(Integer.valueOf(Serv));
                    break;
                case "10":
                    empresa.printClients();
                    break;
                case "11":
                    empresa.printEquipos();
                    break;
                case "12":
                    empresa.printServicios();
                    break;
                case "13":
                    empresa.modificarC(solicitarRut());
                    break;
                case "14":
                    System.out.println("Sin completar");
                    break;
                case "15":
                    System.out.println("Sin completar");
                    break;
                default: System.out.println("Ingrese una opcion valida");
                
            }
        }while(bucle);
                
    }
    
    public int solicitarRut()throws IOException{
        System.out.println("Ingrese el rut del cliente");
        BufferedReader lec = new BufferedReader(new InputStreamReader(System.in));
        String rutcito = lec.readLine();
        return Integer.valueOf(rutcito); 
    }
}
