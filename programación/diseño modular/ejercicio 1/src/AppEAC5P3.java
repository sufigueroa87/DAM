
import utils.es.Menu;

public class AppEAC5P3 {

    public static void main(String[] args) {
        AppEAC5P3 programa = new AppEAC5P3();
        programa.inici();
    }

    private void inici() {
        boolean programaFinalitzat = false;
        while (!programaFinalitzat) {
            Menu.mostrarMenu();
            int opcioTriada = Menu.triarOpcioMenu();
            if (opcioTriada != 0) {
                Menu.executarOpcioMenu(opcioTriada);
            } else {
                Menu.executarOpcioMenu(opcioTriada);
                programaFinalitzat = true;
            }
        }
    }
}