package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.LecturaHastaMarca;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LecturaHastaMarca {

    public static void main(String[] args){
        LecturaHastaMarca programa = new LecturaHastaMarca();
        programa.inici();
    }

    public void inici(){
        leerHastaMarca("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/LecturaHastaMarca/Integers");
    }

    public void leerHastaMarca(String ruta){
        File f = new File(ruta);
        try(Scanner lecturaFichero = new Scanner(f);){
            int valor = 0;
            do{
                valor = lecturaFichero.nextInt();
                System.out.println(valor + " ");
            } while(valor != -1);
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}