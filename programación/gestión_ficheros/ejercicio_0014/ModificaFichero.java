package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.ModificaFicheros;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/*
ej. 0014 gestión de ficheros:

Crea un programa que modifique un fichero orientado a carácteres (modificacionValores.txt) que contiene 10 valores de
tipo integer, sumando 5 a los valores que se encuentran en las posiciones pares. Pista: se deben leer todos los valores,
almacenarlos en un array, hacer las modificaciones y sobreescribir el fichero original completo.
 */
public class ModificaFichero {

    public static final String RUTA = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/ModificaFicheros/modificacionValores.txt";

    public static void main(String[] args){
        ModificaFichero programa = new ModificaFichero();
        programa.inici();
    }

    public void inici(){
        ArrayList<Integer> listado = almacenarValoresEnArrayList(RUTA);
        ArrayList<Integer> listadoConSumaDe5 = sumar5enPosicionesPares(listado);
        sobreescribirArchivo(RUTA, listadoConSumaDe5);
    }

    public ArrayList<Integer> almacenarValoresEnArrayList(String ruta){
        File listado = new File(ruta);
        ArrayList<Integer> listadoArray = new ArrayList<>();
        try(Scanner lectorFichero = new Scanner(listado);) {
            while (lectorFichero.hasNext()) {
                int valor = lectorFichero.nextInt();
                listadoArray.add(valor);
            }
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        return listadoArray;
    }

    public ArrayList<Integer> sumar5enPosicionesPares(ArrayList<Integer> listado){
        for (int i = 0; i < listado.size(); i++){
            if (i%2 == 0){
                listado.set(i, listado.get(i) + 5);
            }
        }
        return listado;
    }

    public void sobreescribirArchivo(String ruta, ArrayList<Integer> listado){
        try(PrintStream sobreescribirArchivo = new PrintStream(ruta);){
            for(int i = 0; i < listado.size(); i++){
                sobreescribirArchivo.print(listado.get(i) + " ");
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
