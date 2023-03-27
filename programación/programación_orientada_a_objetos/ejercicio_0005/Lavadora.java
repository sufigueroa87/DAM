public class Lavadora extends Electrodomestico{

    //Constantes
    public static final double CARGA_LAVADORA_DEFECTO = 5.0;

    //Atributos
    private double carga = CARGA_LAVADORA_DEFECTO;

    //Constructor defecto
    public Lavadora(){
        super();
    }

    //Constructor con precio y peso, resto por defecto
    public Lavadora(int precioBase, int peso){
        super(precioBase, peso);//Llamo al constructor de su superclase Electrodomestico
    }

    //Constructor con la carga y otros atributos heredados
    public Lavadora(int precioBase, String color, char consumoEnergetico, int peso, double carga){
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    //Método getCarga()
    public double getCarga() {
        return carga;
    }

    //Método precioFinal()
    @Override
    public int precioFinal() {
        int precioTot = super.precioFinal();
        if(carga > 40){
            precioTot = precioTot + 50;
        }
        return precioTot;
    }
}