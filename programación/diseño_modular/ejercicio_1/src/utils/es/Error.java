package utils.es;

import utils.constants.ConstantsGeneric;

/**
 * Classe que conté el mètode per anunciar l'error.
 */
public class Error {

    //CONSTANT TITOL
    private static final String TITOL_ERROR = "❌ ERROR ❌";

    //CONSTANTS DECORACIÓ
    private static final String[] SEPARADOR_ERROR_PRIMER = {"(„• ֊ •„)", "/(￣_￣)\\"};
    private static final String[] SEPARADOR_ERROR_SEGON = {"ʘ︷ʘ", "ups", "ʘ︷ʘ"};

    /**
     * 1. Mètode per mostrar l'error quan aquest es produeix.
     * @param missatgeEspecific missatge d'error per informar a l'usuari del tipus d'error.
     */
    public static void mostrar(String missatgeEspecific) {
        Menu.mostrarTitol(TITOL_ERROR);
        CentrarStrings.imprimir(SEPARADOR_ERROR_PRIMER);
        System.out.println("");
        System.out.println(missatgeEspecific);
        System.out.println("");
        CentrarStrings.imprimir(SEPARADOR_ERROR_SEGON);
        Menu.imprimirGuions(ConstantsGeneric.SEPARADOR_FINAL);
        System.out.println("");
    }
}
