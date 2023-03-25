public class Libro {

    public static final String ERROR_MISMA_CANTIDAD_PAGINAS = "E: Los libros tienen la misma cantidad de páginas.";
    //Atributos
    private String ISBN;
    private String titulo;
    private String autor;
    private int numPaginas;

    //Constructores
    public Libro() {
    }

    public Libro(String ISBN, String titulo, String autor, int numPaginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    //Getters y Setters
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    //Método toString()
    @Override
    public String toString() {
        return "El libro con ISBN " + ISBN + " creado por el autor " + autor + " tiene " + numPaginas + ".";
    }

    //Método libro con más páginas
    public void libroMasPaginas(Libro a, Libro b){
        Libro libroMasPaginas = new Libro();
        if (a.getNumPaginas() > b.getNumPaginas()){
            libroMasPaginas = a;
        } else if (a.getNumPaginas() == b.getNumPaginas()) {
            System.out.println(ERROR_MISMA_CANTIDAD_PAGINAS);
        } else {
            libroMasPaginas = b;
        }

        if (libroMasPaginas.getTitulo() != null){
            System.out.println("El libro con más páginas es " + libroMasPaginas.getTitulo() + ".");
        }
    }
}
