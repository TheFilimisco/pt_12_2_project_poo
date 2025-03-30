package controller.servicesubject;

import models.degree.Degree;
import models.degree.Subject;

import java.util.HashMap;

public class ManagerSubject implements IServiceManagerSubject {
    final private HashMap<Integer, Subject> subjects;

    public ManagerSubject() {
        subjects = new HashMap<>();
    }

    @Override
    public Subject addSubject(Subject subject) {
        return subjects.put(subject.getIdSubject(), subject);
    }

    @Override
    public boolean deleteSubject(Subject subject) {
        return subjects.remove(subject.getIdSubject(), subject);
    }

    @Override
    public Subject updateSubject(Subject updateSubject) {
        return subjects.put(updateSubject.getIdSubject(), updateSubject);
    }

    @Override
    public void printSubjects() {
        subjects.forEach((k,v)->{
            System.out.println(k + " : " + v.getName() + " : " + v.getDescription());
        });
    }

    @Override
    public Subject getSubject(Integer keySubject) {
        return subjects.get(keySubject);
    }
}
