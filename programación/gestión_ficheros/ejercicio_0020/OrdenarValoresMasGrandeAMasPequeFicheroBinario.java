package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.ordenarValoresDeMasGrandeAMasPequeñoFicheroBinario;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrdenarValoresMasGrandeAMasPequeFicheroBinario {

    private static final String RUTA_BIN = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/ordenarValoresDeMasGrandeAMasPequeñoFicheroBinario/integers.bin";
    private static final String RUTA_TXT = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/ordenarValoresDeMasGrandeAMasPequeñoFicheroBinario/pruebaTest.txt";

    public static void main(String[] args){
        OrdenarValoresMasGrandeAMasPequeFicheroBinario programa = new OrdenarValoresMasGrandeAMasPequeFicheroBinario();
        programa.inici();
    }

    public void inici(){
        meterRandomValoresEnFicheroBinario(RUTA_BIN, RUTA_TXT);
        ordenarIntegersEnArchivoBinario(RUTA_BIN, RUTA_TXT);
    }

    public void meterRandomValoresEnFicheroBinario(String ruta, String ruta_2){
        File f = new File(ruta);
        int cantidadValores = 0;
        try(RandomAccessFile raf = new RandomAccessFile(f, "rw");
            PrintStream ps = new PrintStream(ruta_2)){
            //creo random para saber la cantidad de valores a meter en el archivo, pongo como máximo el integer 40
            cantidadValores = (int)(Math.random() * 40);
            System.out.println("La cantidad de valores integer a introducir en el fichero binario es " + cantidadValores);
            //creo el bucle para ir metiendo los integers en el archivo
            int contador = 1;
            while(contador <= cantidadValores){
                int valor = (int)(Math.random() * 100);
                raf.writeInt(valor);
                ps.print(valor + " ");
                contador++;
            }
            //tras meter los valores en el archivo establezco el lentgh del archivo, por si se ha sobreescrito que no quede basura
            long apuntador = raf.getFilePointer();
            raf.setLength(apuntador);
            long longitudFichero = f.length();
            System.out.println("Debe coincidir con la longitud del fichero dividido entre 4: " + longitudFichero / 4);
            System.out.println("Y debe coincidir con la posición en que se quedó el apuntador al terminar de introducir dividido por 4: " + apuntador / 4);
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void ordenarIntegersEnArchivoBinario(String ruta, String ruta_2){
        File f = new File(ruta);
        File f2 = new File(ruta_2);
        try(RandomAccessFile raf = new RandomAccessFile(f, "rw");
                Scanner lectorArchivo = new Scanner(f2)){
            System.out.println("Bytes del archivo binario: " + f.length() + " bytes.");
            int contador = 0;
            while (lectorArchivo.hasNext()){
                lectorArchivo.nextInt();
                contador++;
            }
            System.out.println("Bytes del archivo txt: " + contador * 4 + " bytes.");
            //meto valores en array
            ArrayList<Integer> listadoIntegers = meterValoresEnArrayListIntegers(RUTA_TXT);
            ArrayList<Integer> listadoIntegersDelArchivoBinario = meterValoresEnArrayBin(RUTA_BIN);
            //ordeno valores
            Collections.sort(listadoIntegers);
            System.out.println("Lista ordenada de los valores del archivo txt: " + listadoIntegers);
            Collections.sort(listadoIntegersDelArchivoBinario);
            System.out.println("Lista ordenada de los valores del archivo bin: " + listadoIntegersDelArchivoBinario);
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    public ArrayList<Integer> meterValoresEnArrayListIntegers(String ruta){
        ArrayList<Integer> listadoInteger = new ArrayList<>();
        File f = new File(ruta);
        try(Scanner lector = new Scanner(f);){
            while(lector.hasNext()){
                int valor = lector.nextInt();
                listadoInteger.add(valor);
            }
            System.out.println(listadoInteger);
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        return listadoInteger;
    }

    public ArrayList<Integer> meterValoresEnArrayBin(String ruta){
        ArrayList<Integer> listadoInteger = new ArrayList<>();
        File f = new File(ruta);
        try(RandomAccessFile raf = new RandomAccessFile(f, "r");){
            for ( int i = 0; i < f.length()/4; i++){
                int valor = raf.readInt();
                listadoInteger.add(valor);
            }
            System.out.println(listadoInteger);
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        return listadoInteger;
    }
}
