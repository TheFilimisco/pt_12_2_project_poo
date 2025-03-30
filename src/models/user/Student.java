package models.user;

import models.degree.Degree;

public class Student extends User{
    private Degree assignedDegree;

    public Student(String dni, String name, String email, String phoneNumber, String password, Degree assignedDegree) {
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
    public String toString() {
        return "Student{" +
                "assignedDegree=" + assignedDegree.getNameDegree() +
                "} " + super.toString();
    }

//    public static void main(String[] args) {
//        Student student = new Student("99999999X", "Steven", "nystepro1@gmail.com",999999999,"12345678", new Degree("DAM"));
//        System.out.println(student);
//
//    }

}
