package utils.vols;

import utils.constants.ConstantsGeneric;
import utils.es.CentrarStrings;
import utils.es.Menu;

/**
 * Classe que conté els mètodes per mostrar el vol o els vols.
 */
public class MostrarVol {

    //CONSTANTS TITOLS
    private static final String TITOL_MOSTRAR_VOL = "🔆 MOSTRAR VOL 🔆";
    private static final String[] TITOLS_VEURE_VOLS = {"HORARI", "DESTINACIÓ", "COMPANYIA"};


    /**
     * 1. Mètode per mostrar els vols registrats.
     * @param dadesVols array que conté els vols.
     */
    public static void mostrarVols(String[][] dadesVols) {
        CentrarStrings.imprimir(TITOLS_VEURE_VOLS);
        for (int i = 0; i < dadesVols.length; i++) {
            CentrarStrings.imprimir(new String[] {
                    dadesVols[i][ConstantsGeneric.POS_HORARI],
                    dadesVols[i][ConstantsGeneric.POS_DESTI],
                    dadesVols[i][ConstantsGeneric.POS_COMPANYIA]
            });
        }
    }

    /**
     * 2. Mètode per mostrar el vol.
     * @param posicio on es troba el vol trobat.
     * @param dadesVols array que conté els vols registrats.
     */
    public static void mostrarVol(int posicio, String[][] dadesVols) {
        Menu.mostrarTitol(TITOL_MOSTRAR_VOL);
        CentrarStrings.imprimir(TITOLS_VEURE_VOLS);
        Menu.imprimirGuions(ConstantsGeneric.SEPARADOR_MOSTRAR_VOLS);
        CentrarStrings.imprimir(new String[] {
                dadesVols[posicio][ConstantsGeneric.POS_HORARI],
                dadesVols[posicio][ConstantsGeneric.POS_DESTI],
                dadesVols[posicio][ConstantsGeneric.POS_COMPANYIA]
        });
        Menu.imprimirGuions(ConstantsGeneric.SEPARADOR_FINAL);
    }
}
