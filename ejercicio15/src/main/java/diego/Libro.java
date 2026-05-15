package diego;

public class Libro {
    public String isbn;
    public String titulo;
    public String autor;
    public int anio;

    public Libro(String isbn, String titulo, String autor, int anio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Libro otro = (Libro) o;
        return isbn.equals(otro.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}
