package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.LeerArchivosDatos_MostrarCantidadVocales;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class LeerArchivoDatos_MostrarCantidadVocales {

    public static void main(String[] args){
        LeerArchivoDatos_MostrarCantidadVocales programa = new LeerArchivoDatos_MostrarCantidadVocales();
        programa.inici();
    }

    public void inici(){

        cantidadVocalesFile("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/LeerArchivosDatos_MostrarCantidadVocales/datos.txt");
    }

    public void cantidadVocalesFile(String ruta){
        File f = new File(ruta);
        FileReader fr = null;
        try{
            fr = new FileReader(ruta);
        }
        catch(IOException e){
            System.err.println("Problemas con el archivo.");
        }
        int cantidadVocales = 0;
        for (int i = 0; i < f.length(); i++){
            try{
                char valor = (char)fr.read();
                String valorString = valor + "";
                if (Pattern.matches("[aeiou]", valorString)){
                    cantidadVocales++;
                }
            }
            catch(IOException e){
                System.out.println("Problemas con el archivo.");
            }
        }
        try{
            fr.close();

        }
        catch(IOException e){
            System.out.println("Problemas con el archivo " + f.getName());
        }
        System.out.println("La cantidad de vocales que contiene el archivo " + f.getName() + " es " + cantidadVocales);
    }
}