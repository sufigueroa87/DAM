package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.contarMediaVocalesPalabras;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ContarMediaVocalesPalabras {

    private static final String RUTA = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/contarMediaVocalesPalabras/Document.txt";

    public static void main(String[] args){
        ContarMediaVocalesPalabras programa = new ContarMediaVocalesPalabras();
        programa.inici();
    }

    public void inici(){
        int cantidadVocales = contarVocales(RUTA);
        int cantidadPalabras = contarPalabras(RUTA);
        mediana(cantidadVocales, cantidadPalabras);
    }

    public int contarVocales(String ruta){
        File f = new File(ruta);
        int cantidadVocales = 0;
        try(FileReader fr = new FileReader(ruta);){
            String valor = "";
            for ( int i = 0; i < f.length(); i++){
                valor = (char)fr.read()+"";
                if (Pattern.matches("[aeiouAEIOU]",valor)){
                    cantidadVocales++;
                }
            }
            System.out.println("La cantidad de vocales del archivo " + f.getName() + " es " + cantidadVocales + ".");
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        return cantidadVocales;
    }

    public int contarPalabras(String ruta){
        File f = new File(ruta);
        int cantidadPalabras = 0;
        try(Scanner leerArchivo = new Scanner (f);){
            while(leerArchivo.hasNext()){
                cantidadPalabras++;
                leerArchivo.next();
            }
            System.out.println("La cantidad de palabras que tiene el fichero " + f.getName() + " es " + cantidadPalabras + ".");
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }

        return cantidadPalabras;
    }

    public void mediana(int cantidadVocales, int cantidadPalabras){
        int mediana = cantidadVocales / cantidadPalabras;
        System.out.println("La media de vocales es de " + mediana + ".");
    }

}
