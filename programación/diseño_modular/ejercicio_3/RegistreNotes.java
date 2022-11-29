package unitat5.u5_1_DescomposicioEnClassesIBiblioteques.reptes.repte2;
/**
 * Repte 2. Genereu un projecte en el vostre IDE amb un package anomenat unitat5.apartat1.repte2. Feu que dins d’aquest
 * package s’incloguin les classes de l’exemple del registre de les notes i executeu-lo, comprovant que funciona
 * correctament.
 */
public class RegistreNotes {

    CalculsArrayReals objecte = new CalculsArrayReals();

    public static void main(String[] args) {
        unitat5.u5_1_DescomposicioEnClassesIBiblioteques.exemples.exemple1.RegistreNotes programa = new unitat5.u5_1_DescomposicioEnClassesIBiblioteques.exemples.exemple1.RegistreNotes();//instancio la classe per poder fer servir els seus mètodes
        programa.inici();
    }
    public void inici() {
        double[] notes = {2.0, 5.5, 7.25, 3.0, 9.5, 8.25, 7.0, 7.5};
        double max = objecte.calcularMaxim(notes);
        double min = objecte.calcularMinim(notes);
        double mitjana = objecte.calcularMitjana(notes);
        System.out.println("La nota màxima és " + max + ".");
        System.out.println("La nota mínima és " + min + ".");
        System.out.println("La mitjana de les notes és " + mitjana + ".");
    }

    /**
     * Veig que aquest mètode ja no es fa servir en aquesta classe.
     */
    public double calcularMaxim(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Veig que aquest mètode ja no es fa servir en aquesta classe.
     */
    public double calcularMinim(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Veig que aquest mètode ja no es fa servir en aquesta classe.
     */
    public double calcularMitjana(double[] array) {
        double suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma = suma + array[i];
        }
        return suma/array.length;
    }
}