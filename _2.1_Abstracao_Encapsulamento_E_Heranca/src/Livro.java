public class Livro {
    String titulo;
    int numeroDePaginas;
    String isbn;

    Livro(String titulo, int paginas, String isbn) {
        this.titulo = titulo;
        this.numeroDePaginas = paginas;
        this.isbn = isbn;
    }

    public int retornarNumeroDePaginas() {
        return numeroDePaginas;
    }
}
