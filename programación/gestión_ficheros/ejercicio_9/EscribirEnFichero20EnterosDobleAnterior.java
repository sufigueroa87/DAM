package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.EscribirEnFichero20EnterosDobleAnterior;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class EscribirEnFichero20EnterosDobleAnterior {

    public static void main(String[] args){
        EscribirEnFichero20EnterosDobleAnterior programa = new EscribirEnFichero20EnterosDobleAnterior();
        programa.inici();
    }

    public void inici(){
        escribirDoblesEnFichero("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/EscribirEnFichero20EnterosDobleAnterior/FicherosDobles.txt");
        imprimirValoresFichero("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/EscribirEnFichero20EnterosDobleAnterior/FicherosDobles.txt");
    }

    public void escribirDoblesEnFichero(String ruta){
        PrintStream escribirFichero = null;
        try{
            escribirFichero = new PrintStream(ruta);
            int valor = 1;
            for (int i = 0; i < 20; i++){
                escribirFichero.print(valor + " ");
                valor = valor*2;
            }
        }
        catch(Exception e){
            System.err.println("Error: " + e);
        }
        escribirFichero.close();
    }

    public void imprimirValoresFichero(String ruta){
        File f = new File(ruta);
        Scanner lecturaFichero = null;
        try{
            lecturaFichero = new Scanner (f);
            while(lecturaFichero.hasNext()){
                int valor = lecturaFichero.nextInt();
                System.out.print(valor + " ");
            }
        }
        catch(Exception e){
            System.err.println("Error: " + e);
        }
        lecturaFichero.close();
    }

}
