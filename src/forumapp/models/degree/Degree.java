package forumapp.models.degree;

import java.util.HashSet;
import java.util.Objects;

public class Degree {
    final private int idDegree;
    final private String nameDegree;
    final private HashSet<Subject> subjects;
    private String description;
    private static int counterDegree = 0;

    public Degree(String nameDegree, String description) {
        idDegree = counterDegree++;
        this.nameDegree = nameDegree;
        this.description = description;
        subjects = new HashSet<>();
    }

    public int getIdDegree() {
        return idDegree;
    }

    public String getNameDegree() {
        return nameDegree;
    }

    public HashSet<Subject> getSubjects() {
        return subjects;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getCounterDegree() {
        return counterDegree;
    }

    public static void setCounterDegree(int counterDegree) {
        Degree.counterDegree = counterDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Degree degree = (Degree) o;
        return idDegree == degree.idDegree;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idDegree);
    }

    @Override
    public String toString() {
        return "Degree{" +
                "idDegree=" + idDegree +
                ", nameDegree='" + nameDegree + '\'' +
                ", subjects=" + subjects +
                ", description='" + description + '\'' +
                '}';
    }
}
