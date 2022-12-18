package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.LeerArchivosDatos_ImprimirCadenasArchivoScanner;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ImprimirCadenasArchivoScanner {

    public static void main(String[] args){
        ImprimirCadenasArchivoScanner programa = new ImprimirCadenasArchivoScanner();
        programa.inici();
    }

    public void inici(){
        File f = new File(System.getProperty("user.dir") + File.separator + "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/LeerArchivosDatos_ImprimirCadenasArchivoScanner/imprimirCadenas.txt");
        imprimirCadenasFile(f);
    }

    public void imprimirCadenasFile(File f){
        if (existeFile(f)){
            try{
                Scanner keyboard = new Scanner(f);
                while (keyboard.hasNext()){
                    String cadena = keyboard.next();
                    System.out.println(cadena);
                }
            }
            catch (IOException e){
                System.err.println("Problemas con el archivo.");
            }
        } else {
            System.out.println("No existe el archivo.");
        }
    }

    public boolean existeFile(File f){
        boolean existe = false;
        if (f.exists()){
            existe = true;
        }
        return existe;
    }
}