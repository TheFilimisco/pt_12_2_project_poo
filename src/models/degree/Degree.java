package models.degree;

import java.util.ArrayList;

public class Degree {
    private int idDegree;
    private String name;
    private String description;
    private ArrayList<Subject> subjects;
    private static int counterDegree = 0;

    public Degree(String name, String description) {
        this.idDegree = counterDegree++;
        this.name = name;
        this.description = description;
        subjects = new ArrayList<>();
    }


    public int getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(int idDegree) {
        this.idDegree = idDegree;
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

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "idDegree=" + idDegree +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", subjects='" + subjects + '\'' +
                '}';
    }
}
