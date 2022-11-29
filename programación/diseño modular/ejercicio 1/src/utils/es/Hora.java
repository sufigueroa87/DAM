package utils.es;

import utils.constants.ConstantsGeneric;
import utils.vols.CercaVol;

/**
 * Classe que conté tots els mètodes del programa relacionats amb l'hora.
 */
public class Hora {

    //CONSTANT PETICIÓ HORA
    public static final String INTRODUEIX_LHORA = "Introdueix l'hora: ";

    //CONSTANTS ERROR HORA
    private static final String MISSATGE_ERROR_HORA_FALTEN_DOS_PUNTS = "L'hora introduïda no té el caràcter ':'.";
    private static final String MISSATGE_ERROR_HORA_EXCES_DOS_PUNTS = "L'hora introduïda conté massa vegades ':'.";
    private static final String MISSATGE_ERROR_HORA_NO_HI_HA_DOS_ELEMENTS = "En l'hora introduïda no hi ha dos elements.";
    private static final String MISSATGE_ERROR_HORA_NO_ES_DIGIT = "L'hora introduïda no és un dígit.";
    private static final String MISSATGE_ERROR_MINUTS_NO_ES_DIGIT = "Els minuts introduïts no són un dígit.";
    private static final String MISSATGE_ERROR_RANG_HORA_INCORRECTE = "L'hora ha de ser de 0 a 23 i els minuts de 0 a 59.";
    private static final String MISSATGE_ERROR_RANG_MINUTS_INCORRECTE = "Els minuts han d'estar entre 0 i 59.";

    /**
     * 1. Mètode per obtenir l'hora amb la sintaxi correcte.
     * Només si la sintaxi de l'hora és correcte, el valor s'introdueix en la variable CercaVol.hora.
     */
    public static void demanarHora() {
        //cada vegada que demano hora resetejo els valors dels atributs de CercaVol
        CercaVol.inicialitzaCercaVol("", "", "");
        boolean sintaxiHoraCorrecte = false;
        String hora = "";
        while(!sintaxiHoraCorrecte) {
            System.out.println(INTRODUEIX_LHORA);
            hora = ConstantsGeneric.keyboard.next();
            if (!comprovaDosPunts(hora)
                    || !comprovaDosElements(hora)
                    || !comprovaQueElsValorsDeLhoraSonNomesNumeros(hora)
                    || !comprovaQueLHoraIElsMinutsEstanEnElRang(hora)) {
            } else {
                //quan l'hora és correcte l'afegeixo a CercaVol.horaCerca
                CercaVol.horaCerca = hora.trim();
                sintaxiHoraCorrecte = true;
            }
        }
    }

    /**
     * 1.1. Mètode per saber si l'string de l'hora conté una vegada ':'.
     * @param hora String de l'hora introduïda.
     * @return true si l'String de l'hora conté una vegada ':'.
     */
    public static boolean comprovaDosPunts(String hora){
        int count = 0;
        for (int i = 0 ; i < hora.length(); i++) {
            if (hora.charAt(i) == ':') {
                count++;
            }
        }
        if (count == 0) {
            Error.mostrar(MISSATGE_ERROR_HORA_FALTEN_DOS_PUNTS);
            return false;
        } else if (count > 1) {
            Error.mostrar(MISSATGE_ERROR_HORA_EXCES_DOS_PUNTS);
            return false;
        }
        return true;
    }

    /**
     * 1.2. Mètode per comprovar que hi ha dos elements a cada costat del ':'.
     * @param hora String de l'hora introduïda.
     * @return true si l'hora introduïda conté 2 elements, un a cada costat del ':'.
     */
    public static boolean comprovaDosElements(String hora) {
        if (dividirStringSeparatPerCaracterSplit(hora).length < 2) {
            Error.mostrar(MISSATGE_ERROR_HORA_NO_HI_HA_DOS_ELEMENTS);
            return false;
        }
        return true;
    }

