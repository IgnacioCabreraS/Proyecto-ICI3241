package Empresa;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

// falta agregar codigo que lea los archivos

public class LectorCSV {
    public void leer(){
        
        ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
        Path filePath = Paths.get("C:\\Descargas\\ClientesRegistrados.csv");
        
        try{
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;
            while((linea = br.readLine())!= null){
                
                String[] datosDeLinea = linea.split(",");
                ArrayList<String> datosTemporal = new ArrayList<String>();
                for(String dato : datosDeLinea){
                    datosTemporal.add(dato);
                }
            }
        } catch (IOException e){       }
        System.out.println(datos);
        
    }
}
