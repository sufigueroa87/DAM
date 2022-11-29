package unitat5.u5_1_DescomposicioEnClassesIBiblioteques.reptes.repte4;

import java.util.Random;

/**
 * Repte 4. Modifiqueu el programa anterior per mostrar per pantalla dos valors reals aleatoris de manera que la
 * classe Random s’inicialitzi amb un paràmetre de tipus long. Aquest nou programa hauria de formar part d’un
 * package anomenat unitat5.apartat1.reptes. Executeu-lo diverses vegades. Quina és la diferència entre usar un
 * constructor o un altre en inicialitzar la classe?
 *
 * RESPOSTA:
 *      ·) fent servir el constructor que té el paràmetre d'entrada long, el resultat del random sempre és el mateix.
 *      ·) fent servir el constructor que no rep cap paràmetre d'entrada, el resultat del random varia cada vegada.
 */
public class RealsAleatorisLong {

    //Creates a new random number generator using a single long seed (seed és arrel).
    Random objecteRandom1 = new Random(10L);
    //Creates a new random number generator.
    Random objecteRandom2 = new Random();

    public static void main(String[] args) {
        RealsAleatorisLong programa = new RealsAleatorisLong();
        programa.inici();
    }
    public void inici() {
        System.out.println(objecteRandom1.nextDouble()*100);
        System.out.println(objecteRandom2.nextDouble()*100);
    }
}
