package utils.es;

import utils.constants.ConstantsGeneric;

/**
 * Classe que conté el mètode per anunciar l'acció correcte.
 */
public class Felicitats {

    //CONSTANT TITOL
    private static final String TITOL_FELICITATS = "⭐ ⍣ FELICITATS ⍣ ⭐";

    //CONSTANTS DECORACIÓ
    private static final String[] SEPARADOR_FELICITATS_PRIMER = {"＼(^o^)／", "☆<(￣︶￣)>☆", "＼(^o^)／"};
    private static final String[] SEPARADOR_FELICITATS_SEGON = {"＼(^o^)／", "＼(^o^)／"};

    /**
     * 1. Mètode per mostrar felicitats quan el resultat d'una acció és correcte.
     * @param missatgeEspecific missatge de felicitats per informar a l'usuari que és correcte l'acció feta.
     */
    public static void mostrar(String missatgeEspecific) {
        Menu.mostrarTitol(TITOL_FELICITATS);
        CentrarStrings.imprimir(SEPARADOR_FELICITATS_PRIMER);
        System.out.println("");
        System.out.println(missatgeEspecific);
        System.out.println("");
        CentrarStrings.imprimir(SEPARADOR_FELICITATS_SEGON);
        Menu.imprimirGuions(ConstantsGeneric.SEPARADOR_FINAL);
        System.out.println("");
    }
}
