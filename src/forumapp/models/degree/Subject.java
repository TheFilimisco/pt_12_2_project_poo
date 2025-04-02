package forumapp.models.degree;

import java.util.Objects;

public class Subject {
    final private int idSubject;
    final private String name;
    private String description;
    private static int counterDegree = 0;

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
        idSubject = counterDegree++;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return idSubject == subject.idSubject;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idSubject);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSubject=" + idSubject +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
