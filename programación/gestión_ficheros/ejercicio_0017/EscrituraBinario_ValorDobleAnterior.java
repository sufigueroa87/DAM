package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.EscrituraBinario_ValorDobleAnterior;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

/*
Crea un programa que escriba una secuencia de 20 valores integers en un fichero binario llamado "Enters.bin", de
manera que, empezando por el 1, cada valor sea el doble del anterior. Fíjate que no hace falta escribir ningún
delimitador, los valores se van escribiendo consecutivamente, uno tras otro.
 */
public class EscrituraBinario_ValorDobleAnterior {

    private static final String RUTA = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/EscrituraBinario_ValorDobleAnterior/Enters.bin";
    private static final String RUTA2 = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/EscrituraBinario_ValorDobleAnterior/EntersPrueba.txt";

    public static void main(String[] args){
        EscrituraBinario_ValorDobleAnterior programa = new EscrituraBinario_ValorDobleAnterior();
        programa.inici();
    }

    public void inici(){
        escribir20integersDobleAnterior(RUTA, RUTA2);
    }

    public void escribir20integersDobleAnterior(String ruta, String ruta2){
        File f = new File(ruta);
        File f2 = new File(ruta2);
        try(RandomAccessFile escribirEnArchivoBinario = new RandomAccessFile(f, "rw");
            PrintStream escribirEnArchivo = new PrintStream(f2)){
            int valor = 1;
            for ( int i = 1; i <= 20 ; i++){
                escribirEnArchivoBinario.writeInt(valor);
                escribirEnArchivo.print(valor + " ");
                valor = valor * 2;
            }
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
