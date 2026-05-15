package diego;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testEqualsMismoIsbn()
    {
        Libro l1 = new Libro("978-3-16-148410-0", "Matematica", "Diego", 2020);
        Libro l2 = new Libro("978-3-16-148410-0", "Fisica", "Lautaro", 1932);
        assertTrue(l1.equals(l2)); // Debería ser true, ya que ambos libros tienen el mismo ISBN
    }

    @Test
    public void testHashCodeMismoIsbn()
    {
        Libro l1 = new Libro("978-3-16-148410-0", "Matematica", "Diego", 2020);
        Libro l2 = new Libro("978-3-16-148410-0", "Fisica", "Lautaro", 1932);
        assertTrue(l1.hashCode() == l2.hashCode()); // Debería ser true, ya que ambos libros tienen el mismo ISBN
    }
    
    @Test
    public void testLibrosDistintos() {
        Libro l1 = new Libro("978-3-16-148410-0", "Matematica", "Diego", 2020);
        Libro l2 = new Libro("978-1-23-456789-7", "Fisica", "Lautaro", 1932);
        assertTrue(!l1.equals(l2)); // Debería ser false, ya que ambos libros tienen ISBN diferentes
    }

    @Test
    public void testHashSetNoPermiteDuplicados() {
        Set<Libro> libros = new HashSet<>();
        Libro l1 = new Libro("978-3-16-148410-0", "Matematica", "Diego", 2020);
        Libro l2 = new Libro("978-3-16-148410-0", "Fisica", "Lautaro", 1932);
        libros.add(l1);
        libros.add(l2);
        assertTrue(libros.size() == 1); // Debería ser 1, ya que l1 y l2 son considerados iguales
    }

    @Test
    public void testReflexividad() {
        Libro l1 = new Libro("978-3-16-148410-0", "Matematica", "Diego", 2020);
        assertTrue(l1.equals(l1)); // Debería ser true, un objeto siempre es igual a sí mismo
    }

    @Test
    public void testEqualsConNull() {
        Libro l1 = new Libro("978-3-16-148410-0", "Matematica", "Diego", 2020);
        assertTrue(!l1.equals(null)); // Debería ser false, ningún objeto es igual a null
    }

    @Test
    public void testConsistencia() {
        Libro l1 = new Libro("978-3-16-148410-0", "Matematica", "Diego", 2020);
        Libro l2 = new Libro("978-3-16-148410-0", "Matematica", "Diego", 2020);
        for (int i = 0; i < 10; i++) {
            assertTrue(l1.equals(l2)); // Debería ser true en todas las iteraciones, la igualdad debe ser consistente
        }
    }
}
