package unitat5.u5_1_DescomposicioEnClassesIBiblioteques.reptes.repte5;

import java.util.Arrays;
import java.util.Random;

/**
 * Repte 5. Creeu una classe que pertanyi al package unitat5.apartat1.reptes, el qual faci el següent. Es genera
 * un array de 10 posicions i cadascuna d’elles s’inicialitza amb un valor a l’atzar entre 1 i 10, i es mostren per
 * pantalla. Llavors, per cada valor escrit entre les posicions 0 a 4, se cerca si aquest és en alguna de les
 * posicions entre la 5 i la 9. Cada cop que troba un dels valors, ho anuncia per pantalla. Useu tots els mètodes de
 * la classe Arrays que sigui possible.
 */
public class Random_nextDouble_Arrays_toString_Math_round_Arrays_copyOfRange_Arrays_sort {

    public static void main (String[] args) {
        Random_nextDouble_Arrays_toString_Math_round_Arrays_copyOfRange_Arrays_sort programa = new Random_nextDouble_Arrays_toString_Math_round_Arrays_copyOfRange_Arrays_sort();
        programa.inici();
    }

    public void inici(){

        long[] arrayInicial = generarArrayAmbValorsRandom();
        long[] copia1 = Arrays.copyOfRange(arrayInicial, 0, 5);
        System.out.println("L'arary copia1 és :" + Arrays.toString(copia1));
        long[] copia2 = Arrays.copyOfRange(arrayInicial, 5, arrayInicial.length);
        System.out.println("L'array copia2 és :" + Arrays.toString(copia2));
        trobarValorsDunArrayEnUnAltraArray(copia1, copia2);
    }

    public long[] generarArrayAmbValorsRandom(){
        long[] arrayGenerat = new long[10];
        Random rnd = new Random();
        for (int i = 0; i < arrayGenerat.length; i++){
            double valor = rnd.nextDouble()*9;
            arrayGenerat[i] = Math.round(valor)+1;
        }
        System.out.println("L'array creat és: " + Arrays.toString(arrayGenerat));
        return arrayGenerat;
    }

    public void trobarValorsDunArrayEnUnAltraArray(long[] a, long[] b){
        Arrays.sort(b);
        System.out.println("L'array ordenat és: " + Arrays.toString(b));
        int pos = 0;
        for (int i = 0; i < a.length; i++ ) {
            pos = Arrays.binarySearch(b, a[i]);
            if ( pos >= 0) {
                System.out.println("Hi ha un " + a[i] + " a la posició " + pos + ".");
            }
        }
    }
}
