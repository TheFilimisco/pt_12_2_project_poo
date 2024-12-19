package models.degree;

public class Subject {
    private int idSubject;
    private String name;
    private String description;
    private static int counterDegree = 0;

    public Subject(String name, String description) {
        this.idSubject = counterDegree++;
        this.name = name;
        this.description = description;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
