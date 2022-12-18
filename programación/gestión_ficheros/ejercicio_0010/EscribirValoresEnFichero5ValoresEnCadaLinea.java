package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.EscribirValoresEnFichero5ValoresEnCadaLinea;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class EscribirValoresEnFichero5ValoresEnCadaLinea {

    public static void main(String[] args){
        EscribirValoresEnFichero5ValoresEnCadaLinea programa = new EscribirValoresEnFichero5ValoresEnCadaLinea();
        programa.inici();
    }

    public void inici(){
        escribirEnFichero("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/EscribirValoresEnFichero5ValoresEnCadaLinea/5valoresCadaLinea.txt");
        imprimirContenidoFichero("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/EscribirValoresEnFichero5ValoresEnCadaLinea/5valoresCadaLinea.txt");
    }

    public void escribirEnFichero(String ruta){
        PrintStream escribirFichero = null;
        try{
            escribirFichero = new PrintStream(ruta);
            int count = 0;
            for (int i = 1; i <= 20; i++){
                count++;
                escribirFichero.print(i + " ");
                if (count == 5){
                    count = 0;
                    escribirFichero.println("");
                }
            }
        }
        catch(Exception e){
            System.err.println("Error: " + e);
        }
        escribirFichero.close();
    }

    public void imprimirContenidoFichero(String ruta){
        File f = new File(ruta);
        Scanner lecturaFichero = null;
        try{
            lecturaFichero = new Scanner(f);
            int count = 0;
            while (lecturaFichero.hasNext()){
                int valor = lecturaFichero.nextInt();
                count++;
                System.out.print(valor + " ");
                if (count % 5 == 0){
                    System.out.println("");
                }
            }
        }
        catch(Exception e){
            System.err.println("Error: " + e);
        }
        lecturaFichero.close();
    }
}
