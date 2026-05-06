package biblioteca;

public abstract class MaterialBiblioteca implements Prestable {

    // protected para que Libro (subclase) pueda acceder directamente
    protected String titulo;
    protected int anio;
    protected boolean prestado;

    public MaterialBiblioteca(String titulo, int anio) {
        this.titulo  = titulo;
        this.anio    = anio;
        this.prestado = false;  // todo material empieza disponible
    }

    // Getters
    public String getTitulo()  { return titulo; }
    public int    getAnio()    { return anio; }
    public boolean isPrestado(){ return prestado; }

    // prestar() y devolver() son abstractos: cada subclase los implementa
    @Override
    public abstract void prestar();

    @Override
    public abstract void devolver();
}