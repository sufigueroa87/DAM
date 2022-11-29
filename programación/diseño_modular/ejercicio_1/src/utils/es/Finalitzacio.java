package utils.es;

import utils.constants.ConstantsGeneric;

/**
 * Classe que conté el mètode per finalitzar el programa.
 */
public class Finalitzacio {

    //CONSTANT FINALITZAR PROGRAMA
    private static final String MISSATGE_FINALITZACIO = "Gràcies per fer servir l'aplicació. Fins aviat.";

    /**
     * 1. Mètode per finalitzar el programa.
     */
    public static void metodeFinalitzacio(){
        System.out.println(MISSATGE_FINALITZACIO);
        Menu.imprimirGuions(ConstantsGeneric.SEPARADOR_FINAL);
    }

}
