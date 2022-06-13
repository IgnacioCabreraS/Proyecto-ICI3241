/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectogestion;
import java.util.*;
import java.io.*;
public class Menu {
                                                     
    private String eleccion;
    private String codCel;
    private String rut;
    private String comp;
    private String codComp;
    private boolean continuar = true;
    private BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));; 
    
    //////////////////////////// CONSTRUCTOR ///////////////////////////////////
    
    public Menu(){
        
    }
    
    //////////////////////////// PROCESOS DEL MENU /////////////////////////////
    
    public void menuPrincipal(String opcion, GestionCompañias g, Compañia c, Cliente cl, EquipoCliente eq)throws IOException{
        
        do{
            if(continuar == false) break;
            switch(opcion){
                case "0":
                    continuar = false;
                    break;
                case "1":
                    menuAgregar(g,c,cl,eq);
                    continuar = true;
                    break;
                case "2":
                    menuMostrar(g,c,cl,eq);
                    continuar = true;
                    break;
                case "3":
                    menuBuscar(g,c,cl,eq);
                    continuar = true;
                    break;
                case "4":
                    menuModificar(g,c,cl,eq);
                    continuar = true;
                    break;
                case "5":
                    menuEliminar(g,c,cl,eq);
                    continuar = true;
                    break;
                case "6":
                    menuExtra(g,c);
                    continuar = true;
                    break;
            }
                    
        }while(continuar);
    }
    
    public void menuAgregar(GestionCompañias g, Compañia c, Cliente cl, EquipoCliente eq)throws IOException{
        
        
        desplegarMenuAgregar();
        eleccion = lector.readLine();
             
        switch(eleccion){
                
            case "0":
                break;
            case "1":

                comp = solicitarCompañia();
                
                // comprobar si la compa existe 
                
                if(g.encontrarCompañia(comp) == 1){
                    
                    rut = solicitarRutCliente(); 
                    // comprobar si el rut existe, si existe se piden los datos, sino no  
                    if(!c.contieneElemento(rut)){
                        
                        String datosCliente = solicitarDatosCliente();
                    
                        Cliente cliente = cl.createCliente(datosCliente);
                        
                        g.agregarElemento(cliente, comp);
                        
                        Cliente aux = g.retornarCliente(cliente.getCompania(), cliente.getRut());
                        
                        aux.descripcion();
                        System.out.println("El cliente ha sido agregado exitosamente");
                        
                    }else System.out.println("Ya existe manito");
                    
                }else System.out.println("No existe manito");
                
                break;
            case "2":
                
                // comprobar si la compa existe 
                comp = solicitarCompañia();
                 
                if(g.encontrarCompañia(comp) == 1){
                    
                    System.out.println("Entra 1");
                    rut = solicitarRutCliente();
                    
                    // comprobar si el rut existe, si existe se piden los datos, sino no  
                    if(c.contieneElemento(rut)){
                        
                        System.out.println("Entra 2");
                        // verificar si el cliente posee mas de un celular con la misma clave
                        codCel = solicitarCodCelular();
                        if(cl.contieneElemento(codCel)){
                            System.out.println("Entra 3");
                         
                            int selec = preguntaIngresoConRep();
                            
                            if(selec == 1){
                                
                                casoDeRepeticion();
                                
                                // se solicitan los datos del equipo cliente
                                String datosEquipo = solicitarDatosEquipoCliente();
                                EquipoCliente equipo = eq.createEquipC(datosEquipo);
                                
                                g.agregarElemento(equipo, rut, equipo.getCodigoTelefono());
                                System.out.println("Valor agregado");
                                
                                /*dudas al mostrar*/
                                //EquipoCliente aux = g.retornarEquipoAsos(comp,rut,equipo.getCodigoTelefono());
                                
                                //aux.descripcion();
                             
                            }else break;
                            
                        }else{
                            String datosEquipo = solicitarDatosEquipoCliente();
                            EquipoCliente equipo = eq.createEquipC(datosEquipo);
                                
                            g.agregarElemento(equipo, rut, equipo.getCodigoTelefono());
                            System.out.println("Valor agregado");
                            //EquipoCliente aux = g.retornarEquipoAsos(comp,rut,equipo.getCodigoTelefono());
                                
                            //aux.descripcion();
                        }
                    }
                    
                }else System.out.println("No existe manito");
                
                break;
            case "3":
                    
                System.out.println("sin hacer");
            
                break;
                
            case "4": 

                comp = solicitarCompañia();
                if(g.encontrarCompañia(comp) == 0){
                    System.out.println("La empresa no existe");
                    Compañia ca = new Compañia(comp);
                    g.agregarElemento(ca);
                }
                
                g.mostrarElementos();
                
                break;
                
            default: System.out.println("Opcion invalida"); 
            }
    }
    
    // dudas sobre el mostrar
    public void menuMostrar(GestionCompañias g, Compañia c, Cliente cl, EquipoCliente eq)throws IOException{
        
        desplegarMenuMostrar();
        eleccion = solicitarOpcion();
         
         
        switch(eleccion){
                
            case "0":
                break;
                
            case "1":
                comp = solicitarCompañia();
                
                // comprobar si la compa existe 
                
                if(g.encontrarCompañia(comp) == 1){
                    // mostramos la compañía que pertenece
                    
                    Compañia auxComp = g.retornarCompañia(comp);
                    auxComp.descripcion();
                    
                    // solicitamos el rut del cliente
                    
                    rut = solicitarRutCliente(); 
                    
                    // comprobar si el rut existe, si existe se piden los datos, sino no  
                    if(c.contieneElemento(rut)){
                        
                        Cliente aux = g.retornarCliente(comp, rut);
                        aux.descripcion();
                        
                    }else System.out.println("Ya existe manito");
                    
                }else System.out.println("No existe manito");
                break;
                
            case "2":
                System.out.println("sin hacer");
                break;
                
            case "3":
                System.out.println("sin hacer");
                break;
                
            case "4":
                g.mostrarElementos();
                break;
            case "5":
                
                comp = solicitarCompañia();
                if(g.retornarCompañia(comp) != null){
                    rut = solicitarRutCliente();
                    if(g.retornarCliente(comp, rut) != null){
                        codCel = solicitarCodCelular();
                        if(g.retornarEquipoAsos(comp, rut, codCel) != null){
                            g.descripcion();
                            c.descripcion();
                            cl.descripcion();
                        }
                    }
                }
                break;
            default: System.out.println("Opcion invalida"); 
                break;
        }
    }
    
    public void menuModificar(GestionCompañias g, Compañia c, Cliente cl, EquipoCliente eq) throws IOException {
        desplegarMenuModificar();
        eleccion = solicitarOpcion();
        
        switch(eleccion) {
            
            case "1": //cliente
                comp = solicitarCompañia();
                if(g.encontrarCompañia(comp) == 1){
                    rut = solicitarRutCliente();
                    if(c.contieneElemento(rut)){
                        //eliminamos
                        g.eliminarCliente(comp, rut);
                        String datosCliente = solicitarDatosCliente();
                        Cliente cliente = cl.createCliente(datosCliente);
                        //agregamos nuevos datos
                        g.agregarElemento(cliente, comp);
                        
                        Cliente aux = g.retornarCliente(comp, cliente.getRut());
                        aux.descripcion();
                        
                        
                        
                    }else System.out.println("No existe el elemento ingresado");
                }else System.out.println("No existe el elemento ingresado");
                break;
                
            case "2": //equipo cliente
                System.out.println("sin hacer"); 
                break;
            case "3": //plan cliente
                System.out.println("sin hacer"); 
                break;
            case "4":
                comp = solicitarCompañia();
                if(g.encontrarCompañia(comp) == 1){
                    
                    g.eliminarComp(comp);
                    
                    String nuevaComp = solicitarCompañia();
                    
                    Compañia ca = new Compañia(nuevaComp);
                    
                    g.agregarElemento(ca);
                    //g.mostrarElementos();
                }else System.out.println("No existe el elemento ingresado");
                
                break;                
            default: System.out.println("Opcion invalida"); 
        }
    }
    
    public void menuBuscar(GestionCompañias g, Compañia c, Cliente cl, EquipoCliente eq) throws IOException {
        desplegarMenuModificar();
        eleccion = solicitarOpcion();
        
         switch(eleccion){
                
            case "0":
                break;
                
            case "1":
                comp = solicitarCompañia();
                
                // comprobar si la compa existe 
                
                if(g.encontrarCompañia(comp) == 1){
                    // mostramos la compañía que pertenece
                    
                    Compañia auxComp = g.retornarCompañia(comp);
                    auxComp.descripcion();
                    
                    // solicitamos el rut del cliente
                    
                    rut = solicitarRutCliente(); 
                    
                    // comprobar si el rut existe, si existe se piden los datos, sino no  
                    if(c.contieneElemento(rut)){
                        
                        Cliente aux = g.retornarCliente(comp, rut);
                        aux.descripcion();
                        
                    }else System.out.println("Ya existe manito");
                    
                }else System.out.println("No existe manito");
                break;
                
            case "2":
                System.out.println("sin hacer");
                break;
                
            case "3":
                System.out.println("sin hacer");
                break;
                
            case "4":
                g.mostrarElementos();
                break;
            case "5":
                
                comp = solicitarCompañia();
                if(g.retornarCompañia(comp) != null){
                    rut = solicitarRutCliente();
                    if(g.retornarCliente(comp, rut) != null){
                        codCel = solicitarCodCelular();
                        if(g.retornarEquipoAsos(comp, rut, codCel) != null){
                            g.descripcion();
                            c.descripcion();
                            cl.descripcion();
                        }
                    }
                }
                break;
            default: System.out.println("Opcion invalida"); 
                break;
        }
    }
    public void menuEliminar(GestionCompañias g, Compañia c, Cliente cl, EquipoCliente eq) throws IOException {
        desplegarMenuEliminar();
        eleccion = solicitarOpcion();
        
        switch(eleccion) {
            
            case "1": //cliente
                comp = solicitarCompañia();
                if(g.encontrarCompañia(comp) == 1){
                    rut = solicitarRutCliente();
                    if(c.contieneElemento(rut)){
                        g.eliminarCliente(comp, rut);
                        //c.eliminarCliente(rut);
                        System.out.println("El cliente ha sido eliminado de manera exitosa"); 
                        //g.mostrarElementos();
                    }System.out.println("No existe el elemento ingresado");
                }System.out.println("No existe el elemento ingresado");
                break;
            case "2": //equipo
                
                break;
            case "3": //plan
                
                break;
            case "4": //compa
                comp = solicitarCompañia();
                if(g.encontrarCompañia(comp) == 1){
                    g.eliminarComp(comp);
                    System.out.println("La compañía ha sido eliminado de manera exitosa"); 
                    //g.mostrarElementos();
                }else System.out.println("No existe el elemento ingresado"); 
                break;                
            default: System.out.println("Opcion invalida"); 
        }
    }
    
    public void menuExtra(GestionCompañias g,Compañia c) throws IOException{
        
        desplegarMenuExtra();
        eleccion = lector.readLine();
        
        switch(eleccion){
                case "0":
                    break;
                case "1":
                    int rangoPrecio [] = consultarRangoEquipo();
                    comp = solicitarCompañia();
                    ArrayList <Equipos> aux = c.busquedaRango(rangoPrecio,g,comp);
                    c.mostrarListaBCP(aux);
                    break;
                case "2":
                    comp = solicitarCompañia();
                    int pos = c.buscarEconomic(g,comp);
                    c.mostrarEconomico(pos);
                    break;
                default: System.out.println("Opcion invalida"); 
        }
    }
    //////////////////////////// SOLICITUD DE DATOS ////////////////////////////
    
    public String solicitarOpcion() throws IOException {
        System.out.println(" --------------------------------------");
        System.out.println("| Ingrese la opcion del menu que desea |");
        System.out.println(" --------------------------------------");   
        return lector.readLine(); 
    }
    
    public int preguntaIngresoConRep() throws IOException {
        System.out.println("El celular que desea ingresa ya se encuentra en su propiedad.");
        System.out.println("Desea continuar?.");
        System.out.println("");
        System.out.println("Seleeccione: 1) Si");
        System.out.println("             2) No");
        return Integer.parseInt(lector.readLine()); 
    }
    
    public String solicitarCodCelular() throws IOException {
        System.out.println(" -------------------------------------");
        System.out.println("| Ingrese el codigo unico del celular |");
        System.out.println(" -------------------------------------");        
        return lector.readLine();
    } 
    public String solicitarCompañia() throws IOException {
        System.out.println(" ----------------------------");
        System.out.println("| Ingrese la Compañia deseada |");
        System.out.println(" ----------------------------");        
        return lector.readLine();
    }
    
    public String solicitarCodigoComp() throws IOException {
        System.out.println(" ------------------------------------------- ");
        System.out.println("| Ingrese el codigo de la  Compañia deseada  |");
        System.out.println(" ------------------------------------------- ");        
        return lector.readLine();
    }
    
    public String solicitarRutCliente() throws IOException {
        System.out.println(" ----------------------------");
        System.out.println("| Ingrese el RUT del cliente |");
        System.out.println(" ----------------------------");        
        return lector.readLine();
    }
    
    public String solicitarDatosCliente() throws IOException {
        System.out.println("");
        System.out.println(" --------------------------------------------------");
        System.out.println("| Ingrese los datos del cliente separados por coma |");
        System.out.println(" --------------------------------------------------");
        System.out.println("* Nombre, RUT, dirección, compañía telefonica deseada");
        return lector.readLine();    
    }
    
    public String solicitarDatosEquipoCliente() throws IOException {
        System.out.println("");
        System.out.println(" -----------------------------------------------------------");
        System.out.println("| Ingrese las características del equipo separadas por coma |");
        System.out.println(" -----------------------------------------------------------");
        System.out.println("Modelo, Numero telefonico, Codigo unico, Rut, compañía asociada");
        return lector.readLine();
    }
    
    public int[] consultarRangoEquipo() throws IOException {
        int[] rangoPrecio = new int[2];
        System.out.println("");
        System.out.println("Ingrese el precio mínimo");
        rangoPrecio[0] = Integer.parseInt(lector.readLine());
        System.out.println("Ingrese el precio máximo");
        rangoPrecio[1] = Integer.parseInt(lector.readLine());        
        return rangoPrecio;
    }
    
    ////////////////////////// MENUS DESPLEGADOS ///////////////////////////////
    
    public void desplegarMenuPrincipal() {
        System.out.println("");
        System.out.println("************ Menu principal ***********");
        System.out.println("");
        System.out.println(" 1. Agregar elemento");
        System.out.println(" 2. Mostrar elementos");
        System.out.println(" 3. Buscar elementos");        
        System.out.println(" 4. Modificar elemento");
        System.out.println(" 5. Eliminar elemento");
        System.out.println(" 6. Funciones extras");
        System.out.println(" 0. Salir");
    }
    
    public void desplegarMenuAgregar() {
        System.out.println("");
        System.out.println("Seleccione el tipo de elemento a agregar");
        System.out.println(" 1. Cliente");
        System.out.println(" 2. Equipo");
        System.out.println(" 3. Plan");
        System.out.println(" 4. Compañía");
        System.out.println(" 0. Salir");
    }
    
    public void desplegarMenuMostrar() {
        System.out.println("");
        System.out.println("Seleccione el tipo de elemento a mostrar");
        System.out.println(" 1. Cliente");
        System.out.println(" 2. Equipo");
        System.out.println(" 3. Plan");
        System.out.println(" 4. Compañías");
        System.out.println(" 5. Todo");
        System.out.println(" 0. Salir");        
    }
    public void desplegarMenuModificar() {
        System.out.println("");
        System.out.println("Seleccione el tipo de elemento a editar");
        System.out.println(" 1. Cliente");
        System.out.println(" 2. Equipo");
        System.out.println(" 3. Plan");
        System.out.println(" 4. Compañía");
        System.out.println(" 0. Salir"); 
    }
    
    public void desplegarMenuEliminar() {
        System.out.println("");
        System.out.println("Seleccione el tipo de elemento a editar");
        System.out.println(" 1. Cliente");
        System.out.println(" 2. Equipo");
        System.out.println(" 3. Plan");
        System.out.println(" 4. Compañía");
        System.out.println(" 0. Salir"); 
    }
    
    public void desplegarMenuExtra() {
        System.out.println("");
        System.out.println("Seleccione el tipo de elemento a editar");
        System.out.println(" 1. Busqueda de equipos por rango de precio");
        System.out.println(" 2. Obtener el equipo mas economico");
        System.out.println(" 0. Salir"); 
    }
    
    public void casoDeRepeticion(){
        System.out.println("");
        System.out.println("Como su equipo ya se encuentra en su posicion");
        System.out.println("debe sumarle un 1 al codigo anteriormente ingresado");
        System.out.println("");
    }
    /////////////////////// MOSTRAR ///////////////////////////////////////////
    
}
