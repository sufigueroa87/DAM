package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.LeerArchivosDatos_ImprimirVocalesRegex;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ImprimirVocalesRegex {

    public static void main(String[] args){
        ImprimirVocalesRegex programa = new ImprimirVocalesRegex();
        programa.inici();
    }

    public void inici(){
        FileReader fr = crearObjetoFileReader("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/LeerArchivosDatos_ImprimirVocalesRegex/buscarVocales.txt");
        File f = crearObjetoFile("src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/LeerArchivosDatos_ImprimirVocalesRegex/buscarVocales.txt");
        imprimirVocalesFile(f, fr);
    }

    public void imprimirVocalesFile(File f, FileReader fr){
        for(int i = 0; i <= f.length(); i++){
            try{
                char valor = (char)fr.read();
                String valorString = valor+"";
                String valorMinuscula = valorString.toLowerCase();
                if(Pattern.matches("[aeiou]", valorMinuscula)){
                    System.out.println(valorMinuscula);
                }
            }
            catch(IOException e){
                System.out.println("Problemas con el archivo.");
            }
        }
    }

    public FileReader crearObjetoFileReader(String ruta){
        FileReader fr = null;
        try{
            fr = new FileReader(ruta);
        }
        catch(IOException e) {
            System.err.println("Problemas con el archivo.");
        }
        return fr;
    }

    public File crearObjetoFile(String ruta){
        File f = new File(ruta);
        return f;
    }

}
