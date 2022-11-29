package utils.vols;

import utils.constants.ConstantsGeneric;
import utils.es.Error;
import utils.es.Felicitats;
import utils.es.Menu;
import java.util.Arrays;

/**
 * Classe que conté els mètodes per enregistrar vol.
 */
public class EnregistrarVol {

    //CONSTANT ERROR
    public static final String ENREGISTRAMENT_FALLIT = "L'enregistrament no s'ha produït.";
    public static final String ARRAY_PLE = "Operació cancelada. Ja hi ha un vol registrat en aquest horari. Primer cal borrar-lo.";

    //CONSTANT OK
    public static final String ENREGISTRAMENT_OK = "L'enregistrament s'ha realitzat amb èxit.";
    public static final String ARRAY_BUIT = "No hi ha dades inserides en aquest horari. Es poden inserir les dades.";

    /**
     * 1. Mètode per enregistrar el vol.
     * @param dadesVols array que conté els vols.
     * @return si s'ha enregistrat, retorna la posició del vol on s'ha registrat. si no, retorna -1.
     */
    public static int enregistrarVol(String[ ][ ] dadesVols){
        int posVol = -1;
        posVol=CercaVol.cercaPosVol(dadesVols);
        if(posVol==-1){
            System.out.println("No es troba l'hora en l'array de vols.");
        }
        if(posVol>=0 && comprovarArrayBuit()){
            enregistrarDadesVol(posVol, ConstantsGeneric.cv, dadesVols);
        }
        return posVol;
    }


    /**
     * 1.1. Mètode per afegir l'aeroport de destí i la companyia del vol a l'array de vols
     * @param posVol posició on volem registrar el vol.
     * @param cVol valors que volem registrar de ciutatDesti i companyia.
     * @param dadesVols array on volem fer el registre del vol.
     */
    public static void enregistrarDadesVol(int posVol, CercaVol cVol, String[ ][ ] dadesVols) {
        dadesVols[posVol][ConstantsGeneric.POS_DESTI] = cVol.ciutatDesti;
        dadesVols[posVol][ConstantsGeneric.POS_COMPANYIA] = cVol.companyia;
    }

    /**
     * 2. Mètode per comprovar que l'array està buit.
     * @return true si l'array està buit. false si l'array és ple.
     */
    public static boolean comprovarArrayBuit(){
        int posVol=CercaVol.cercaPosVol(Menu.dadesVols);
        if (Menu.dadesVols[posVol][ConstantsGeneric.POS_DESTI].equals("") && Menu.dadesVols[posVol][ConstantsGeneric.POS_COMPANYIA].equals("")){
            System.out.println(ARRAY_BUIT);
            return true;
        } else {
            System.out.println(ARRAY_PLE);
            return false;
        }
    }

    /**
     * 3. Mètode per comprovar que l'enregistrament s'ha produït correctament.
     * @param dadesVols array on es troben els vols.
     * @param cVol objecte de la classe CercaVol que conté els valors horaCerca, ciutatDesti i companyia.
     */
    public static void comprovarEnregistramentCorrecte(String[][] dadesVols, CercaVol cVol){
        String[] arrayModel = {cVol.horaCerca, cVol.ciutatDesti, cVol.companyia};

        if (Arrays.equals(arrayModel, dadesVols[CercaVol.cercaPosVol(dadesVols)])) {
            Felicitats.mostrar(ENREGISTRAMENT_OK);
        } else {
            Error.mostrar(ENREGISTRAMENT_FALLIT);
        }
    }
}
