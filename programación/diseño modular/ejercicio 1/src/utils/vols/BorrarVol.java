package utils.vols;

import utils.constants.ConstantsGeneric;
import utils.es.Error;
import utils.es.Felicitats;
import utils.es.Hora;

/**
 * Classe que conté el mètode per esborrar el vol.
 */
public class BorrarVol {

    //CONSTANT ERROR
    private static final String MISSATGE_ERROR_NO_TROBA_VOL_DE_LHORA = "No es pot borrar ja que cap vol coincideix.";

    //CONSTANT FELICITATS
    private static final String MISSATGE_ES_POT_ESBORRAR_EL_VOL = "Es procedeix a borrar el vol.";

    /**
     * 1. Mètode per esborrar el vol seleccionat.
     * @param dadesVols array on es troben tots els vols.
     */
    public static void borrarVolSeleccionat(String[][] dadesVols){
        Hora.demanarHora();
        int posVol = CercaVol.cercaPosVol(dadesVols);
        if (posVol != -1) {
            Felicitats.mostrar(MISSATGE_ES_POT_ESBORRAR_EL_VOL);
            dadesVols[posVol][ConstantsGeneric.POS_DESTI] = "";
            dadesVols[posVol][ConstantsGeneric.POS_COMPANYIA] = "";
        } else {
            Error.mostrar(MISSATGE_ERROR_NO_TROBA_VOL_DE_LHORA);
        }
    }
}