    /**
     * 1.3. Mètode per comprovar que al costat dels ':' hi ha dígits.
     * @param hora String de l'hora introduïda.
     * @return true si els elements que hi ha al costat del ':' són dígits.
     */
    public static boolean comprovaQueElsValorsDeLhoraSonNomesNumeros(String hora) {
        String[] horesSeparadesDelsMinuts = dividirStringSeparatPerCaracterSplit(hora);
        int pos = 0;
        while (pos < horesSeparadesDelsMinuts.length) {
            if (!horesSeparadesDelsMinuts[ConstantsGeneric.POS_QUINAHORA].chars().allMatch(Character::isDigit)) {
                Error.mostrar(MISSATGE_ERROR_HORA_NO_ES_DIGIT);
                return false;
            }
            if (!horesSeparadesDelsMinuts[ConstantsGeneric.POS_QUINMINUT].chars().allMatch(Character::isDigit)) {
                Error.mostrar(MISSATGE_ERROR_MINUTS_NO_ES_DIGIT);
                return false;
            }
            pos++;
        }
        return true;
    }

    /**
     * 1.4. Mètode per comprovar que els dígits del costat del ':' estan dins el rang que volem.
     * @param hora String de l'hora introduïda.
     * @return true si els dígits a cada costat del ':' estan en el rang adequat.
     */
    public static boolean comprovaQueLHoraIElsMinutsEstanEnElRang(String hora) {
        int[] horesSeparadesDelsMinuts = convertirStringEnArrayDIntegersSplit(hora);
        if (horesSeparadesDelsMinuts[ConstantsGeneric.POS_QUINAHORA] < 0 || horesSeparadesDelsMinuts[ConstantsGeneric.POS_QUINAHORA] > 23) {
            Error.mostrar(MISSATGE_ERROR_RANG_HORA_INCORRECTE);
            return false;
        }
        if (horesSeparadesDelsMinuts[ConstantsGeneric.POS_QUINMINUT] < 0 || horesSeparadesDelsMinuts[ConstantsGeneric.POS_QUINMINUT] > 59) {
            Error.mostrar(MISSATGE_ERROR_RANG_MINUTS_INCORRECTE);
            return false;
        }
        return true;
    }


    /**
     * 2. Mètode per convertir l'string hora en un array de dos integers
     * @param hora String de l'hora introduïda.
     * @return array de dos integers que conté les hores i els minuts de l'hora introduïda.
     */
    public static int[] convertirStringEnArrayDIntegersSplit(String hora){
        String[] convertirAInt = dividirStringSeparatPerCaracterSplit(hora);
        int[] convertitAInt = new int[convertirAInt.length];
        for (int i = 0; i < convertirAInt.length; i++){
            convertitAInt[i] = Integer.parseInt(convertirAInt[i]);
        }
        return convertitAInt;
    }

    /**
     * 2.1. Mètode per separar l'string de l'hora introduïda en hores i minuts
     * @param hora String de l'hora introduïda.
     * @return array de dos strings
     */
    public static String[] dividirStringSeparatPerCaracterSplit(String hora){
        String[] arraySubstring = hora.split(":");
        return arraySubstring;
    }


    /**
     * 3. Mètode per saber si l'hora introduïda és inferior o igual a l'hora trobada en l'array
     * @param horaTrobadaALArray hora trobada a l'array.
     * @return true si l'hora introduïda és inferior o igual a l'hora trobada en l'array
     */
    public static boolean horaDonadaInferiorOIgual(String horaTrobadaALArray){
        int[] horaDonadaInteger = convertirStringEnArrayDIntegersSplit(CercaVol.horaCerca);
        int[] horaTrobadaALArrayInteger = convertirStringEnArrayDIntegersSplit(horaTrobadaALArray);
        if (horaDonadaInteger[ConstantsGeneric.POS_QUINAHORA] > horaTrobadaALArrayInteger[ConstantsGeneric.POS_QUINAHORA]) {
            return false;
        }
        if (horaDonadaInteger[ConstantsGeneric.POS_QUINAHORA] == horaTrobadaALArrayInteger[ConstantsGeneric.POS_QUINAHORA]
                && horaDonadaInteger[ConstantsGeneric.POS_QUINMINUT] > horaTrobadaALArrayInteger[ConstantsGeneric.POS_QUINMINUT]) {
            return false;
        }
        return true;
    }
}
