package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.OrdenaValoresFichero_EscribelosOtroFichero;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OrdenaValoresFichero_EscribelosOtroFichero {

    public static final String RUTA = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/OrdenaValoresFichero_EscribelosOtroFichero/Enters.txt";

    public static void main(String[] args){
        OrdenaValoresFichero_EscribelosOtroFichero programa = new OrdenaValoresFichero_EscribelosOtroFichero();
        programa.inici();
    }

    public void inici(){
        ArrayList<Integer> listadoValoresIniciales = meterValoresFicheroEnArray(RUTA);
        ArrayList<Integer> listadoValoresOrdenados = ordenarValoresArray(listadoValoresIniciales);
        escribirValoresEnArchivo(listadoValoresOrdenados);
    }

    public ArrayList meterValoresFicheroEnArray(String ruta){
        File f = new File(ruta);
        ArrayList<Integer> valoresIniciales = new ArrayList();
        try(Scanner lecturaFichero = new Scanner(f);){
            while(lecturaFichero.hasNext()){
                int valor = lecturaFichero.nextInt();
                valoresIniciales.add(valor);
            }
            System.out.println(valoresIniciales);
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        return valoresIniciales;
    }

    public ArrayList<Integer> ordenarValoresArray(ArrayList<Integer> listadoValores){
        for(int j = 0; j < listadoValores.size()-1; j++){
            for(int i = 0; i < listadoValores.size()-1; i++){
                if (listadoValores.get(i) > listadoValores.get(i+1)){
                    int valorInicial = listadoValores.get(i);
                    listadoValores.set(i, listadoValores.get(i+1));
                    listadoValores.set(i+1, valorInicial);
                }
            }
        }
        System.out.println(listadoValores);
        return listadoValores;
    }

    public void escribirValoresEnArchivo(ArrayList<Integer> listadoValores){
        try(PrintStream objetoPrint = new PrintStream("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/OrdenaValoresFichero_EscribelosOtroFichero/EntersOrdenat.txt");){
            for(int i = 0; i < listadoValores.size(); i++){
                objetoPrint.print(listadoValores.get(i) + " ");
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
