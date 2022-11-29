package unitat5.u5_1_DescomposicioEnClassesIBiblioteques.reptes.repte1;

/**
 * Repte 1. Feu un programa que, donats dos arrays de valors reals, us digui quin dels dos té el valor mitjà més alt.
 * Aprofiteu el principi de modularitat per fer-lo, de manera que la seva classe principal només tingui definits els
 * mètodes main i inici.
 */
public class ValorMitjaMesAlt {

    CalculsArrayReals objecte = new CalculsArrayReals();

    public static void main (String[] args) {
        ValorMitjaMesAlt programa = new ValorMitjaMesAlt();
        programa.inici();
    }

    public void inici(){
        double[] a = {1, 3, 2, 6};
        double[] b = {1, 1, 3, 1};
        if (objecte.calcularMitjana(a) > objecte.calcularMitjana(b)) {
            System.out.println("L'array a té la mitjana més alta");
        } else {
            System.out.println("L'array b té la mitjana més alta");
        }
    }
}
