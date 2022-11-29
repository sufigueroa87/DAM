package utils.es;

import utils.constants.ConstantsGeneric;

/**
 * Classe que conté els mètodes necessaris per imprimir strings centrats en la pantalla.
 */
public class CentrarStrings {

    /**
     * 1. Mètode per imprimir els strings de manera centrada en la pantalla.
     * @param valorsAImprimir array de tipus String que conté els strings a imprimir.
     */
    public static void imprimir(String[] valorsAImprimir){
        int comptadorEspaisEnBlanc = 0;
        System.out.println("");
        for (int i = 0; i < valorsAImprimir.length; i++){
            while (comptadorEspaisEnBlanc < colocarStringsFinal(valorsAImprimir)[i]){
                System.out.print(" ");
                comptadorEspaisEnBlanc++;
            }
            System.out.print(valorsAImprimir[i]);
            comptadorEspaisEnBlanc = 0;
        }
        System.out.println("");
        System.out.println("");
    }

    /**
     * 1.1. Mètode per calcular els espais entre els strings que es volen imprimir centrats en la pantalla.
     * @param valorsAImprimir array de tipus String que conté els strings a imprimir.
     * @return array de tipus double amb la localització x inicial dels strings que es volen imprimir.
     */
    public static double[] colocarStringsFinal(String[] valorsAImprimir){
        double[] localitzacioTitolsFinal = new double[valorsAImprimir.length];
        for (int i = 0; i < valorsAImprimir.length; i++){
            double espaisARestar = valorsAImprimir[i].length()/2.0;
            if (i == 0){
                localitzacioTitolsFinal[i] = colocarStringsInicial(valorsAImprimir)[i] - espaisARestar;
            } else {
                localitzacioTitolsFinal[i] = colocarStringsInicial(valorsAImprimir)[i] -
                        colocarStringsInicial(valorsAImprimir)[i-1] - espaisARestar - valorsAImprimir[i-1].length()/2;
            }
        }
        return localitzacioTitolsFinal;
    }

    /**
     * 1.1.1. Mètode per calcular el lloc de col·locació central dels strings que es volen imprimir en la pantalla.
     * @param valorsAImprimir array de tipus String que conté els strings a imprimir.
     * @return array de tipus double amb la localització x central dels strings que es volen imprimir.
     */
    public static double[] colocarStringsInicial(String[] valorsAImprimir){
        int quantitatDivisions = valorsAImprimir.length + 1;
        double espaiEntreTitols = ConstantsGeneric.AMPLADA / quantitatDivisions;
        double[] localitzacioTitolsInicial = new double[quantitatDivisions-1];
        for (int i = 1; i < quantitatDivisions; i++) {
            localitzacioTitolsInicial[i-1] = espaiEntreTitols * i;
        }
        return localitzacioTitolsInicial;
    }

}
