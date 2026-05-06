package biblioteca;

public class Libro extends MaterialBiblioteca {

    private String autor;
    private String isbn;

    public Libro(String titulo, int anio, String autor, String isbn) {
        super(titulo, anio);
        this.autor = autor;
        this.isbn  = isbn;
    }

    public String getAutor() { return autor; }
    public String getIsbn()  { return isbn; }

    public void setAutor(String autor) { this.autor = autor; }
    public void setIsbn(String isbn)   { this.isbn  = isbn; }

    @Override
    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println("Libro \"" + titulo + "\" prestado correctamente.");
        } else {
            System.out.println("El libro \"" + titulo + "\" ya está prestado.");
        }
    }

    @Override
    public void devolver() {
        if (prestado) {
            prestado = false;
            System.out.println("Libro \"" + titulo + "\" devuelto correctamente.");
        } else {
            System.out.println("El libro \"" + titulo + "\" no estaba prestado.");
        }
    }

    @Override
    public String toString() {
        return "[LIBRO] " + titulo + " | Autor: " + autor +
               " | ISBN: " + isbn + " | Anio: " + anio +
               " | Estado: " + (prestado ? "Prestado" : "Disponible");
    }
}