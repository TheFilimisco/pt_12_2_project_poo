package models.user;

import models.degree.Degree;

public class Student extends User{
    private Degree assignedDegree;

    public Student(String dni, String name, String email, int phoneNumber, String password, Degree assignedDegree) {
        super(dni, name, email, phoneNumber, password);
        this.assignedDegree = assignedDegree;
    }

    public Degree getAssignedDegree() {
        return assignedDegree;
    }

    public void setAssignedDegree(Degree assignedDegree) {
        this.assignedDegree = assignedDegree;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public String toString() {
        return "Student{" +
                "assignedDegree=" + assignedDegree +
                "} " + super.toString();
    }

}
