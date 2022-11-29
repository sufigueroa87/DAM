package utils.es;

import utils.constants.ConstantsGeneric;

/**
 * Classe que conté els mètodes necessaris per només acceptar strings amb la sintaxi que volem.
 */
public class DemanarString {

    //CONSTANT ERROR
    private static final String MISSATGE_ERROR_NO_ALFABETIC = "La ciutat o la companyia només pot ser alfabètic.";

    /**
     * 1. Mètode que només accepta l'string si és alfabètic.
     * @param queVullBuscar string del qual vull saber si la sintaxi és correcte.
     * @param esAlfabetic boolean que s'inicia com a false, per poder entrar en el bucle while.
     * @return retorna l'string amb la sintaxi correcte.
     */
    public static String demanarString(String queVullBuscar, boolean esAlfabetic) {
        String stringResposta = "";
        while (!esAlfabetic) {
            System.out.println(queVullBuscar);
            stringResposta = ConstantsGeneric.keyboard.next().trim().toUpperCase();
            if (!stringResposta.chars().allMatch(Character::isAlphabetic)) {
                Error.mostrar(MISSATGE_ERROR_NO_ALFABETIC);
            } else {
                esAlfabetic = true;
            }
        }
        return stringResposta;
    }
}
