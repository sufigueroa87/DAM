package utils.es;

import utils.vols.CercaVol;
import utils.vols.EnregistrarVol;
import utils.vols.MostrarVol;
import utils.vols.BorrarVol;
import utils.constants.ConstantsGeneric;

/**
 * Classe que conté els mètodes necessaris pel menú.
 */
public class Menu {

    //CONSTANTS MENU GENERAL
    private static final String MISSATGE_DEMANAR_OPCIO_MENU = "Quina opció del menú tries?";
    private static final String TITOL_INICIAL = "🔆 GESTIÓ VOLS AEROPORT 🔆";
    private static final String MENU_TEXT = """
        1. Enregistrar vol
        2. Mostrar vols enregistrats
        3. Esborrar vol
        4. Mostrar vol igual o posterior a l'hora introduïda a la ciutat
        5. Mostrar vol igual o posterior a l'hora introduïda a la ciutat i amb companyia
        0. Sortir
        Trieu una opció
        """;
    private static final String[] TITOLS_SELECCIO_MENU = {
            "🔆 FINALITZACIÓ 🔆",
            "🔆 ENREGISTRAR VOL 🔆",
            "🔆 VEURE VOLS 🔆",
            "🔆 ESBORRAR VOL 🔆",
            "🔆 MOSTRAR VOL HORA CIUTAT 🔆",
            "🔆 MOSTRAR VOL HORA CIUTAT COMPANYIA 🔆"
    };
    private static final int OPCIO_FINALITZACIO = 0;
    private static final int OPCIO_ENREGISTRAR_VOL = 1;
    private static final int OPCIO_VEURE_VOLS = 2;
    private static final int OPCIO_ESBORRAR_VOL = 3;
    private static final int OPCIO_TROBAR_VOL_CIUTAT = 4;
    private static final int OPCIO_TROBAR_VOL_CIUTAT_COMPANYIA = 5;

    //CONSTANTS DEMANAR STRING
    private static final String INTRODUEIX_LA_CIUTAT = "Introdueix la ciutat: ";
    private static final String INTRODUEIX_LA_COMPANYIA = "Introdueix la companyia: ";

    //CONSTANTS MISSATGES D'ERROR
    private static final String MISSATGE_ERROR_OPCIO_TRIADA_NO_DIGIT = "L'opció triada no és un dígit.";
    public static final String OPCIO_TRIADA_NO_ES_TROBA_AL_MENU = "L'opció triada no es troba al menú. Torna-hi.";

    //ATRIBUT dadesVols
    public static String[][] dadesVols = {
            {"08:30", "", ""}, {"09:00", "", ""}, {"09:30", "", ""}, {"10:00", "", ""},
            {"10:30", "", ""}, {"11:00", "", ""}, {"11:30", "", ""}, {"12:00", "", ""},
            {"12:30", "", ""}, {"13:00", "", ""}, {"13:30", "", ""}, {"14:00", "", ""},
            {"14:30", "", ""}, {"15:00", "", ""}, {"15:30", "", ""}, {"16:00", "", ""},
            {"16:30", "", ""}, {"17:00", "", ""}, {"17:30", "", ""}, {"18:00", "", ""},
            {"18:30", "", ""}, {"19:00", "", ""}, {"19:30", "", ""}, {"20:00", "", ""},
            {"20:30", "", ""}, {"21:00", "", ""}, {"21:30", "", ""}, {"22:00", "", ""},
            {"22:30", "", ""}, {"23:00", "", ""}
    };

    /**
     * 1. Mètode per mostrar menu.
     */
    public static void mostrarMenu() {
        mostrarTitol(TITOL_INICIAL);
        System.out.println(MENU_TEXT);
    }

    /**
     * 2. Mètode per triar una opció del menú.
     * @return true si l'opció triada es troba dins el menú.
     */
    public static int triarOpcioMenu() {
        boolean opcioTriadaOK = false;
        int opcioTriada = 0;
        while (!opcioTriadaOK) {
            System.out.println(MISSATGE_DEMANAR_OPCIO_MENU);
            try {
                opcioTriada = ConstantsGeneric.keyboard.nextInt();
                return opcioTriada;
            }
            catch (Exception e) {
                System.out.println(MISSATGE_ERROR_OPCIO_TRIADA_NO_DIGIT);
                ConstantsGeneric.keyboard.next();
            }
        }
        return -1;
    }

