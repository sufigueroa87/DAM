package unitat6.u6_1_GestioFitxers.reptes.repte1;

import java.util.Scanner;
import java.io.File;

// Repte 1. Creeu un programa que llegeixi un text pel teclat corresponent a la ruta d’un fitxer existent al vostre
// ordinador. Canvieu el nom d’aquest fitxer de manera que s’elimini la seva extensió, si en té (per exemple, si el
// fitxer es diu “Document.txt”, passarà a dir-se “Document”). Per dur a terme aquesta tasca haureu de fer memòria
// de les transformacions sobre cadenes de text.

public class TransformaNomFitxer {

    Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){
        TransformaNomFitxer programa = new TransformaNomFitxer();
        programa.inici();
    }

    public void inici(){
        modificacioNomArxiuUNIX();
    }

    public void modificacioNomArxiuUNIX(){
        System.out.println("Introdueix la ruta on es troba l'arxiu al que vol canviar el nom.");
        String nomArxiuRuta = keyboard.next();
        File rutaArxiu = new File(nomArxiuRuta);
        if (rutaArxiu.exists() && rutaArxiu.isFile()){
            System.out.println("L'arxiu existeix.");
            //per reanomenar l'arxiu, agafaré el nom de l'arxiu i amb split separaré en dos
            String nomArxiuInicial = rutaArxiu.getName();
            String[] separacioSplit = nomArxiuInicial.split("[.]");
            //el nom que vull que tingui la ruta de l'arxiu ara és:
            String nouNomRuta = rutaArxiu.getParent() + File.separator + separacioSplit[0];
            System.out.println("La ruta nova és: " + nouNomRuta);
            File rutaCanviNom = new File(nouNomRuta);
            //ara només cal canviar el nom:
            boolean canviNomCorrecte = rutaArxiu.renameTo(rutaCanviNom);
            if (canviNomCorrecte && rutaCanviNom.exists()){
                System.out.println("S'ha realitzat el canvi de nom de l'arxiu correctament.");
            }
        } else {
            System.out.println("No existeix l'arxiu.");
        }
    }
}
