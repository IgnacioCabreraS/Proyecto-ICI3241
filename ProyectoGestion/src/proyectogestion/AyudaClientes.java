
package proyectogestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AyudaClientes extends Ayuda{
    
    @Override
    public void consulta(GestionCompañias gestiComp, Compañia compan){
        System.out.println("Consulta para clientes");
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String compUsuario = null;
        System.out.println("Ingrese la compañia donde se encuentra su cliente:");
        
        //Try-catch por error en readLine
        try {
            compUsuario = lector.readLine();
        } catch (IOException ex) {
            Logger.getLogger(AyudaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        if(gestiComp.encontrarCompañia(compUsuario) == 1){
            
            Compañia auxComp = gestiComp.retornarCompañia(compUsuario);
            auxComp.descripcion();   
            
            String rut = null;
            System.out.println("Ingrese el cliente que busca:");
            
            //Try-catch por error en readLine
            try {
                rut = lector.readLine();
            } catch (IOException ex) {
                Logger.getLogger(AyudaClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(compan.contieneElemento(rut)){
                        
                Cliente aux = gestiComp.retornarCliente(compUsuario, rut);
                System.out.println("Cliente encontrado");
                aux.descripcion();
                        
            }else System.out.println("Cliente no encontrado");
            
        }else System.out.println("Compañia buscada no existe");
    }  
}
