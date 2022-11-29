package utils.vols;

import utils.constants.ConstantsGeneric;
import utils.es.Error;
import utils.es.Felicitats;
import utils.es.Hora;

/**
 * Classe que conté els mètodes relacionats amb la cerca del vol.
 */
public class CercaVol {

    //CONSTANT ERROR
    private static final String MISSATGE_ERROR_NO_TROBA_VOL = "No hi ha cap vol a l'hora introduïda o posterior.";

    //CONSTANT FELICITATS
    private static final String MISSATGE_SHA_TROBAT_EL_VOL = "Felicitats, s'ha trobat el vol.";

    //ATRIBUTS DE LA CLASSE CercaVol
    public static String horaCerca;
    public static String ciutatDesti;
    public static String companyia;

    /**
     * 1. Mètode per resetejar els valors de horaCerca, ciutatDesti i companyia de la classe CercaVol
     * @param h string de l'hora introduïda
     * @param ciutat string de la ciutat introduïda
     * @param comp string de la companyia introduïda
     */
    public static void inicialitzaCercaVol(String h, String ciutat, String comp) {
        horaCerca = h;
        ciutatDesti = ciutat;
        companyia = comp;
    }

    /**
     * 2. Mètode per cercar els vols.
     * @param cVol Objecte de la classe que conté els valors dels atributs horaCerca, ciutatDesti i companyia.
     * @param dadesVols array de vols.
     * @return posició on es troba el vol
     */
    public static int cercarVol(CercaVol cVol, String[][] dadesVols) {
        int pos = -1;
        if (!horaCerca.equals("") && !ciutatDesti.equals("") && companyia.equals("")) {
            pos = primerVolCiutat(cVol, dadesVols);
        }
        if (!horaCerca.equals("") && !ciutatDesti.equals("") && !companyia.equals("")) {
            pos = primerVolCiutatCompanyia(cVol, dadesVols);
        }
        return pos;
    }
    /**
     * 2.1. Mètode per saber la posició del vol trobat.
     * @param dadesVols array de vols.
     * @return si troba el vol, retorna la posició. Si no el troba, retorna -1.
     */
    public static int cercaPosVol(String[ ] [ ] dadesVols) {
        return trobaStringDeterminatEnLArray(CercaVol.horaCerca, dadesVols, ConstantsGeneric.POS_HORARI);
    }

    /**
     * 2.1.1. Mètode que troba l'string en un array.
     * @param stringABuscar string que vull buscar en l'array.
     * @param dadesVols array on vull buscar l'string.
     * @param tipusQueVullBuscar tipus de dada que vull buscar en l'array.
     * @return si troba, retorna la posició on es troba. Si no troba, retorna -1.
     */
    public static int trobaStringDeterminatEnLArray(String stringABuscar, String[][] dadesVols, int tipusQueVullBuscar){
        boolean trobat = false;
        int pos = 0;
        while (!trobat && pos < dadesVols.length){
            trobat = dadesVols[pos][tipusQueVullBuscar].equalsIgnoreCase(stringABuscar);
            pos++;
        }
        if (trobat) {
            return pos-1;
        } else {
            return -1;
        }
    }

    /**
     * 3. Mètode per cercar el primerVolCiutatCompanyia.
     * @param cVol objecte de la classe CercaVol que conté els valors de ciutatDesti i companyia.
     * @param dadesVols array de vols.
     * @return posició del vol. Si no troba el vol, retorna -1.
     */
    public static int primerVolCiutatCompanyia(CercaVol cVol, String[][] dadesVols){
        int pos = 0;
        while (pos < dadesVols.length) {
            if ((dadesVols[pos][ConstantsGeneric.POS_DESTI].equals(cVol.ciutatDesti))
                    && (dadesVols[pos][ConstantsGeneric.POS_COMPANYIA].equals(cVol.companyia))
                    && (Hora.horaDonadaInferiorOIgual(dadesVols[pos][ConstantsGeneric.POS_HORARI]))) {
                Felicitats.mostrar(MISSATGE_SHA_TROBAT_EL_VOL);
                return pos;
            }
            pos++;
        }
        Error.mostrar(MISSATGE_ERROR_NO_TROBA_VOL);
        return -1;
    }

    /**
     * 4. Mètode per cercar el primerVolCiutat
     * @param cVol objecte de la classe CercaVol que conté els valors de ciutatDesti.
     * @param dadesVols array de vols.
     * @return posició del vol. Si no troba el vol, retorna -1.
     */
    public static int primerVolCiutat(CercaVol cVol, String[][] dadesVols){
        int posicioCiutat = 0;
        while (posicioCiutat < dadesVols.length) {
            if ((dadesVols[posicioCiutat][ConstantsGeneric.POS_DESTI].equals(cVol.ciutatDesti))
                    && (Hora.horaDonadaInferiorOIgual(dadesVols[posicioCiutat][ConstantsGeneric.POS_HORARI]))) {
                Felicitats.mostrar(MISSATGE_SHA_TROBAT_EL_VOL);
                return posicioCiutat;
            }
            posicioCiutat++;
        }
        Error.mostrar(MISSATGE_ERROR_NO_TROBA_VOL);
        return -1;
    }
}
