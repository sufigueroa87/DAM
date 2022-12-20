package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.sobreescrituraFicheroBinario;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

/*
Crea un programa que escriba una secuencia de 20 valores integers en un fichero binario llamado "Enters.bin", de
manera que, empezando por el 1, cada valor sea el doble del anterior. Fíjate que no hace falta escribir ningún
delimitador, los valores se van escribiendo consecutivamente, uno tras otro.
Ahora, reemplaza el fichero "Enters.bin" por 5 valores integers -1. El resultado final es un fichero de solo 20bytes,
en vez de 80 bytes. Pistas: usa el método writeInt para reescribir en el archivo binario. Usa el método
getFilePointer() para saber donde se encuentra el apuntador. Usa el método setLength(apuntador) para establecer la
dimensión del archivo.
 */

public class SobreescrituraFicheroBinario {

    public static final String RUTA = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/sobreescrituraFicheroBinario/Enters.bin";
    public static final String RUTA2 = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/sobreescrituraFicheroBinario/Prueba.txt";

    public static void main(String[] args){
        SobreescrituraFicheroBinario programa = new SobreescrituraFicheroBinario();
        programa.inici();
    }

    public void inici(){
        escribir20integersDobleAnterior(RUTA, RUTA2);
        sobreescribir5ValoresPorMenosUno(RUTA, RUTA2);
    }

    public void escribir20integersDobleAnterior(String ruta, String ruta2){
        File f = new File(ruta);
        try(RandomAccessFile escribirEnArchivoBinario = new RandomAccessFile(f, "rw");
                PrintStream pruebaFicheroCaracteres = new PrintStream(ruta2)){
            long apuntador = escribirEnArchivoBinario.getFilePointer();
            System.out.println("El apuntador al inicio se encuentra en la posición " + apuntador + ".");
            int valor = 1;
            for ( int i = 1; i <= 20 ; i++){
                escribirEnArchivoBinario.writeInt(valor);
                pruebaFicheroCaracteres.print(valor + " ");
                valor = valor * 2;
            }
            apuntador = escribirEnArchivoBinario.getFilePointer();
            System.out.println("El apuntador al finalizar la escritura se encuentra en la posición " + apuntador + ".");

        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void sobreescribir5ValoresPorMenosUno(String ruta, String ruta2){
        File f = new File(ruta);
        try(RandomAccessFile raf = new RandomAccessFile(f, "rw");
            PrintStream pruebaFicheroCaracteres = new PrintStream(ruta2)){
            long apuntador = raf.getFilePointer();
            System.out.println("El apuntador al inicio de la sobreescritura se encuentra en la posición " + apuntador + ".");
            int contador = 1;
            while(contador <=5){
                raf.writeInt(-1);
                pruebaFicheroCaracteres.print(-1 + " ");
                contador++;
            }
            System.out.println("Necesito borrar el sobrante que ha quedado en el archivo binario.");
            System.out.println("Para ello, miro en qué lugar se ha quedado el cursor tras la sobreescritura.");
            apuntador = raf.getFilePointer();
            System.out.println("El apuntador al finalizar la sobreescritura se encuentra en la posición " + apuntador + ".");
            System.out.println("Establezco la dimensión del archivo en el lugar final donde se quedó el apuntador con setLength(apuntador).");
            raf.setLength(apuntador);
            System.out.println("Miro que la dimensión del archivo sea igual a donde se quedó el apuntador al finalizar la sobreescritura.");
            if (f.length() == apuntador){
                System.out.println("La sobreescritura se ha realizado correctamente.");
            } else {
                System.err.println("Sobreescritura mal realizada.");
            }
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
