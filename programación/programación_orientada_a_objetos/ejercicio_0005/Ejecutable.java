import java.util.ArrayList;

public class Ejecutable {

    public static void main(String[] args) {

        Ejecutable e1 = new Ejecutable();

        Electrodomestico[] arrayObjetos = e1.creacionArrayElectrodomesticos();

        e1.imprimirCadaGrupoObjetosPrecio(arrayObjetos);

    }

    public Electrodomestico[] creacionArrayElectrodomesticos(){
        Electrodomestico[] arrayE1 = new Electrodomestico[10];

        //Asigna a cada posición un objeto de las clases anteriores con los valores que quieras.
        var l1 = new Lavadora(20, "azul", 'B', 30, 50);
        System.out.println("Comprovación suma l1: " + (20 + 80 + 50 + 50));
        System.out.println("El precio final de l1 es: " + l1.precioFinal());

        var l2 = new Lavadora(4, "rosa", 'D', 40, 30.0);
        var l3 = new Lavadora(50, "amarillo", 'F', 30, 50.3);
        var l4 = new Lavadora(53, "marron", 'S', 45, 4.2);
        var l5 = new Lavadora(59, "blanco", 'A', 49, 39.4);

        var t1 = new Televisor(40, "negro", 'A', 60, 60, true);
        System.out.println("Comprovación suma t1: " + (40 + 100 + 80 + (((40 + 100 + 80) / 100) * 30) + 50));
        System.out.println("El precio final de t1 es: " + t1.precioFinal());

        var t2 = new Televisor(49, "negro", 'D', 94, 3.5, false);
        var t3 = new Televisor(52, "fucsia", 'J', 39, 5.7, true);
        var t4 = new Televisor(51, "gris", 'F', 458, 8.2, false);
        var t5 = new Televisor(29, "verde", 'J', 39, 3.2, true);

        arrayE1[0] = l1;
        arrayE1[1] = t1;
        arrayE1[2] = l2;
        arrayE1[3] = t2;
        arrayE1[4] = l3;
        arrayE1[5] = t3;
        arrayE1[6] = l4;
        arrayE1[7] = t4;
        arrayE1[8] = l5;
        arrayE1[9] = t5;

        return arrayE1;
    }

    public void imprimirCadaGrupoObjetosPrecio(Electrodomestico[] arrayObjetos){

        ArrayList<Integer> arrayPreciosLavadoras = new ArrayList<>();
        ArrayList<Integer> arrayPreciosTelevisores = new ArrayList<>();

        int precioTodasLavadoras = 0;
        int precioTodosTelevisores = 0;
        int precioTodosElectrodomesticos = 0;

        for(int i = 0; i < arrayObjetos.length; i++){

            if(arrayObjetos[i].getClass().equals(Lavadora.class)){
                precioTodasLavadoras = precioTodasLavadoras + arrayObjetos[i].precioFinal();
                precioTodosElectrodomesticos = precioTodosElectrodomesticos + arrayObjetos[i].precioFinal();
                arrayPreciosLavadoras.add(arrayObjetos[i].precioFinal());

            }

            if(arrayObjetos[i].getClass().equals(Televisor.class)){
                precioTodosTelevisores = precioTodosTelevisores + arrayObjetos[i].precioFinal();
                precioTodosElectrodomesticos = precioTodosElectrodomesticos + arrayObjetos[i].precioFinal();
                arrayPreciosTelevisores.add(arrayObjetos[i].precioFinal());
            }
        }
        System.out.println("Listado de los precios de las lavadoras: " + arrayPreciosLavadoras);
        System.out.println("El precio de todas las lavadoras es " + precioTodasLavadoras + ".");
        System.out.println("Listado de los precios de los televisores: " + arrayPreciosTelevisores);
        System.out.println("El precio de todos los televisores es " + precioTodosTelevisores + ".");
        System.out.println("El precio de todos los electrodomésticos es " + precioTodosElectrodomesticos + ".");
        System.out.println("El precio de todos los electrodomésticos es " + (precioTodasLavadoras + precioTodosTelevisores) + ".");

    }

}