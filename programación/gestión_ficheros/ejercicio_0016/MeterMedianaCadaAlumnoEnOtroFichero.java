package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.MeterMedianaCadaAlumnoEnOtroFichero;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class MeterMedianaCadaAlumnoEnOtroFichero {

    private static final String RUTA = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/MeterMedianaCadaAlumnoEnOtroFichero/Notas.txt";
    private static final String RUTA_ESCRIBIR = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/MeterMedianaCadaAlumnoEnOtroFichero/NotasMedianasCadaAlumno.txt";

    public static void main(String[] args){
        MeterMedianaCadaAlumnoEnOtroFichero programa = new MeterMedianaCadaAlumnoEnOtroFichero();
        programa.inici();
    }

    public void inici(){
        meterMedianaCadaAlumno(RUTA, RUTA_ESCRIBIR);
    }

    public static void meterMedianaCadaAlumno(String ruta, String rutaArchivoEscribir){
        File f = new File(ruta);
        try(Scanner lectorFichero = new Scanner(f);
            PrintStream objetoPrint = new PrintStream(rutaArchivoEscribir)){
            int caminandoHaciaElValor = 1;
            int cantidadNotasAlumno = 0;
            double sumatorioNotasAlumno = 0.0;
            double mediaAlumno = 0.0;
            while(lectorFichero.hasNext()){
                String valor = lectorFichero.next();
                if (caminandoHaciaElValor >=1 && caminandoHaciaElValor <=2){
                    objetoPrint.print(valor + " ");
                }
                if (caminandoHaciaElValor == 3){
                    //guardo el valor en la variable cantidadNotasAlumno
                    cantidadNotasAlumno = Integer.parseInt(valor);
                }
                if (caminandoHaciaElValor > 3 && !valor.equals("-1")){
                    //sumo las notas del alumno
                    sumatorioNotasAlumno = sumatorioNotasAlumno + Double.parseDouble(valor);
                }
                if (valor.equals("-1")){
                    //hago la media del alumno y la meto en el archivo NotasMedianasCadaAlumno.txt
                    mediaAlumno = sumatorioNotasAlumno / cantidadNotasAlumno;
                    objetoPrint.println(mediaAlumno);
                    //reinicio la posición
                    caminandoHaciaElValor = 0;
                    //reinicio el sumatorio de notas del alumno
                    sumatorioNotasAlumno = 0.0;
                }
                caminandoHaciaElValor++;
            }
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
