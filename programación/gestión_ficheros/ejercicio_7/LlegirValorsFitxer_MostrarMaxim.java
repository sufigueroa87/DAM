package unitat6.u6_2_TractamentBasicDades.reptes.repte1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LlegirValorsFitxer_MostrarMaxim {

    public static void main(String[] args){
        LlegirValorsFitxer_MostrarMaxim programa = new LlegirValorsFitxer_MostrarMaxim();
        programa.inici();
    }

    public void inici(){
        System.out.println(valorMesGran("src/unitat6/u6_2_TractamentBasicDades/reptes/repte1/Reals.txt"));
    }

    public double valorMesGran(String ruta){
        double valorMesGran = 0.0;
        File f = crearObjecteFile(ruta);
        try{
            Scanner llegirFitxer = new Scanner(f);
            while(llegirFitxer.hasNext()){
                double valor = llegirFitxer.nextDouble();
                if(valor > valorMesGran){
                    valorMesGran = valor;
                }
            }
            llegirFitxer.close();
        }
        catch (IOException e){
            System.err.println("Problemes lectura fitxer.");
        }
        return valorMesGran;
    }

    public File crearObjecteFile(String ruta){
        File f = new File(ruta);
        return f;
    }
}
