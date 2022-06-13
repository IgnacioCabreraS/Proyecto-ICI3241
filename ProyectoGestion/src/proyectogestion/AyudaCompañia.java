
package proyectogestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AyudaCompañia extends Ayuda{
    
    @Override
    public void consulta(GestionCompañias gestiComp, Compañia compan){
        System.out.println("Consulta para compañia");
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String compUsuario = null;
        System.out.println("Ingrese la compañia que desea buscar:");
        //Try-catch por error en readLine
        try {
            compUsuario = lector.readLine();
        } catch (IOException ex) {
            Logger.getLogger(AyudaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        if(gestiComp.encontrarCompañia(compUsuario) == 1){
           System.out.println("Compañia buscada si existe");                          
        }else System.out.println("Compañia buscada no existe");
    }
    
    
    
}
