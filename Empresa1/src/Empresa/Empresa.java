/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;
import java.io.*;
import java.util.*;

class Empresa
{   
    private Map<Integer, Cliente> mapaCliente;
    private  ArrayList <Servicios> listServicios;
    private ArrayList<Equipos> listEquipos;
    
    public Empresa() {
        mapaCliente = new HashMap<>();
        listServicios = new ArrayList<>();
        listEquipos = new ArrayList<>();
    }
    
    /////////////////////////// Llenado de datos ///////////////////////////////////////
    
    public Cliente createClient(String data) {
        String[] camposC = new String[3];
        camposC = data.split(",");
        Cliente client = new Cliente(camposC[0], camposC[1], Integer.parseInt(camposC[2]));
        return client;
    }
    
    
    public EquipoCliente createEquipC (String data) {
        String[] camposEc = new String[3];
        camposEc = data.split(",");
        EquipoCliente equiposC = new EquipoCliente(camposEc[0], Integer.parseInt(camposEc[1]), Integer.parseInt(camposEc[2]));
        return equiposC;
    }
    
    public ServicioCliente createServiceC (String data) {
        String[] camposSc = new String[7];
        camposSc = data.split(",");
        ServicioCliente serviciosC = new ServicioCliente(Integer.parseInt(camposSc[0]), camposSc[1], camposSc[2], Integer.parseInt(camposSc[3]), Integer.parseInt(camposSc[4]), Integer.parseInt(camposSc[5]), Integer.parseInt(camposSc[6]));
        return serviciosC;
    }
    
    public Equipos createEquip(String data) {
        String[] camposE = new String[4];
        camposE = data.split(",");
        Equipos equipos = new Equipos(camposE[0], camposE[1], Integer.parseInt(camposE[2]), Integer.parseInt(camposE[3]));
        return equipos;
    }
    
    public Servicios createService(String data) {
        String[] camposS = new String[4];
        camposS = data.split(",");
        Servicios servicios = new Servicios(Integer.parseInt(camposS[0]), Integer.parseInt(camposS[1]), Integer.parseInt(camposS[2]), Integer.parseInt(camposS[3]), Integer.parseInt(camposS[4]));
        return servicios;
    }
    
    /////////////////////// Ingreso de cliente a traves de la consola//////////////////////////
    
    public void ingresoPorConsola(String data){
        Cliente client = createClient(data);
        mapaCliente.put(client.getRut(), client);
        System.out.println("Cliente ingresado de manera exitosa");
    }
    
    public void ingresoPorConsolaS(String data){
        Servicios s = createService(data);
        listServicios.add(s);
        System.out.println("El servicio a sido ingresado de manera exitosa");
    }
    
    public void ingresoPorConsolaE(String data){
        Equipos e = createEquip(data);
        listEquipos.add(e);
        System.out.println("El equipo a sido ingresado de manera exitosa");
    }
    
    
    ///////////////////////////////// Insercion datos de CSV CLIENTES /////////////////////////////////
    
    public void addClients() throws IOException {
        try (BufferedReader lector = new BufferedReader(new FileReader("./clientes.csv"))) {
            String line;
            while ((line = lector.readLine()) != null) {
                Cliente client = createClient(line);
                mapaCliente.put(client.getRut(), client);
            }
        }
        System.out.println("Clientes agregados al archivo CSV");
    }
    
    public void insertEquiposClients() throws IOException{
        
        BufferedReader lector = new BufferedReader(new FileReader("./equipClient.csv"));
        String line;
        while((line = lector.readLine()) != null){
            
            EquipoCliente equiposC = createEquipC(line);
            Cliente client = new Cliente();
            mapaCliente.get(client.getRut()).agregarEquipoCliente(equiposC);
        }
        System.out.println("Euipos del cliente agregados al archivo CSV");
    }
    
    public void insertServiciosClients() throws IOException{
        
        BufferedReader lector = new BufferedReader(new FileReader("./serviceClient.csv"));
        String line;
        while((line = lector.readLine()) != null){
            
            ServicioCliente sC = createServiceC(line);
            Cliente client = new Cliente();
            mapaCliente.get(client.getRut()).agregarServicioCliente(sC);
        }
        System.out.println("Servicios del cliente agregados al archivo CSV");
    }
    //////////////////////////// Insercion datos de CSV EQUIPOS /////////////////////////
    
