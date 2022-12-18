package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.EscribirEnFichero20EnterosDobles;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class EscribirEnFichero20EnterosPares {

    public static void main(String[] args){
        EscribirEnFichero20EnterosPares programa = new EscribirEnFichero20EnterosPares();
        programa.inici();
    }

    public void inici(){
        escribir20enteros("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/EscribirEnFichero20EnterosDobles/FicherosPares.txt");
        imprimirContenidoFichero("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/EscribirEnFichero20EnterosDobles/FicherosPares.txt");
    }

    public void escribir20enteros(String ruta){
        PrintStream objetoPrint = null;
        try{
            objetoPrint = new PrintStream(ruta);
            for ( int i = 0; i < 20; i++){
                objetoPrint.print(i*2);
                objetoPrint.print(" ");
            }
        }
        catch(Exception e){
            System.err.println("Error: " + e);
        }
        objetoPrint.close();
    }

    public void imprimirContenidoFichero(String ruta){
        File f = new File(ruta);
        Scanner leerFichero = null;
        try{
            leerFichero = new Scanner(f);
            while(leerFichero.hasNext()){
                int valor = leerFichero.nextInt();
                System.out.print(valor + " ");
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e);
        }
        leerFichero.close();
    }

}
