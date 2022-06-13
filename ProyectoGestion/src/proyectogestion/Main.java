package proyectogestion;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        /////////////////////// DATOS INICIALES  ///////////////////////////////
        
        GestionCompañias gc = new GestionCompañias();
        Compañia c = new Compañia("Entel");
        Cliente cl = new Cliente("juanito","20946700-3","copiapo123","Entel");
        EquipoCliente eq = new EquipoCliente("galaxy 8","+569133","12","20946700-3", "Entel");
        EquipoCliente eq2 = new EquipoCliente("galaxy 82","+5691335","11","20946700-3", "Entel");
        
        // agregar elementos a las colecciones
        gc.agregarElemento(c);
        gc.agregarElemento(cl,"Entel");
        gc.agregarElemento(eq, "20946700-3", "Entel");
        gc.agregarElemento(eq2, "20946700-3", "Entel");
        

        // mostrar elementos 
        Compañia compAux = gc.retornarCompañia("Entel");
        Cliente clAux = gc.retornarCliente("Entel","20946700-3");
        EquipoCliente eq2Aux = gc.retornarEquipoAsos("Entel","20946700-3","11");
        EquipoCliente eqAux = gc.retornarEquipoAsos("Entel","20946700-3","12");
        
        
        compAux.descripcion();
        clAux.descripcion();
        eqAux.descripcion();
        eq2Aux.descripcion();
        
    /////////////////////// DATOS INICIALES DE EQUIPOS /////////////////////////
        
        Equipos e1 = new Equipos("x","iphone",2300,500000,"Entel",123);
        Equipos e2 = new Equipos("8","iphone",2000,300000,"Entel",246);
        Equipos e3 = new Equipos("7","iphone",2100,230000,"Entel",93);
        Equipos e4 = new Equipos("xr","iphone",2900,600000,"Movistar",12);
        
        //gc.agregarElemento(e1,"Entel");
        
        gc.agregarElemento(e1,"Entel");
        gc.agregarElemento(e2,"Entel");
        gc.agregarElemento(e3,"Entel");
        gc.agregarElemento(e4,"Entel");
        
        
        Equipos auxComp = gc.retornarEquipo("Entel", 123);
        
        auxComp.descripcion();
    
    ////////////////////////////////////////////////////////////////////////////
        
        Menu menu = new Menu();
        menu.desplegarMenuPrincipal();
        String opcion = menu.solicitarOpcion();
        menu.menuPrincipal(opcion,gc,c,cl,eq);
        
    /////////////////////////////EXPORTAR TXT///////////////////////////////////
    
        gc.exportarTXT(c);
    }
    
}
