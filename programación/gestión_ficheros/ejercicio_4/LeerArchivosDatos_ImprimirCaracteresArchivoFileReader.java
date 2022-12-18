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
        File f = creacionObjetoFile(System.getProperty("user.dir") + File.separator + "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/LeerArchivosDatos_ImprimirCaracteresArchivoFileReader/lecturaCaracteresPorSeparado.txt");
        FileReader fr = creacionObjetoFileReader(System.getProperty("user.dir") + File.separator + "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/LeerArchivosDatos_ImprimirCaracteresArchivoFileReader/lecturaCaracteresPorSeparado.txt");
        imprimirCaracteresArchivoFileReader(f, fr);
    }

    public void imprimirCaracteresArchivoFileReader(File f, FileReader fr){
        for (int i = 0; i < f.length(); i++){
            try{
                System.out.println((char)fr.read());
            }
            catch (IOException e){
                System.err.println("Problemas con el archivo.");
            }
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