    public void insertEquipos() throws IOException{
        
        BufferedReader lector = new BufferedReader(new FileReader("./equipos.csv"));
        String line;
        while((line = lector.readLine()) != null){
            
            Equipos e = createEquip(line);
            listEquipos.add(e);
        }
        System.out.println("Servicios del cliente agregados al archivo CSV");
    }
    
    //////////////////////////// Insercion datos de CSV SERVICIOS ///////////////////////
    
    public void insertServices() throws IOException{
        
        BufferedReader lector = new BufferedReader(new FileReader("./services.csv"));
        String line;
        while((line = lector.readLine()) != null){
            
            Servicios s = createService(line);
            listServicios.add(s);
        }
        System.out.println("Servicios del cliente agregados al archivo CSV");
    }
    
    /////////////////////////////// Metodos menu ////////////////////////////////////////
    
    /* metodos para el cliente */
    public void modificarC(int key) throws IOException{
        
        System.out.println("Ingrese los datos a modificar del cliente separados por coma, los datos son: ");
        System.out.println("[1] Nombre y apellido (separados por un espacio");
        System.out.println("[2] Rut (sin puntos y sin guion)");
        System.out.println("[3] Direccion");
        
        BufferedReader lec = new BufferedReader(new InputStreamReader(System.in));
        String line = lec.readLine();
        
        if(mapaCliente.containsKey(key)){
           Cliente client = createClient(line);
           mapaCliente.replace(key, client);           
        }else System.out.println("no existe el rut ingresado");
        
    }
    
    public void eliminarCliente(int key){
        
        if(mapaCliente.containsKey(key)) mapaCliente.remove(key);
        else System.out.println("El cliente no se encuentra registrado");
    }
    
    public Cliente buscarCliente(int key){
        
        if(mapaCliente.containsKey(key)) return mapaCliente.get(key);
        else{
            System.out.println("El rut ingresado no se encuentra dentro de los clientes de la empresa");
            return null;
        }
    }
    
    public void printClients(){
        
        ArrayList listClients = new ArrayList(mapaCliente.values());
        // obtenemos los clientes de a uno y se imprimen sus datos.
        for(int i = 0; i < listClients.size() ; i++){
            Cliente client  = (Cliente) listClients.get(i);
            System.out.println("Nombre: " + client.getNombre() + " | " + "RUT: " + client.getRut() + " | " + "Direccion: " + client.getDireccion() + " | ");
            System.out.println("Equipo/s cliente: ");
            // recorrer lista de equipos asociados al cliente
            for(int j = 0; j < client.getEquipoAsos().size() ; j++){
                EquipoCliente equipClient = client.getEquipoAsos().get(j);
                System.out.println("| Modelo: " + equipClient.getModelo() + " | Numero telefonico : " + equipClient.getNumeroTelefonico()+" | codigo telefono: "+ equipClient.getCodigoTelefono()+" |");
            }
            
            System.out.println("Servicio/s cliente: ");
            // recorrer lista de servicios asociados al cliente
            for(int k = 0; k < client.getListServicios().size() ; k++){
                ServicioCliente sC = client.getListServicios().get(k);
                System.out.println("| Nombre plan: "+ sC.getTipoServicio()+"| Fecha vencimiento cuenta: "+sC.getFechaVen()+ "| Fecha pago cuenta: "+sC.getFechaPag()+"| Precio factura: "+sC.getPrecioFactura()+"| Total Gb: "+sC.getTotalGb()+"| Total minutos: "+sC.getTotalMinutos()+"| Total mensajes"+ sC.getTotalMensajes()+" |");
            }
        }
    }
    
    /* 
        preguntar y revisar bien conmo poder eliminar un elemento de un arraylist.
        
       -funciones para eliminar equipo cliente y servicio cliente no estan listas.-
    */
    
    // necesitamos implementar un codigo con cada celular respectivo para poder eliminarlo
    
    public void eliminarEquipoCliente(int key, int codigoCelular){
        
        if(mapaCliente.containsKey(key)){
            mapaCliente.get(key).getEquipoAsos().remove(codigoCelular);
        }else System.out.println("el equipo del cliente no ha sido encontrado");
    }
    
    // necesitamos implementar un tipo de servicio (1, 2 ,3) respectivo para poder eliminarlo
    public void eliminarServicioCliente(int key, int tipoServicio){
        
        if(mapaCliente.containsKey(key)){
            mapaCliente.get(key).getListServicios().remove(tipoServicio); 
        }else System.out.println("el servicio del cliente no ha sido encontrado");
    }
        
    /* metodos para los equipos */
    
    // falta metodo para agregar Servicio y Equipos.
    