    /**
     * 3. Mètode per executar l'opció triada del menú.
     * @param opcioTriada opció triada del menú.
     */
    public static void executarOpcioMenu(int opcioTriada) {
        switch (opcioTriada) {
            case OPCIO_FINALITZACIO:
                opcioFinalitzacio();
                break;
            case OPCIO_ENREGISTRAR_VOL:
                opcioEnregistrarVol();
                break;
            case OPCIO_VEURE_VOLS:
                opcioVeureVols();
                break;
            case OPCIO_ESBORRAR_VOL:
                opcioEsborrarVol();
                break;
            case OPCIO_TROBAR_VOL_CIUTAT:
                opcioTrobarVolCiutat();
                break;
            case OPCIO_TROBAR_VOL_CIUTAT_COMPANYIA:
                opcioTrobarVolCiutatCompanyia();
                break;
            default:
                Error.mostrar(OPCIO_TRIADA_NO_ES_TROBA_AL_MENU);
        }
    }

    /**
     * 4. Mètode per mostrar el títol.
     * @param titolPantalla titol que volem mostrar per pantalla.
     */
    public static void mostrarTitol(String titolPantalla){
        String[] titol = {titolPantalla};
        imprimirGuions(ConstantsGeneric.SEPARADOR_INICI_NOU_TEMA);
        CentrarStrings.imprimir(titol);
    }

    /**
     * 4.1. Mètode per imprimir els guions.
     * @param simbol símbol que volem imprimir tantes vegades com fa l'amplada.
     */
    public static void imprimirGuions(String simbol){
        int comptadorGuio = 0;
        while (comptadorGuio < ConstantsGeneric.AMPLADA) {
            System.out.print(simbol);
            comptadorGuio++;
        }
        System.out.println("");
    }

    //MÈTODES PER CADA OPCIÓ DEL SWITCH
    /**
     * Mètode per finalitzar el programa
     */
    public static void opcioFinalitzacio(){
        mostrarTitol(TITOLS_SELECCIO_MENU[OPCIO_FINALITZACIO]);
        Finalitzacio.metodeFinalitzacio();
    }

    /**
     * Mètode per enregistrar vol
     */
    public static void opcioEnregistrarVol(){
        mostrarTitol(TITOLS_SELECCIO_MENU[OPCIO_ENREGISTRAR_VOL]);
        Hora.demanarHora();
        CercaVol.ciutatDesti = DemanarString.demanarString(INTRODUEIX_LA_CIUTAT, false);
        CercaVol.companyia = DemanarString.demanarString(INTRODUEIX_LA_COMPANYIA, false);
        int enregistrament = EnregistrarVol.enregistrarVol(dadesVols);
        if (enregistrament >= 0) {
            EnregistrarVol.comprovarEnregistramentCorrecte(dadesVols, ConstantsGeneric.cv);
        }
    }

    /**
     * Mètode per veure vols
     */
    public static void opcioVeureVols(){
        mostrarTitol(TITOLS_SELECCIO_MENU[OPCIO_VEURE_VOLS]);
        MostrarVol.mostrarVols(dadesVols);
    }

    /**
     * Mètode per esborrar vol
     */
    public static void opcioEsborrarVol(){
        mostrarTitol(TITOLS_SELECCIO_MENU[OPCIO_ESBORRAR_VOL]);
        BorrarVol.borrarVolSeleccionat(dadesVols);
    }

    /**
     * Mètode per trobar vol ciutat
     */
    public static void opcioTrobarVolCiutat(){
        mostrarTitol(TITOLS_SELECCIO_MENU[OPCIO_TROBAR_VOL_CIUTAT]);
        Hora.demanarHora();
        CercaVol.ciutatDesti = DemanarString.demanarString(INTRODUEIX_LA_CIUTAT, false);
        int posicioVolCiutat = CercaVol.cercarVol(ConstantsGeneric.cv, dadesVols);
        if (posicioVolCiutat != -1){
            MostrarVol.mostrarVol(posicioVolCiutat, dadesVols);
        }
    }

    /**
     * Mètode per trobar vol ciutat companyia
     */
    public static void opcioTrobarVolCiutatCompanyia(){
        mostrarTitol(TITOLS_SELECCIO_MENU[OPCIO_TROBAR_VOL_CIUTAT_COMPANYIA]);
        Hora.demanarHora();
        CercaVol.ciutatDesti = DemanarString.demanarString(INTRODUEIX_LA_CIUTAT, false);
        CercaVol.companyia = DemanarString.demanarString(INTRODUEIX_LA_COMPANYIA, false);
        int posicioVolCiutatCompanyia = CercaVol.cercarVol(ConstantsGeneric.cv, dadesVols);
        if (posicioVolCiutatCompanyia != -1){
            MostrarVol.mostrarVol(posicioVolCiutatCompanyia, dadesVols);
        }
    }
}