package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.LeerArchivosDatos_ImprimirCaracteresArchivoFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivosDatos_ImprimirCaracteresArchivoFileReader {

    public static void main(String[] args){
        LeerArchivosDatos_ImprimirCaracteresArchivoFileReader programa = new LeerArchivosDatos_ImprimirCaracteresArchivoFileReader();
        programa.inici();
    }

    public void inici(){
        imprimirCaracteresArchivoFileReader(System.getProperty("user.dir") + File.separator + "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/LeerArchivosDatos_ImprimirCaracteresArchivoFileReader/lecturaCaracteresPorSeparado.txt");
    }

    public void imprimirCaracteresArchivoFileReader(String ruta){
        FileReader fr = creacionObjetoFileReader(ruta);
        File f = creacionObjetoFile(ruta);
        for (int i = 0; i < f.length(); i++){
            try{
                System.out.println((char)fr.read());
            }
            catch (IOException e){
                System.err.println("Problemas con el archivo.");
            }
        }
        try{
            fr.close();
        }
        catch (IOException e){
            System.err.println("Problemas con el fichero " + f.getName());
        }
    }

    public FileReader creacionObjetoFileReader(String ruta){
        FileReader fr = null;
        try{
            fr = new FileReader(ruta);
        }
        catch(FileNotFoundException e){
            System.err.println("No existe el fichero.");
        }
        return fr;
    }

    public File creacionObjetoFile(String ruta){
        File f = new File(ruta);
        return f;
    }
}
