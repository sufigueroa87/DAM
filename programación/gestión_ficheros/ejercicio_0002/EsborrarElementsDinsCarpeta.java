package unitat6.u6_1_GestioFitxers.reptes.repte2;
// Repte 2. Realitzeu un programa que llegeixi des del teclat el text associat a la ruta a una carpeta existent
// dins del vostre ordinador.
// Esborrar tots els elements que hi ha dins, independentment que siguin fitxers o
// carpetes.
// Tingueu en compte que per poder eliminar una carpeta cal abans buidar-la de tot el seu contingut
// (en la qual hi pot haver alhora tant fitxers o carpetes… i així indefinidament fins a arribar a una carpeta que
// només té fitxers). Pista: Per resoldre aquest problema és molt més senzill plantejar una solució recursiva.

import java.util.Scanner;
import java.io.File;

public class EsborrarElementsDinsCarpeta {

    Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args){
        EsborrarElementsDinsCarpeta programa = new EsborrarElementsDinsCarpeta();
        programa.inici();
    }

    public void inici(){
        File ruta = demanarRuta();
        boolean existeix = comprovarRutaExisteix(ruta);
        boolean esDirectori = comprovarEsDirectori(ruta);
        if (existeix && esDirectori){
            System.out.println("La ruta existeix i és un directori.");
            esborrarRecursivamentInteriorCarpeta(ruta);
        } else {
            System.out.println("La ruta no existeix o no és un directori.");
        }
    }

    //mètode demanar introduïr per teclat ruta
    //  mirar si existeix la ruta
    public File demanarRuta(){
        System.out.println("Introdueix la ruta del directori: ");
        String rutaIntroduidaUsuari = keyboard.next();
        //creo objecte de la classe File que tingui de valor aquesta ruta
        File rutaFinal = new File(rutaIntroduidaUsuari);
        return rutaFinal;
    }

    public boolean comprovarRutaExisteix(File ruta){
        return ruta.exists();
    }

    public boolean comprovarEsDirectori(File ruta){
        return ruta.isDirectory();
    }

    //mètode per esborrar tot el que hi ha dins la carpeta
    public void esborrarRecursivamentInteriorCarpeta(File ruta){
        //haig de mirar tots els elements i anar borrant-los tots
        File[] elementsDinsLaCarpeta = ruta.listFiles();
        for (int i = 0; i < elementsDinsLaCarpeta.length; i++){
            //si és fitxer s'esborra
            if (elementsDinsLaCarpeta[i].isFile()){
                elementsDinsLaCarpeta[i].delete();
            //si és carpeta primer cal buidar-la abans de poder-la esborrar
            } else if (elementsDinsLaCarpeta[i].isDirectory()) {
                //invoco el mateix mètode per esborrar primer els fitxers i després borrarà la carpeta
                esborrarRecursivamentInteriorCarpeta(elementsDinsLaCarpeta[i]);
                //ara borra la carpeta ja que està buida de fitxers
                elementsDinsLaCarpeta[i].delete();
            }
        }
    }

    //comprovar que la carpeta és buida
    public void esborratCorrecte(File ruta){
        //recorro tota la carpeta mirant tots els elements que conté
        File[] elementsDinsLaCarpeta = ruta.listFiles();
        if (elementsDinsLaCarpeta.length == 0){
            System.out.println("El contingut de la carpeta s'ha esborrat correctament.");
        } else {
            System.out.println("El contingut de la carpeta no s'ha esborrat correctament.");
        }
    }
}
