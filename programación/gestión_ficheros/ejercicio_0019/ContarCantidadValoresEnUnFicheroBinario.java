package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.ContarCantidadValoresEnUnFicheroBinario;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ContarCantidadValoresEnUnFicheroBinario {

    private static final String RUTA = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/ContarCantidadValoresEnUnFicheroBinario/integer.bin";

    public static void main(String[] args){
        ContarCantidadValoresEnUnFicheroBinario programa = new ContarCantidadValoresEnUnFicheroBinario();
        programa.inici();
    }

    public void inici(){
        meterRandomValoresEnFicheroBinario(RUTA);

        conocerCantidadValoresEnArchivoBinario(4, RUTA);
    }

    public void meterRandomValoresEnFicheroBinario(String ruta){
        File f = new File(ruta);
        int cantidadValores = 0;
        try(RandomAccessFile raf = new RandomAccessFile(f, "rw");){
            //creo random para saber la cantidad de valores a meter en el archivo, pongo como máximo el integer 40
            cantidadValores = (int)(Math.random() * 40);
            System.out.println("La cantidad de valores integer a introducir en el fichero binario es " + cantidadValores);
            //creo el bucle para ir metiendo los integers en el archivo
            int contador = 1;
            while(contador <= cantidadValores){
                int valor = (int)(Math.random() * 100);
                raf.writeInt(valor);
                contador++;
            }
            //tras meter los valores en el archivo establezco el lentgh del archivo, por si se ha sobreescrito que no quede basura
            long apuntador = raf.getFilePointer();
            raf.setLength(apuntador);
            long longitudFichero = f.length();
            System.out.println("Debe coincidir con la longitud del fichero * 4: " + longitudFichero / 4);
            System.out.println("Y debe coincidir con la posición en que se quedó el apuntador al terminar de introducir dividido por 4: " + apuntador / 4);
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void conocerCantidadValoresEnArchivoBinario(int cantidadBytesTipoVariableDelArchivo, String ruta){
        File f = new File(ruta);
        try(RandomAccessFile raf = new RandomAccessFile(f, "r");){
            //miro longitud del archivo
            long longitudArchivo = f.length();
            System.out.println("La cantidad de bytes que tiene el archivo " + f.getName() + " es " + longitudArchivo);
            //divido los bytes en grupos de bytes según el tipo de variable que sean los valores del archivo
            long cantidadValoresEnArchivo = longitudArchivo / cantidadBytesTipoVariableDelArchivo;
            System.out.println("El archivo contiene " + cantidadValoresEnArchivo + " valores.");
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
