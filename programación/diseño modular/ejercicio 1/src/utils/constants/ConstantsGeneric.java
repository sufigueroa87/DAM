package utils.constants;

import utils.vols.CercaVol;

import java.util.Scanner;

/**
 * Constants que s'utilitzen en diversos mètodes del programa.
 */
public class ConstantsGeneric {

    //POSICIONS EN L'ARRAY DE VOLS
    public static final short POS_HORARI = 0;
    public static final short POS_DESTI = 1;
    public static final short POS_COMPANYIA = 2;

    //POSICIONS EN L'ARRAY DE L'HORA
    public static final short POS_QUINAHORA = 0;
    public static final short POS_QUINMINUT = 1;

    //OBJECTE DE LA CLASSE Scanner
    public static final Scanner keyboard = new Scanner(System.in);

    //OBJECTE DE LA CLASSE CercaVol
    public static final CercaVol cv = new CercaVol();

    //DECORACIÓ
    public static final String SEPARADOR_FINAL = "_";
    public static final String SEPARADOR_INICI_NOU_TEMA = "=";
    public static final String SEPARADOR_MOSTRAR_VOLS = "·";

    //AMPLADA
    public static final double AMPLADA = 80.0;

}
