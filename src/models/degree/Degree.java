package models.degree;

import java.util.ArrayList;




public class Degree {
    private int idDegree;
    private DegreeType degreeType;
    private String description;
    private ArrayList<Subject> subjects;
    private static int counterDegree = 0;


    public enum DegreeType{
        DAM,ASIX,SMIX
    }

    public Degree(String degreeName) {
        this.idDegree = counterDegree++;
        switch (degreeName){
            case "DAM":
                degreeType = DegreeType.DAM;
                subjects = new ArrayList<>();
                subjects.add(new Subject("Sistemas Informaticos", "ASDADASD"));
                subjects.add(new Subject("Bases de Datos", "ASDADASD"));
                subjects.add(new Subject("Programacion", "ASDADASD"));
                description = "Desarrollo de aplicaciones multiplataformas";
                break;
            case "ASIX":
                degreeType = DegreeType.ASIX;
                subjects = new ArrayList<>();
                subjects.add(new Subject("Gestion de Bases de Datos", "ASDADASD"));
                subjects.add(new Subject("Administracion de Sistemas Operativos", "ASDADASD"));
                subjects.add(new Subject("Planificacion y Administracion de Redes", "ASDADASD"));
                description = "Administracion de Sistemas Informatico en Redes";
                break;
            case "SMIX":
                degreeType = DegreeType.SMIX;
                subjects = new ArrayList<>();
                subjects.add(new Subject("Montajes y mantenimientos de Equipos", "ASDADASD"));
                subjects.add(new Subject("Sistemas Operativos Monolito", "SADFDASD"));
                subjects.add(new Subject("Redes Locales", "ASDADASD"));
                description = "Sistemas microinformaticos y Redes";
                break;
            default:
                throw new IllegalArgumentException("The degree name doesn't exist!");
        }
        this.description = description;
    }

    public DegreeType getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(DegreeType degreeType) {
        this.degreeType = degreeType;
    }

    public int getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(int idDegree) {
        this.idDegree = idDegree;
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
                ", name='" + degreeType + '\'' +
                ", description='" + description + '\'' +
                ", subjects='" + subjects + '\'' +
                '}';
    }

}
