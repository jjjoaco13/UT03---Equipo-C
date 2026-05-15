package diego;

public class Alumno {
    private int id;
    private String fullName;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno otro = (Alumno) o;
        return id == otro.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
