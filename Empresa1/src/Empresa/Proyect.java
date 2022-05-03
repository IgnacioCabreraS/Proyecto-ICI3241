/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import java.io.IOException;
public class Proyect {

    public static void main(String[] args)throws IOException {
      
        Empresa empresa = new Empresa();
        // metodo utilizado para cargar datos de CSV.
        empresa.iniciarCarga();
        //metodo utilizado para observar el menu del cliente.
        Menu menu = new Menu();
        menu.menuGeneral();
    }
    
}
