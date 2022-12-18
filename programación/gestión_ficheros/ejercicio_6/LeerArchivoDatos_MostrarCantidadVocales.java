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

        File f = new File("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/LeerArchivosDatos_MostrarCantidadVocales/datos.txt");
        FileReader fr = null;
        try{
            fr = new FileReader("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/LeerArchivosDatos_MostrarCantidadVocales/datos.txt");
        }
        catch(IOException e){
            System.err.println("Problemas con el archivo.");
        }

        cantidadVocalesFile(f, fr);
    }

    public void cantidadVocalesFile(File f, FileReader fr){
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
        System.out.println("La cantidad de vocales que contiene el archivo " + f.getName() + " es " + cantidadVocales);
    }

}