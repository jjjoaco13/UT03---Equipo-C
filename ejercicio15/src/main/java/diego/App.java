package diego;
import java.util.HashSet;
import java.util.Set;

public class App 
{
    public static void main( String[] args )
    {
        Set<Libro> libros = new HashSet<>();
        Libro l1 = new Libro("978-3-16-148410-0", "Matematica", "Diego", 2020);
        Libro l2 = new Libro("978-3-16-148410-0", "Fisica", "Lautaro", 1932);
        libros.add(l1);
        libros.add(l2);
        System.out.println("Número de libros en el conjunto: " + libros.size()); // Debería imprimir 1, ya que l1 y l2 son iguales según equals()
    }
}