    public int buscarServicio(int tipoServicio){
        
        for(int i = 0; i < listServicios.size(); i++){
            if(listServicios.get(i).getTipoServicio() == tipoServicio){
                System.out.println("El servicio solicitado ha sido encontrado con exito");
                return i;
            }else System.out.println("El servicio solicitado no ha sido encontrado");          
        }
        return 0;
    }
    
    public void modServicio(int tipoServicio)throws IOException{
        
        if(buscarServicio(tipoServicio)!= 0){
            System.out.println("Ingrese los datos a modificar del cliente separados por coma, los datos son: ");
            System.out.println("[1] tipoServicio");
            System.out.println("[2] totalGb");
            System.out.println("[3] totalMensajes");
            System.out.println("[4] totalMinutosLlamada");
            System.out.println("[5] precioServicio");
        
            BufferedReader lec = new BufferedReader(new InputStreamReader(System.in));
            String line = lec.readLine();
            Servicios s = createService(line);
            // eliminar elementos de la lista que tenga esa tipo de servicio
            listServicios.remove(buscarServicio(tipoServicio));
            // agregamos los datos ingresados por le usuario
            listServicios.add(s);
            System.out.println("El servicio ha sido modificado con exito");
        }else System.out.println("El servicio solicitado no ha sido encontrado");
    }
    
    public void eliminarSerivicio(int tipoServicio){
        
        if(buscarServicio(tipoServicio)!= 0){
            listServicios.remove(tipoServicio);
            System.out.println("El servicio ha sido eliminado con exito");
        }else System.out.println("El servicio solicitado no ha sido encontrado");   
    }
    
    public void printServicios() {

        for (int i = 0 ; i < listServicios.size() ; i++) {
            Servicios s = (Servicios) listServicios.get(i);
            System.out.println("| Tipo servicio: " + s.getTipoServicio() + "| Total Gb: " + s.getTotalGb()+ "| Total mensajes : " + s.getTotalMensajes() + "| Total minutos llamada: "+ s.getTotalMinutosLlamada()+" | Precio servicio"+ s.getPrecioServicio()+" |");          
        } 
        
    }
    
    /* metodos para los servicios */
    
    public int buscarEquipos(String modeloEquipo){
        
        for(int i = 0; i < listEquipos.size(); i++){
            if(listEquipos.get(i).getModeloEquipo().equals(modeloEquipo)){
                System.out.println("El servicio solicitado ha sido encontrado con exito");
                return i;
            }else System.out.println("El servicio solicitado no ha sido encontrado");          
        }
        return 0;
    }
    
    public void modEquipo(String modeloEquipo)throws IOException{
        
        if(buscarEquipos(modeloEquipo)!= 0){
            System.out.println("Ingrese los datos a modificar del cliente separados por coma, los datos son: ");
            System.out.println("[1] modeloEquipo");
            System.out.println("[2] marca");
            System.out.println("[3] capacBat");
            System.out.println("[4] precio");
        
            BufferedReader lec = new BufferedReader(new InputStreamReader(System.in));
            String line = lec.readLine();
            Equipos e = createEquip(line);
            // eliminar elementos de la lista que tenga esa tipo de servicio
            listEquipos.remove(buscarEquipos(modeloEquipo));
            // agregamos los datos ingresados por le usuario
            listEquipos.add(e);
            System.out.println("El servicio ha sido modificado con exito");
        }else System.out.println("El servicio solicitado no ha sido encontrado");
    }
    
    public void eliminarEquipo(String modeloEquipo){
        
        if(buscarEquipos(modeloEquipo)!= 0){
            listEquipos.remove(buscarEquipos(modeloEquipo));
            System.out.println("El Equipo ha sido eliminado con exito");
        }else System.out.println("El Equipo solicitado no ha sido encontrado");   
    }
    
    public void printEquipos() {

        for (int i = 0 ; i < listEquipos.size() ; i++) {
            Equipos e = (Equipos) listEquipos.get(i);
            System.out.println("| Modelo Equipo: " + e.getModeloEquipo() + "| Marca: " + e.getMarca()+ "| Capacidad bateria : " + e.getCapacBat() + "| Precio movil: "+ " |");          
        } 
        
    }
    
    //////////////////// inicializacion de datos CSV/////////////////////////////////
    public void iniciarCarga() throws IOException {
        addClients();
        insertEquiposClients();
        insertServiciosClients();
        insertEquipos();
        insertServices();
    }
    
    //////////////////////////////////////////////////////////////////////////////
}