package unitat6.u6_2_TractamentBasicDades.cursoProgramacionJava.AccesoAFicheros.MostrarNotaMediaEstudiantes;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
Crea un programa que muestre la nota media de un conjunto de estudiantes.
En el programa se debería ver la media de las notas de todos los estudiantes en general.
Para cada estudiante, los valores se guardan en líneas diferentes, para facilitar la comprensión, de acuerdo
al formato siguiente:
Nombre(String) Apellido(String) Número de notas(enter) Nota1(real) ... NotaN(real)
Ejemplo:
    Maria Almerich 3 4 3,5 6
    Joan Sebastià 5 4,5 8,5 5 6,5 7
    Carme Gonzàlez 4 6,5 8,75 10 9,5
 */
public class MostrarNotaMediaEstudiantes {

    public static final String RUTA = "src/unitat6/u6_2_TractamentBasicDades/cursoProgramacionJava/AccesoAFicheros/MostrarNotaMediaEstudiantes/Notas.txt";

    public static void main(String[] args){
        MostrarNotaMediaEstudiantes programa = new MostrarNotaMediaEstudiantes();
        programa.inici();
    }

    public void inici(){
        cantidadNotasGeneral_sumatorioNotasGeneral_MediaNotas(RUTA);
    }

    public void cantidadNotasGeneral_sumatorioNotasGeneral_MediaNotas(String ruta){
        File f = new File(ruta);
        int caminandoHaciaElValor = 1;
        int sumatorioCantidadNotas = 0;
        int dondeTerminanDatosAlumno = 0;
        double sumatorioNotasGeneral = 0.0;
        try(Scanner lectorScanner = new Scanner(f);){
            while(lectorScanner.hasNext()){
                String valor = lectorScanner.next();
                if (caminandoHaciaElValor == 1){
                    System.out.println("Empiezo del recuento del alumno " + valor + ".");
                }
                if (caminandoHaciaElValor == 3){
                    //meto la cantidad de notas al sumatorio
                    sumatorioCantidadNotas = sumatorioCantidadNotas + Integer.parseInt(valor);
                    //busco donde terminan los datos de este alumno
                    dondeTerminanDatosAlumno = 3 + Integer.parseInt(valor);
                    System.out.println("Este alumno tiene " + valor + " notas.");
                    System.out.println("Por tanto, sus datos ocupan " + dondeTerminanDatosAlumno + " posiciones.");
                }
                if(caminandoHaciaElValor > 3 && caminandoHaciaElValor <= dondeTerminanDatosAlumno){
                    sumatorioNotasGeneral = sumatorioNotasGeneral + Double.parseDouble(valor);
                }
                if (caminandoHaciaElValor == dondeTerminanDatosAlumno){
                    //cuando terminan los datos del alumno, reinicio el camino a 0
                    caminandoHaciaElValor = 0;
                }
                caminandoHaciaElValor++;
            }
            System.out.println("La cantidad de notas en general es de " + sumatorioCantidadNotas + ".");
            System.out.println("El sumatorio de las notas en general es de " + sumatorioNotasGeneral + ".");
            mediana(sumatorioNotasGeneral, sumatorioCantidadNotas);
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void mediana(double sumatorioNotasGeneral, int sumatorioCantidadNotas){
        double notaMedianaGeneral = sumatorioNotasGeneral / sumatorioCantidadNotas;
        System.out.println("La mediana de la clase en general es de " + notaMedianaGeneral + ".");
    }
}