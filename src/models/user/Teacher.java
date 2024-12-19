package models.user;

import models.degree.Degree;

import java.util.ArrayList;

public class Teacher extends User{
    private ArrayList<Degree> assignedDegrees;

    public Teacher(String dni, String name, String email, int phoneNumber, String password, Degree assignedDegree) {
        super(dni, name, email, phoneNumber, password);
        assignedDegrees = new ArrayList<>();
        assignedDegrees.add(assignedDegree);
    }

    public ArrayList<Degree> getAssignedDegrees() {
        return assignedDegrees;
    }

    public void setAssignedDegrees(ArrayList<Degree> assignedDegrees) {
        this.assignedDegrees = assignedDegrees;
    }

    @Override
    public String getRole() {
        return "Teacher";
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "assignedDegrees=" + assignedDegrees +
                "} " + super.toString();
    }
}
