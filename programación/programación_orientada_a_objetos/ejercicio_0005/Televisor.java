public class Televisor extends Electrodomestico {

    //Constantes
    public static final boolean SINTONIZADOR_TDT_DEFECTO = false;
    public static final int PULGADA_DEFECTO = 20;

    //Atributos
    private double resolucion = PULGADA_DEFECTO;
    private boolean sintonizadorTDT = SINTONIZADOR_TDT_DEFECTO;

    //Constructor por defecto
    public Televisor() {
        super();
    }

    //Constructor con el precio y el peso. El resto por defecto.
    public Televisor(int precioBase, int peso) {
        super(precioBase, peso);
    }

    //Constructor con resolución, sintonizador TDT y la resta de atributos heredados.
    public Televisor(int precioBase, String color, char consumoEnergetico, int peso, double resolucion, boolean sintonizadorTDT) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    //Método getResolucion y getSintonizadorTDT
    public double getResolucion() {
        return resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    //Método precioFinal()

    @Override
    public int precioFinal() {
        int precioTot = super.precioFinal();

        if(resolucion > 40){
            int porcentaje = precioTot/100*30;
            precioTot = precioTot + porcentaje;
        }

        if(sintonizadorTDT == true){
            precioTot = precioTot + 50;
        }

        return precioTot;
    }
}
